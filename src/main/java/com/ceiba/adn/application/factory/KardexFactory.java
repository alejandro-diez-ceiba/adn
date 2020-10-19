package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.KardexCommand;
import com.ceiba.adn.domain.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class KardexFactory {

    public Kardex create(KardexCommand kardexCommand) {

        Provider provider = null;
        if (kardexCommand.getProvider() != 0) {
            provider = new Provider(kardexCommand.getProvider());
        }

        Customer customer = null;
        if (kardexCommand.getCustomer() != 0) {
            customer = new Customer(kardexCommand.getCustomer());
        }

        return new Kardex(
                kardexCommand.getId(),
                new Date(kardexCommand.getTransaction()),
                kardexCommand.isEntryOrExit(),
                kardexCommand.getQuantity(),
                kardexCommand.getPrice(),
                provider,
                customer,
                new Game(kardexCommand.getGame())
        );
    }
}
