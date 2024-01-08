package lab4;

import java.util.Arrays;
import java.util.Objects;

public class Argument {
    private final String argumentSubject;
    private Person[] pros;
    private Person[] cons;

    public Argument(String argumentSubject, Person[] pros, Person[] cons){
        this.argumentSubject = argumentSubject;
        this.pros = pros;
        this.cons = cons;
    }
    public void addPros(Person... pros){
        Person[] result = new Person[this.pros.length + pros.length];

        System.arraycopy(this.pros, 0, result, 0, this.pros.length);
        System.arraycopy(pros, 0, result, this.pros.length, pros.length);

        this.pros = result;
    }
    public void addCons(Person... cons){
        Person[] result = new Person[this.cons.length + cons.length];

        System.arraycopy(this.cons, 0, result, 0, this.cons.length);
        System.arraycopy(cons, 0, result, this.cons.length, cons.length);

        this.cons = result;
    }

    public Person[] getCons() {
        return cons;
    }

    public Person[] getPros() {
        return pros;
    }

    public String getArgumentSubject() {
        return argumentSubject;
    }

    public void printPros() {
        System.out.println(
                Arrays.toString(this.getPros()).replace("[", "").replace("]", "") +
                " thinks: " + this.getArgumentSubject());
    }

    public void printCons() {
        System.out.println(
                Arrays.toString(this.getCons()).replace("[", "").replace("]", "") +
                        " thinks: " + this.getArgumentSubject());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Argument other)) return false;
        return Objects.equals(getArgumentSubject(), other.getArgumentSubject()) && Arrays.equals(getPros(),
                other.getPros()) && Arrays.equals(getCons(), other.getCons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArgumentSubject()) +
                11 * Arrays.hashCode(getPros()) +
                13 * Arrays.hashCode(getCons());
    }

    @Override
    public String toString() {
        return this.argumentSubject;
    }


}