package code.climb.rest.controller;

import code.climb.rest.entity.Country;
import code.climb.rest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Iterable<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable("code") String countryCode) {
        return countryService.getCountry(countryCode);
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable("code") String countryCode) {
        countryService.deleteCountry(countryCode);
        return countryCode + " was deleted.";
    }
}
