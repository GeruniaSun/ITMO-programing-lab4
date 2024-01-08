package lab4;

public class OutOfFoodException extends Throwable{
    public OutOfFoodException() {}
    public OutOfFoodException(String gripe){
        super(gripe);
    }
}
