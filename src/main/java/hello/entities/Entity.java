package hello.entities;

import org.springframework.data.annotation.Id;

public class Entity {

    @Id
    public String id;

    public String aString;

    public NestedEntity nestedEntity;

    public Entity(final String aString, final NestedEntity nestedEntity) {
        this.aString = aString;
        this.nestedEntity = nestedEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public NestedEntity getNestedEntity() {
        return nestedEntity;
    }

    public void setNestedEntity(NestedEntity nestedEntity) {
        this.nestedEntity = nestedEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (aString != null ? !aString.equals(entity.aString) : entity.aString != null)
            return false;
        return nestedEntity != null ? nestedEntity.equals(entity.nestedEntity) : entity.nestedEntity == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aString != null ? aString.hashCode() : 0);
        result = 31 * result + (nestedEntity != null ? nestedEntity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "hello.entities.MyObject{" +
                "id='" + id + '\'' +
                ", aString='" + aString + '\'' +
                ", nestedObject=" + nestedEntity +
                '}';
    }
}
