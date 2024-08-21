package com.xul.catalogapi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xul.catalogapi.Entities.Catalog;
import com.xul.catalogapi.Entities.CatalogItem;
import com.xul.catalogapi.Repository.CatalogItemRepository;
import com.xul.catalogapi.Repository.CatalogRepository;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private CatalogItemRepository catalogItemRepository;

    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }
    
    public Catalog save(Catalog catalog) {
        Catalog newCatalog = catalogRepository.save(catalog); // Save Catalog first
        List<CatalogItem> repoItems = new ArrayList<>(catalog.getItems());
        
        repoItems.forEach(item -> {
            item.setParent(newCatalog);
        });
    
        catalogItemRepository.saveAll(repoItems); // Save CatalogItems
        return newCatalog;
    }

    public Catalog findByName(String name) {
        return catalogRepository.findByName(name);
    }

    public List<Catalog> basicSearch(String search) {
        return catalogRepository.basicSearch(search);
    }
}
