package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Game;
import java.util.List;

public interface GameRepository {

    List<Game> getAll();

    Game getById(int id);

}
