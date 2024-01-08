package lab4;

public class FrekenNothingToDoException extends RuntimeException{
    public FrekenNothingToDoException(){
        super("Freken Bok can't do anything");
    }

    public FrekenNothingToDoException(String gripe){
        super("Freken Bok can't do anything because of" + gripe);
    }
}
