package com.api.iwine.wine.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.iwine.wine.models.Wine;
import com.api.iwine.wine.repositories.WineRepository;

import jakarta.transaction.Transactional;

@Service
public class WineService {

  private final WineRepository wineRepository;

  public WineService(WineRepository wineRepository) {
    this.wineRepository = wineRepository;
  }

  public List<Wine> findAll() {
    return wineRepository.findAll();
  }

  public Optional<Wine> findById(UUID id) {
    return wineRepository.findById(id);
  }

  @Transactional
  public Object save(Wine newWine) {
    return wineRepository.save(newWine);
  }

  @Transactional
  public void delete(Wine wine) {
    wineRepository.delete(wine);
  }
}
