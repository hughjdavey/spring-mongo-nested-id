package hello.repositories;

import hello.entities.Entity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String> {

    Entity findById(final String id);

    Entity findById(final ObjectId id);

    Entity findByNestedEntityId(final String id);

    Entity findByNestedEntityId(final ObjectId id);
}
