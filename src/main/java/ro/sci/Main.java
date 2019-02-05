package ro.sci;

import ro.sci.app.AgeInDaysCalculator;
import ro.sci.db.UsersDbException;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, UsersDbException {
        System.out.println(AgeInDaysCalculator.calculateAge(LocalDate.parse("1994-05-16")));
    }
}
