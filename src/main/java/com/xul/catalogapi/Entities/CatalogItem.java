package com.xul.catalogapi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class CatalogItem 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    @NotNull
    private String data;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog parent;

    public String getData() {
        return data;
    }
    public void setData(String value) {
        data = value;
    }
}
