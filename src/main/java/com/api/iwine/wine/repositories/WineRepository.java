package com.api.iwine.wine.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.iwine.wine.models.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, UUID> {

}
