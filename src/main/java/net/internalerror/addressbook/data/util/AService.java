package net.internalerror.addressbook.data.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AService<Entity extends AEntity, Repository extends IRepository<Entity>> {

    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected Repository repository;

    public AService(Repository repository) {
        this.repository = repository;
    }

    public Entity create(Entity entity) {
        LOGGER.info("create {}", entity);
        return repository.save(entity);
    }

    public Entity read(Long id) {
        LOGGER.info("read {}", id);
        Optional<Entity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            LOGGER.warn("Entity with id: '{}' not found", id);
            return null;
        }
    }

    public List<Entity> read() {
        LOGGER.info("read all");
        List<Entity> entities = new ArrayList<>();
        repository.findAll().forEach(entities::add);
        return entities;
    }

    public Entity update(Entity entity) {
        LOGGER.info("update {}", entity);
        return create(entity);
    }

    public void delete(Long id) {
        LOGGER.info("delete {}", id);
        delete(read(id));
    }

    public void delete(Entity entity) {
        LOGGER.info("delete {}", entity);
        repository.delete(entity);
    }

    public abstract List<Entity> filter(String filter);
}
