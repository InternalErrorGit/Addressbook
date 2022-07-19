package net.internalerror.addressbook.data.service;

import net.internalerror.addressbook.data.entity.Contact;
import net.internalerror.addressbook.data.repo.ContactRepository;
import net.internalerror.addressbook.data.util.AService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ContactService extends AService<Contact, ContactRepository> {
    public ContactService(ContactRepository repository) {
        super(repository);
    }

    @Override
    public List<Contact> filter(String filter) {
        return read().stream().filter(object -> object.filter(filter)).collect(Collectors.toList());
    }
}
