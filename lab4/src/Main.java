import lab4.*;

public class Main {
    public static void main (String[] args){
        // initialize heroes
        Carlson carlson = new Carlson();
        Baby baby = new Baby();
        UncleJulius uncleJulius = new UncleJulius();
        FrekenBok frekenBok = new FrekenBok();

        // initialize house of heroes
        Place house = new Place("family house");
        house.setVisitors(baby, frekenBok, uncleJulius);

        // lab4 starts here
        Person.Relation babyAgreeing = baby.new Relation(" agree with ", uncleJulius);
        babyAgreeing.printRelation();

        Person.Relation babyRating = baby.new Relation(" likes in all ways ", carlson);
        babyRating.printRelation();

        Person.Relation juliusAffection = uncleJulius.new Relation(" affected with ", carlson);
        juliusAffection.printRelation();

        carlson.give(uncleJulius, "clock", uncleJulius);
        carlson.give(uncleJulius, "wallet", uncleJulius);
        try {
            uncleJulius.talk(" thank you, carlson, i never forget this! ");
        } catch (OutOfFoodException e) {
            System.out.println(e.getMessage());
        }

        Person.Relation frekenAnger = frekenBok.new Relation(" angry on ", carlson);
        carlson.complexRelation(", if he gets food, don't pay attention to", frekenAnger);

        Person.Relation frekenFeeding = frekenBok.new Relation(" feed ", carlson);
        frekenFeeding.printRelation();

        // lab3 starts here
        try {
            carlson.talk("If I'm not fed, I'm not me");
        } catch (OutOfFoodException e) {
            System.out.println(e.getMessage());
        }
        try {
            frekenBok.dream(carlson, Person::beIn, house);
        } catch (OutOfFoodException e) {
            System.out.println(e.getMessage());
        }

        // argument starts
        Argument CarlsonCancelling = new Argument("Carlson can spend time with them",
                new Person[]{baby, uncleJulius}, new Person[]{frekenBok});
        CarlsonCancelling.printPros();

        // initialize table
        Table houseTable = new Table("wood", house.getDescription(),999.0);
        houseTable.setSeaters(house.getVisitors());
        houseTable.printSeaters();

        // story continue
        carlson.land(house);
        houseTable.setSeaters(house.getVisitors());
        frekenBok.grumble();
        System.out.println(new FrekenNothingToDoException().getMessage());
        houseTable.printSeaters();
    }
}
