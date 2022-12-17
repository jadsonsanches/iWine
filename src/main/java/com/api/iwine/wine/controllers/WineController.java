package com.api.iwine.wine.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.iwine.wine.dtos.WineDto;
import com.api.iwine.wine.models.Wine;
import com.api.iwine.wine.services.WineService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

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

  @GetMapping("/{id}")
  public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
    Optional<Wine> wine = wineService.findById(id);

    if (!wine.isPresent())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wine not found");

    return ResponseEntity.status(HttpStatus.OK).body(wine.get());
  }

  @GetMapping("/find")
  public ResponseEntity<Object> findByCountry(@RequestParam String country) {
    List<Wine> wines = wineService.findByCountry(country);

    return ResponseEntity.status(HttpStatus.OK).body(wines);
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody @Valid WineDto wine) {
    var newWine = new Wine();

    BeanUtils.copyProperties(wine, newWine);
    newWine.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    newWine.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(wineService.save(newWine));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid WineDto wineUpdate) {
    Optional<Wine> wineFinded = wineService.findById(id);

    if (!wineFinded.isPresent())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wine not found");

    Wine wine = new Wine();
    BeanUtils.copyProperties(wineUpdate, wine);
    wine.setId(wineFinded.get().getId());
    wine.setCreatedAt(wineFinded.get().getCreatedAt());
    wine.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.OK).body(wineService.save(wine));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
    Optional<Wine> wineFinded = wineService.findById(id);

    if (!wineFinded.isPresent())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wine not found");

    wineService.delete(wineFinded.get());

    return ResponseEntity.status(HttpStatus.OK).body("Wine deleted succesfully");
  }

}
