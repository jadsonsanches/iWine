package com.api.iwine.wine.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineDto {

  @NotBlank
  @Size(max = 100)
  private String name;

  @NotBlank
  @Size(max = 20)
  private String type;

  @NotBlank
  @Size(max = 30)
  private String grape;

  @NotBlank
  @Size(max = 30)
  private String country;

  private Float alcoholContent;

  private Integer volume;

  private Float rate;

  @NotBlank
  @Size(max = 500)
  private String description;
}
