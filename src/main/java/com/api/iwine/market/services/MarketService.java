package com.api.iwine.market.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.iwine.market.models.Market;
import com.api.iwine.market.repositories.MarketRepository;

@Service
public class MarketService {

  private final MarketRepository marketRepository;

  public MarketService(MarketRepository marketRepository) {
    this.marketRepository = marketRepository;
  }

  public List<Market> findAll() {
    return marketRepository.findAll();
  }

  public Optional<Market> findById(UUID id) {
    return marketRepository.findById(id);
  }

  public Object save(Market market) {
    return marketRepository.save(market);
  }

}
