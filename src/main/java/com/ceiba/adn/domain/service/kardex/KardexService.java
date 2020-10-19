package com.ceiba.adn.domain.service.kardex;

import com.ceiba.adn.domain.Kardex;
import com.ceiba.adn.domain.repository.KardexRepository;
import java.util.Calendar;

public class KardexService {

    private final static int DAY_TWENTY = 20;
    private final static int DISCOUNT_PERCENTAGE = 20;
    private final KardexRepository kardexRepository;

    public KardexService(KardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    public Kardex createOrUpdate(Kardex kardex) {

        if (!kardex.isEntryOrExit()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(kardex.getTransaction());
            final int dayMonth = calendar.get(Calendar.DAY_OF_MONTH);

            if (DAY_TWENTY == dayMonth) {
                final double price = kardex.getPrice();
                final double discount = ((price * DISCOUNT_PERCENTAGE) / 100);
                kardex.setPrice((price - discount));
            }
        }

        return this.kardexRepository.createOrUpdate(kardex);
    }
}
