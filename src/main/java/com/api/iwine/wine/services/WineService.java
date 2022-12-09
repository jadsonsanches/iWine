package com.api.iwine.wine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.iwine.wine.models.Wine;
import com.api.iwine.wine.repositories.WineRepository;

@Service
public class WineService {

  private final WineRepository wineRepository;

  public WineService(WineRepository wineRepository) {
    this.wineRepository = wineRepository;
  }

  public List<Wine> findAll() {
    return wineRepository.findAll();
  }

}
