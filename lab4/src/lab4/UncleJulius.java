package lab4;

public class UncleJulius extends Person{
    public UncleJulius() {
        super("uncle Julius", Character.NEUTRAL);
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 17;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
