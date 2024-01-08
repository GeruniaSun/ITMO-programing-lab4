package lab4;

import java.util.Arrays;
import java.util.Objects;

public class Place implements Dreamable {
    private String description;
    private Person[] visitors;

    public Place(String description) {
        this.description = description;
    }

    public void lands(Flyable flyer){
        this.addVisitors((Person) flyer);
    }

    public Person[] getVisitors(){
        return this.visitors;
    }

    public void setVisitors(Person... visitors){
        this.visitors = visitors;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addVisitors(Person... seaters){
        Person[] result = new Person[this.visitors.length + seaters.length];

        System.arraycopy(this.visitors, 0, result, 0, this.visitors.length);
        System.arraycopy(seaters, 0, result, this.visitors.length, seaters.length);

        this.visitors = result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Place other)) return false;
        return Objects.equals(getDescription(), other.getDescription())
                && Arrays.equals(getVisitors(), other.getVisitors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription()) +
                17 * Arrays.hashCode(getVisitors());
    }

    @Override
    public String toString() {
        return this.description;
    }
}
