package net.internalerror.addressbook.data.service;

import net.internalerror.addressbook.data.entity.Address;
import net.internalerror.addressbook.data.repo.AddressRepository;
import net.internalerror.addressbook.data.util.AEntity;
import net.internalerror.addressbook.data.util.AService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AddressService extends AService<Address, AddressRepository> {
    public AddressService(AddressRepository repository) {
        super(repository);
    }

    @Override
    public List<Address> filter(String filter) {
        return read().stream().filter(object -> object.filter(filter)).collect(Collectors.toList());
    }
}
