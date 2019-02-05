package ro.sci.service;

import ro.sci.app.AgeInDaysCalculator;

import java.time.LocalDate;

public class MyAgeService {

    public static long getAge(LocalDate birthDate){
        return AgeInDaysCalculator.calculateAge(birthDate);

    }
}
