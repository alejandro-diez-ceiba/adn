package com.ceiba.adn.domain.service;

import com.ceiba.adn.databuilder.KardexTestDatauilder;
import com.ceiba.adn.domain.Kardex;
import com.ceiba.adn.domain.repository.KardexRepository;
import com.ceiba.adn.domain.service.kardex.KardexService;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KardexServiceTest {

    @Test
    public void exitDoesNotApplyDiscount() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date applyDiscount = formatter.parse("19/10/2019");
        KardexTestDatauilder kardexTestDatauilder = new KardexTestDatauilder()
                .withEntryOrExit(false)
                .withTransaction(applyDiscount.getTime());
        Kardex kardex = kardexTestDatauilder.build();

        KardexRepository kardexRepository = mock(KardexRepository.class);

        when(kardexRepository.createOrUpdate(kardex)).thenReturn(kardex);
        KardexService kardexService = new KardexService(kardexRepository);

        Kardex kardexResult = kardexService.createOrUpdate(kardex);
        assertEquals(kardex.getPrice(), kardexResult.getPrice(), 2);
    }

    @Test
    public void exitApplyDiscount() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date applyDiscount = formatter.parse("20/10/2019");
        KardexTestDatauilder kardexTestDatauilder = new KardexTestDatauilder()
                .withEntryOrExit(false)
                .withTransaction(applyDiscount.getTime());
        Kardex kardex = kardexTestDatauilder.build();
        Kardex kardexRepositoryResult = kardexTestDatauilder.withPrice(100720).build();

        KardexRepository kardexRepository = mock(KardexRepository.class);

        when(kardexRepository.createOrUpdate(kardex)).thenReturn(kardexRepositoryResult);
        KardexService kardexService = new KardexService(kardexRepository);

        Kardex kardexResult = kardexService.createOrUpdate(kardex);
        assertEquals(kardexRepositoryResult.getPrice(), kardexResult.getPrice(), 2);
    }

    @Test
    public void entryDoesNotApplyDiscount() throws Exception {
        KardexTestDatauilder kardexTestDatauilder = new KardexTestDatauilder();
        Kardex kardex = kardexTestDatauilder.build();

        KardexRepository kardexRepository = mock(KardexRepository.class);

        when(kardexRepository.createOrUpdate(kardex)).thenReturn(kardex);
        KardexService kardexService = new KardexService(kardexRepository);

        Kardex kardexResult = kardexService.createOrUpdate(kardex);
        assertEquals(kardex.getPrice(), kardexResult.getPrice(), 2);
    }
}
