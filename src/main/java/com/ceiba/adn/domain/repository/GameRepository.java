package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Game;
import java.util.List;

public interface GameRepository {

    List<Game> getAll();

    Game getById(long id);

    Game createOrUpdate(Game game);

    Game deleteById(long id);

}
