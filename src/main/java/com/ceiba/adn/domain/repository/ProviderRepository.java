package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Provider;
import java.util.List;

public interface ProviderRepository {

    List<Provider> getAll();

    Provider getById(int id);

    Provider createOrUpdate(Provider provider);

    Provider deleteById(int id);

}
