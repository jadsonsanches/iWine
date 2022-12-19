package com.api.iwine.market.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketDto {

  @NotBlank
  @Size(max = 100)
  private String name;

  private boolean acceptTicket;

  @Size(max = 50)
  private String lat;

  @Size(max = 50)
  private String lon;

  @Size(max = 200)
  private String address;

  @NotBlank
  @Size(max = 200)
  private String city;
  
}
