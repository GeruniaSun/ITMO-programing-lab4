package lab4;

public class Baby extends Person{
    public Baby() {
        super("Baby", Character.POSITIVE);
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 5;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
