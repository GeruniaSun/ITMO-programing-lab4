package lab4;

public class Carlson extends Person implements Flyable {

    public Carlson() {
        super("Carlson", Character.POSITIVE);
    }

    @Override
    public void subEnergy(double sub) throws CarlsonOutOfFoodException{
        if (this.energy - sub <= 0) {
            throw new CarlsonOutOfFoodException(this.getName() + " is not " + this.getName() + " anymore");
        } else {
            this.energy = this.energy - sub;
        }
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " flying!");
    }

    @Override
    public void land(Place place) {
        System.out.println(this.getName() + " lands " + place.getDescription());
        place.lands(this);
    }

    @Override
    public void takeOf(Place place) {
        System.out.println(this.getName() + " taking of " + place.getDescription());
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 7;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}