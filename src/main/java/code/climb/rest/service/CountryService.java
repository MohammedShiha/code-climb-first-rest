package code.climb.rest.service;

import code.climb.rest.entity.Country;
import code.climb.rest.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String countryCode) {
        return countryRepository.findById(countryCode).orElse(null);
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

}
