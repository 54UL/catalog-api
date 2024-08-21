package com.xul.catalogapi.Controllers;

import com.xul.catalogapi.Components.AppState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class AppController
{
    @Autowired
    private AppState state;

    @GetMapping
    public ResponseEntity<?> currentRequestCount()
    {
        state.incrementRequestCountBy(1);

        return ResponseEntity.ok(state.getNumberOfRequests());
    }
}
