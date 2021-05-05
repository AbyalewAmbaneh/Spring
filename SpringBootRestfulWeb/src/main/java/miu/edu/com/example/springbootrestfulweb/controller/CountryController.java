package miu.edu.com.example.springbootrestfulweb.controller;

import miu.edu.com.example.springbootrestfulweb.domain.Country;
import miu.edu.com.example.springbootrestfulweb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    CountryRepository repository;

    @GetMapping
    public List<Country> countryList(){
        return repository.findAll();
    }
}
