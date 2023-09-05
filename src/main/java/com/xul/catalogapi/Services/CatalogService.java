package com.xul.catalogapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xul.catalogapi.Entities.Catalog;
import com.xul.catalogapi.Repository.CatalogRepository;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository personRepository;
    
    public List<Catalog> getAll() 
    {
        return personRepository.findAll();
    }
    
    public Catalog save(Catalog catalog) {
        return personRepository.save(catalog);
    }    
}
