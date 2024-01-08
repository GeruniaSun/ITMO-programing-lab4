package lab4;

import java.util.Arrays;
import java.util.Objects;

public class Table implements Dreamable {
    private final String material;
    private double food;
    private Person[] seaters;
    private String location;

    public Table(String material, String location, double food){
        this.material = material;
        this.location = location;
        this.food = food;
    }
    public Table(String material, String location, double food, Person... seaters){
        this.material = material;
        this.location = location;
        this.food = food;
        this.seaters = seaters;
    }
    public double getFood(){
        return this.food;
    }

    public void setFood(double food){
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person[] getSeaters(){
        return this.seaters;
    }

    public void setSeaters(Person... seaters){
        this.seaters = seaters;
    }

    public void addSeaters(Person... seaters){
        Person[] result = new Person[this.seaters.length + seaters.length];

        System.arraycopy(this.seaters, 0, result, 0, this.seaters.length);
        System.arraycopy(seaters, 0, result, this.seaters.length, seaters.length);

        this.seaters = result;
    }

    public void printSeaters() {
        System.out.println(Arrays.toString(this.getSeaters())
                .replace("[", "").replace("]", "") + " eats together");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Table other)) return false;
        return Double.compare(getFood(), other.getFood()) == 0 && Objects.equals(material, other.material)
                && Arrays.equals(getSeaters(), other.getSeaters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, getFood()) +
                19 * Arrays.hashCode(getSeaters());

    }

    @Override
    public String toString() {
        return "table in " + this.getLocation();
    }
}
