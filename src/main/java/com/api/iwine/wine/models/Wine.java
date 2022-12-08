package com.api.iwine.wine.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Wine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, unique = true, length = 100)
  private String name;

  @Column(nullable = false, length = 20)
  private String type;

  @Column(nullable = false, length = 30)
  private String grape;

  @Column(nullable = false, length = 30)
  private String country;

  @Column(nullable = false, length = 4)
  private Float alcoholContent;

  @Column(nullable = false, length = 4)
  private Integer volume;

  @Column(nullable = false, length = 4)
  private Float rate;

  @Column(nullable = false, length = 500)
  private String description;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Float getAlcoholContent() {
    return alcoholContent;
  }

  public void setAlcoholContent(Float alcoholContent) {
    this.alcoholContent = alcoholContent;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public Float getRate() {
    return rate;
  }

  public void setRate(Float rate) {
    this.rate = rate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}
