package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.KardexCommand;
import com.ceiba.adn.domain.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class KardexFactory {

    public Kardex create(KardexCommand kardexCommand) {
        return new Kardex(
                kardexCommand.getId(),
                new Date(kardexCommand.getTransaction()),
                kardexCommand.isEntryOrExit(),
                kardexCommand.getQuantity(),
                kardexCommand.getPrice(),
                new Provider(kardexCommand.getProvider(), null, null, 0, null, null),
                new Customer(kardexCommand.getCustomer(), null, null, 0, null, null),
                new Game(kardexCommand.getGame(), null, null, 0, null, null, null)
        );
    }
}
