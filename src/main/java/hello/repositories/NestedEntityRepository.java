package hello.repositories;

import hello.entities.NestedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NestedEntityRepository extends MongoRepository<NestedEntity, String> {
}
