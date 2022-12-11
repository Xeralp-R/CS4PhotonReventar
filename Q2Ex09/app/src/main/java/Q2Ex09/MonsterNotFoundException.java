package Q2Ex09;

import java.util.NoSuchElementException;

public class MonsterNotFoundException extends NoSuchElementException {
    public MonsterNotFoundException() {}
    public MonsterNotFoundException(String msg) {
        super(msg);
    }
}
