package net.internalerror.addressbook.data.service;

import net.internalerror.addressbook.data.entity.City;
import net.internalerror.addressbook.data.repo.CityRepository;
import net.internalerror.addressbook.data.util.AService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CityService extends AService<City, CityRepository> {
    public CityService(CityRepository repository) {
        super(repository);
    }

    @Override
    public List<City> filter(String filter) {
        return read().stream().filter(object -> object.filter(filter)).collect(Collectors.toList());
    }
}
