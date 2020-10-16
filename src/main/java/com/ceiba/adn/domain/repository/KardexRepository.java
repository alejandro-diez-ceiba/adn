package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Kardex;
import java.util.List;

public interface KardexRepository {

    List<Kardex> getAll();

    Kardex getById(long id);

    Kardex createOrUpdate(Kardex kardex);

    Kardex deleteById(long id);

}
