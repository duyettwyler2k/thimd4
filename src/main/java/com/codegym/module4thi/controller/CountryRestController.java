package com.codegym.module4thi.controller;

import com.codegym.module4thi.model.Country;
import com.codegym.module4thi.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/country")
public class CountryRestController {
    @Autowired
    private ICountryService countryService;
    @GetMapping
    public ResponseEntity<Iterable<Country>> showAll(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }
}
