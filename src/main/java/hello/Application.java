package hello;

import hello.entities.Entity;
import hello.entities.NestedEntity;
import hello.repositories.EntityRepository;
import hello.repositories.NestedEntityRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Objects.isNull;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private NestedEntityRepository nestedEntityRepository;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nestedEntityRepository.deleteAll();
        final NestedEntity nestedEntity = nestedEntityRepository.save(new NestedEntity(100));

        entityRepository.deleteAll();
        final Entity entity = entityRepository.save(new Entity("foo", nestedEntity));

        final Entity entityById_String = entityRepository.findById(entity.getId());
        final Entity entityById_ObjectId = entityRepository.findById(new ObjectId(entity.getId()));
        final Entity entityByNestedId_String = entityRepository.findByNestedEntityId(nestedEntity.getId());
        final Entity entityByNestedId_ObjectId = entityRepository.findByNestedEntityId(new ObjectId(nestedEntity.getId()));

        System.out.println();
        nullPrinter("entityById_String", entityById_String);
        nullPrinter("entityById_ObjectId", entityById_ObjectId);
        nullPrinter("entityByNestedId_String", entityByNestedId_String);
        nullPrinter("entityByNestedId_ObjectId", entityByNestedId_ObjectId);
        System.out.println();
    }

    private void nullPrinter(final String objectName, final Entity entity) {
        System.out.println(objectName + " was " + consistentIndent(objectName) + (isNull(entity) ? "null" : "not null"));
    }

    private String consistentIndent(final String string) {
        final StringBuilder sb = new StringBuilder();
        final int indentation = 30 - string.length();

        for (int i = 0; i < indentation; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}