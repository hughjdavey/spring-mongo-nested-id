package hello.entities;

import org.springframework.data.annotation.Id;

public class NestedEntity {

    @Id
    public String id;

    public int anInt;

    public NestedEntity(final int anInt) {
        this.anInt = anInt;
    }

    public String getId() {
        return id;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NestedEntity that = (NestedEntity) o;

        if (anInt != that.anInt) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + anInt;
        return result;
    }

    @Override
    public String toString() {
        return "hello.entities.NestedObject{" +
                "id='" + id + '\'' +
                ", anInt=" + anInt +
                '}';
    }
}
