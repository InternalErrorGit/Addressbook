package net.internalerror.addressbook.data.service;

import net.internalerror.addressbook.data.entity.Person;
import net.internalerror.addressbook.data.repo.PersonRepository;
import net.internalerror.addressbook.data.util.AService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PersonService extends AService<Person, PersonRepository> {

    public PersonService(PersonRepository repository, AddressService addressService, ContactService contactService) {
        super(repository);
    }

    @Override
    public List<Person> filter(String filter) {
        return read().stream().filter(object -> object.filter(filter)).collect(Collectors.toList());
    }
}
