package com.api.iwine.market.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.iwine.market.models.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, UUID> {
  
}
