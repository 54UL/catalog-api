package com.xul.catalogapi.Controllers;

import java.util.List;

import com.xul.catalogapi.Components.AppState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xul.catalogapi.Entities.Catalog;
import com.xul.catalogapi.Services.CatalogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController 
{
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private AppState appState;

    @GetMapping
    public List<Catalog> getAllCatalogs(){
        return catalogService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> saveCatalog(@Valid @RequestBody Catalog item){
        try {
            appState.incrementRequestCountBy(1);
            return ResponseEntity.ok(catalogService.save(item));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(String.format("Invalid body e: %s", e.getMessage()));
        }
    }
}
