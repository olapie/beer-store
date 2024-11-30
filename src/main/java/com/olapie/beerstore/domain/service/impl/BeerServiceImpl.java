package com.olapie.beerstore.domain.service.impl;

import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.id.BeerId;
import com.olapie.beerstore.domain.model.params.AddBeerParams;
import com.olapie.beerstore.domain.model.params.UpdateBeerParams;
import com.olapie.beerstore.domain.repository.BeerRepository;
import com.olapie.beerstore.domain.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BeerServiceImpl implements BeerService {
    @Autowired
    private BeerRepository beerRepository;

    @Override
    public Optional<Beer> add(AddBeerParams params) {
        return Optional.empty();
    }

    @Override
    public void update(UpdateBeerParams params) {

    }

    @Override
    public Optional<Beer> get(BeerId id) {
        return Optional.empty();
    }
}
