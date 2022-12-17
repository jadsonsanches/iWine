package com.api.iwine.wine.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "wine")
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
}
