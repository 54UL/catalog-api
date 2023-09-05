package com.xul.catalogapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xul.catalogapi.Entities.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}