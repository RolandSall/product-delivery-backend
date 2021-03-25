package com.rolandsall.inventory_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/test")
    public String greeting(){
        return "Inventory-Service Is Up";
    }

}
