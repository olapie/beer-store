package com.olapie.beerstore.domain.service;

import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.id.BeerId;
import com.olapie.beerstore.domain.model.params.AddBeerParams;
import com.olapie.beerstore.domain.model.params.UpdateBeerParams;

import java.math.BigDecimal;
import java.util.Optional;

public interface BeerService {
    Optional<Beer> add(AddBeerParams params);
    void update(UpdateBeerParams params);

    Optional<Beer> get(BeerId id);
}
