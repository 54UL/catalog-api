package com.xul.catalogapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xul.catalogapi.Entities.CatalogItem;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, Long> {
}