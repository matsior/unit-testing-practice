package p6;

public class ExceptionsExample {

    protected static final int DEFAULT_NUMBER = 5;

    public String doSomething(int i) {
        if (i > DEFAULT_NUMBER) {
            throw new IllegalArgumentException("Parametr jest większy od 5");
        }
        return String.valueOf(i);
    }
}
