package com.xul.catalogapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xul.catalogapi.Entities.Catalog;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    Catalog findByName(String name);

    //TODO: FIX ME
    @Query("select c from Catalog c where c.name like %?1%")
    List<Catalog> basicSearch(String searchQuery);
}