package com.olapie.beerstore.api.controller;

import com.olapie.beerstore.api.model.AddBeerRequest;
import com.olapie.beerstore.domain.model.Beer;
import com.olapie.beerstore.domain.model.params.AddBeerParams;
import com.olapie.beerstore.domain.service.BeerService;
import com.olapie.beerstore.util.annotation.AutoLogging;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beers")
public class BeerController {
    private final static Logger logger = LoggerFactory.getLogger(BeerController.class);
    @Autowired
    BeerService beerService;

    @AutoLogging
    @PostMapping("")
    public Beer add(@Valid @RequestBody AddBeerRequest request) throws Exception {
        logger.info("adding beer: name={}, price={}", request.getName(), request.getPrice());
        var optionalBeer = beerService.add(AddBeerParams.builder().name(request.getName()).price(request.getPrice()).build());
        if (optionalBeer.isEmpty()) {
            throw new Exception("unable to add beer");
        }
        return optionalBeer.get();
    }
}