package com.olapie.beerstore.domain.repository;

import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.id.BeerId;

import java.util.Optional;

public interface BeerRepository {
    Optional<Beer> get(BeerId beerId);
}
