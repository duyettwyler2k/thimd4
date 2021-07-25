package com.codegym.module4thi.controller;

import com.codegym.module4thi.model.City;
import com.codegym.module4thi.model.Country;
import com.codegym.module4thi.service.city.ICityService;
import com.codegym.module4thi.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;
    @ModelAttribute("country")
    public Iterable<Country>countries(){
        return countryService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView showListCity(){
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("city",cityService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<City>>showAllCity(){
        List<City>cities= (List<City>) cityService.findAll();
        if (cities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<City> findByIdCity(@PathVariable Long id){
        Optional<City>cityOptional=cityService.findById(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){
        Optional<City>cityOptional=cityService.findById(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> editCity(@PathVariable Long id,@RequestBody City city){
        Optional<City>cityOptional=cityService.findById(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }
}
