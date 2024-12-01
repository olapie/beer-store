package com.olapie.beerstore.infra.postgres;

import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.id.BeerId;
import com.olapie.beerstore.domain.repository.BeerRepository;
import com.olapie.beerstore.infra.postgres.mapper.BeerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BeerRepositoryImpl implements BeerRepository {

    @Autowired
    private BeerMapper beerMapper;

    @Override
    public Optional<Beer> get(BeerId beerId) {
        var beer = beerMapper.getById(beerId.getValue());
        if (beer == null) {
            return Optional.empty();
        }
        return Optional.of(toModel(beer));
    }

    @Override
    public void save(Beer beer) {
        if (beer.getId() == null) {
           var id = beerMapper.insert(fromModel(beer));
           beer.setId(BeerId.of(id.toString()));
        } else {
            beerMapper.update(fromModel(beer));
        }
    }

    private Beer toModel(com.olapie.beerstore.infra.postgres.entity.Beer beer) {
        return Beer.builder()
                .id(BeerId.of(beer.getId()))
                .name(beer.getName())
                .price(beer.getPrice())
                .build();
    }

    private com.olapie.beerstore.infra.postgres.entity.Beer fromModel(Beer beer) {
        return com.olapie.beerstore.infra.postgres.entity.Beer.builder()
                .id(beer.getId() == null ? "" : beer.getId().getValue())
                .name(beer.getName())
                .price(beer.getPrice())
                .build();
    }
}
