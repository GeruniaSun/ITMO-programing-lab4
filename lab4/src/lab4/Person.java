package lab4;

import java.util.Arrays;
import java.util.Objects;

public abstract class Person implements Dreamable {
    private final String name;
    protected double energy = 100;
    private final Character character;

    public enum Character {POSITIVE, NEGATIVE, NEUTRAL}

    public Person(String name, Character character){
        this.name = name;
        this.character = character;
    }

    public class Relation {
        private final Person receiver;
        private final String typeOfRelation;

        public Relation(String typeOfRelation, Person receiver){
            this.typeOfRelation = typeOfRelation;
            this.receiver = receiver;
        }

        public void printRelation(){
            System.out.println(name + typeOfRelation + receiver.name);
        }
    }

    public void complexRelation(String typeOfRelation, Relation subrelation){
        var relation = new Relation(typeOfRelation, subrelation.receiver){
            @Override
            public void printRelation(){
                System.out.print(name + typeOfRelation + ": ");
                subrelation.printRelation();
            }
        };
        relation.printRelation();
    }

    public void give(Person receiver, String thingType, Person thingOwner){
        class PocketThings{
            private final String type;
            private final Person owner;
            private Person tempOwner;

            public PocketThings(String type, Person owner){
                this.type = type;
                this.owner = owner;
            }

            public void setTempOwner(Person tempOwner) {
                this.tempOwner = tempOwner;
                System.out.println(name + " give " + type + " to " + tempOwner);
            }

            public Person getTempOwner() {
                return tempOwner;
            }

            public String getType() {
                return type;
            }

            public Person getOwner() {
                return owner;
            }
        }

        PocketThings thing = new PocketThings(thingType, thingOwner);
        thing.setTempOwner(receiver);
    }

    public void eat(Table table){
        System.out.println(this.name + " eats with  " + Arrays.deepToString(table.getSeaters()));
        this.addEnergy(table.getFood());
    }

    public void dream(Dreamable subject, String action) throws OutOfFoodException {
        System.out.println(this.name + " dreams about: " + subject.toString() + " " + action);
        this.subEnergy(0.01);
    }

    public void dream(Dreamable subject, Placeable action, Place place) throws OutOfFoodException {
        System.out.println(this.name + " dreams about: ");
        action.putIn((Person) subject, place);
        this.subEnergy(0.01);
    }

    public void beIn(Place place){
        System.out.println(this.name + " spending time in " + place.toString());
    }

    public void talk(String phrase) throws OutOfFoodException {
        System.out.println(this.name + " says: " + phrase);
        this.subEnergy(0.01);
    }

    public Character getCharacter() {
        return this.character;
    }

    public String getName() {
        return this.name;
    }

    public void addEnergy(double add) {
        this.energy = (this.energy + add) % 100;

    }

    public void subEnergy(double sub) throws OutOfFoodException{
        if (this.energy - sub <= 0) {
            throw new OutOfFoodException(this.name + " too hungry");
        } else {
            this.energy = this.energy - sub;
        }
    }

    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Person other)) return false;
        return Double.compare(this.energy, other.energy) == 0 && Objects.equals(this.name, other.name)
                && this.character == other.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.energy, this.character);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
