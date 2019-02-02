package ro.sci.service;

import ro.sci.app.AgeCalculator;

import java.time.LocalDate;

public class MyAgeService {

    public static int getAge(LocalDate birthDate){
        return AgeCalculator.calculateAge(birthDate);

    }
}
