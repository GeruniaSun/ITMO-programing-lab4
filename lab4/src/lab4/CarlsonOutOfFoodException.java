package lab4;

public class CarlsonOutOfFoodException extends OutOfFoodException{
    public CarlsonOutOfFoodException() {}
    public CarlsonOutOfFoodException(String gripe){
        super(gripe);
    }
}