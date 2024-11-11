package com.olapie.beerstore.infra.postgres;

import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.id.BeerId;
import com.olapie.beerstore.domain.repository.BeerRepository;

import java.util.Optional;

public class BeerRepositoryImpl implements BeerRepository {
    @Override
    public Optional<Beer> get(BeerId beerId) {
        return Optional.empty();
    }
}
