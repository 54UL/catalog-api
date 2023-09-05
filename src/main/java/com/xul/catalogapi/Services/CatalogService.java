package com.xul.catalogapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xul.catalogapi.Entities.CatalogItem;
import com.xul.catalogapi.Repository.CatalogRepository;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository personRepository;
    
    public List<CatalogItem> getAll() 
    {
        return personRepository.findAll();
    }
    
    public CatalogItem save(CatalogItem catalog) {
        return personRepository.save(catalog);
    }    
}
