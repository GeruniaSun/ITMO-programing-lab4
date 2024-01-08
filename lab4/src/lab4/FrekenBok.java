package lab4;

public class FrekenBok extends Person{
    public FrekenBok() {
        super("Freken Bok", Character.NEGATIVE);
    }

    public void grumble() {
        System.out.println(this.getName() + " grumbling");
    }

    public void swear(Person other) {
        System.out.println(this.getName() + " swearing " + other.getName());
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 13;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
