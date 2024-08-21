package com.xul.catalogapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String data;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    @JsonIgnore
    private Catalog parent;

    public CatalogItem() {

    }

    public CatalogItem(Catalog parent, String data) {
        this.parent = parent;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String value) {
        data = value;
    }

    public Catalog getParent() {
        return parent;
    }
    
    public void setParent(Catalog parent) {
        this.parent = parent;
    }
}
