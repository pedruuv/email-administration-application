package br.com.pedruuv.models;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String department;
    private final Integer passwordLength = 10;
    private Integer mailBoxCapacity = 500;
    private String alternateEmail;
    private final Scanner scanner = new Scanner(System.in);

    //! Constructor to receive the first and last name

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = setTheDepartment();
        this.password = generateRandomPassword(passwordLength);

        this.email = this.firstname.toLowerCase().replaceAll("\\s", "")
                + "." + this.lastname.toLowerCase() + "@" + this.department + ".company.com";

        System.out.println("Email created: " + this.email);
        System.out.println("Your password: " + this.password);

    }

    //? Ask for the department

    private String setTheDepartment(){
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

    private String generateRandomPassword(int length){
        var characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890!@#$%&()";
        StringBuilder pass = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for(int i = 0; i < length; i++){
            int randomIndex = random.nextInt(characters.length());
            pass.append(characters.charAt(randomIndex));
        }
        return String.valueOf(pass);
    }

    //! Set the maillbox capacity

    public void setMailBoxCapacity(Integer mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    //! Set the altenate email

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //? Change Password

    public void ChangePassword(String password){
        this.password = password;
    }

    public Integer getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "Name: " + this.firstname + " " + this.lastname +
                "\nEmail: " + this.email + "\nMailbox Capability: " + this.mailBoxCapacity + "MB";
    }
}
