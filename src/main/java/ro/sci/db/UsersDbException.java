package ro.sci.db;

public class UsersDbException extends Exception{
    public UsersDbException(String s, Exception e) {
        super(s, e);
    }

    public UsersDbException(String s) {
        super(s);
    }
}
