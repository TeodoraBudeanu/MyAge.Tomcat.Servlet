package ro.sci.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeInDaysCalculator {

    public AgeInDaysCalculator() {
    }

    public static long calculateAge(LocalDate birthDate) {
            if (birthDate != null) {
                return ChronoUnit.DAYS.between(birthDate, LocalDate.now());
            } else {
                return 0;
            }
        }
    }
