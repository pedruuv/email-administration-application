package br.com.pedruuv.models;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private Integer mailBoxCapacity;
    private String alternateEmail;
    private final Scanner scanner = new Scanner(System.in);

    //! Constructor to receive the first and last name

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.department = SetTheDepartment();
        System.out.println("Email created: " + this.firstname.toLowerCase().replaceAll("\\s", "")
         + "." + this.lastname.toLowerCase() + "@" + this.department + ".company.com");
        this.password = GenerateRandomPassword();
        System.out.println("Your password: " + this.password);

    }

    //? Ask for the department

    private String SetTheDepartment(){
        System.out.println("Enter your department?\n1- for Sales\n2- for Development\n3- for Accounting\n0- for none");
        int department = scanner.nextInt();

        switch (department){
            case 1 -> {
                return "sales";
            }
            case 2 -> {
                return "development";
            }
            case 3 -> {
                return "accounting";
            }
            default -> {
                return "";
            }
        }
    }

    //! Generate a random Password

    private String GenerateRandomPassword(){
        var characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890!@#$%&()";
        StringBuilder pass = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for(int i = 0; i < 10; i++){
            int randomIndex = random.nextInt(characters.length());
            pass.append(characters.charAt(randomIndex));
        }
        return String.valueOf(pass);
    }

    //! Set the maillbox capacity

    //! Set the altenate email

    //? Change Password


}
