package com.lufthansa.globals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Globals {
    public static String baseUrl = "https://airprojects.resvoyage.com/airtravel.htm?Idle=true&lang=en-us";

    public static String email= "test123@gmail.com";

    public static String phone= "355672500905";

    public static List<String> names = Arrays.asList("Harper", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Emma", "Evelyn");
    public static List<String> lastNames = Arrays.asList("Martinez", "Garcia", "Brown", "Johnson", "Jones", "Gonzalez", "Davis", "Rodriguez", "Smith", "Wilson");

    public static List<String> childrenBirthday = new ArrayList<>();
    public static String dayOfReturn;
    public static String monthAndYearofReturn;

    public static String CreditCardNumber = "5555341244441115";

    public static String HolderName = "John Doe";

    public static String ExpirationMonth = "07";
    public static String ExpirationYear = "2024";

    public static String CVC = "737";


    // kur do te marresh daten e fundit te returnit Globals.dayOfReturn.get(dayOfReturn.getLength()-1)
}
