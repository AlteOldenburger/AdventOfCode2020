package de.brachwitz.leon.tag02;

import de.brachwitz.leon.utils.FileReader;

public class Main
{
    public static void main(String[] args)
    {
        var fileReader = new FileReader();
        var input = fileReader.readCsvFile("/tag02/input.csv");

        var passwordPolicyChecker = new PasswordPolicyChecker();
        System.out.println("The amount of valid passwords is: " + passwordPolicyChecker.checkPassword(input));
    }
}
