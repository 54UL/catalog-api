package com.xul.catalogapi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class CatalogItem 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String PairKey;
    
    @NotNull
    private String PairValue;

    public String getPairKey() {
        return PairKey;
    }
    public void setPairKey(String key) {
        PairKey = key;
    }
    public String getPairValue() {
        return PairValue;
    }
    public void setPairValue(String value) {
        PairValue = value;
    }
}
