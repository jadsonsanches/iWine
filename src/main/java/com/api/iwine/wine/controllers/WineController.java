package com.api.iwine.wine.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.iwine.wine.models.Wine;
import com.api.iwine.wine.services.WineService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/wine")
public class WineController {

  private final WineService wineService;

  public WineController(WineService wineService) {
    this.wineService = wineService;
  }

  @GetMapping
  public List<Wine> findAll() {
    return wineService.findAll();
  }

}
