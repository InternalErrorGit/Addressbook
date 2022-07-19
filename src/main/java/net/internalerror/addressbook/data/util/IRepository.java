package net.internalerror.addressbook.data.util;

import org.springframework.data.repository.CrudRepository;

public interface IRepository<Entity extends AEntity> extends CrudRepository<Entity, Long> {
}
