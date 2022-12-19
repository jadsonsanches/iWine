package com.api.iwine.market.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.iwine.market.dtos.MarketDto;
import com.api.iwine.market.models.Market;
import com.api.iwine.market.services.MarketService;
import com.api.iwine.wine.services.WineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/market")
public class MarketController {

  private final MarketService marketService;

  public MarketController(MarketService marketService) {
    this.marketService = marketService;
  }

  @GetMapping
  public List<Market> findAll() {
    return marketService.findAll();
  }

  @GetMapping("/{id}")
  public Object findByID(@PathVariable(value = "id") UUID id) {
    var market = marketService.findById(id);

    if (!market.isPresent())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Market not found.");

    return ResponseEntity.status(HttpStatus.OK).body(market);
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody @Valid MarketDto marketDto) {
    Market market = new Market();

    BeanUtils.copyProperties(marketDto, market);
    market.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    market.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(marketService.save(market));
  }

}
