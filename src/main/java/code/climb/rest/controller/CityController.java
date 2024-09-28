package code.climb.rest.controller;

import code.climb.rest.entity.City;
import code.climb.rest.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable("id") Integer id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @PutMapping
    public City updateCity(@RequestBody @Valid City city) {
        return cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);
        return "City " + id + " was deleted.";
    }
}
