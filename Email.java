package emailapp;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength;
    private String email;
    private String companyName;
    private int mailboxCapacity;
    private String alternateEmail;

    //constructor to receive name and put it all together
    public Email (String firstName, String lastName){
        getCompanyName();
        this.firstName = firstName;
        this.lastName =  lastName ;
        this.mailboxCapacity = 500;

    }
    //Acquire info for dept
    private String getCompanyName(){
        System.out.println("Which company is the new hire under?: ");
        Scanner companyNameIn = new Scanner (System.in);
        String initialInput = companyNameIn.nextLine();
        this.companyName = initialInput.replaceAll("\\s+", "");
        return "Pulling data for "+ initialInput;
    }


    private String setDepartment(){
        System.out.print("~~~~~~~~~~\n:DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter Department Code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        switch (deptChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                this.department = "gen";
                break;
        }
        return this.department;
    }

    //gen password length
    private void setPasswordLength(){
        this.defaultPasswordLength = ThreadLocalRandom.current().nextInt(10, 16);

    }

    //gen password
    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!#@%$";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int)(Math.random()* passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return  new String(password);
    }

    public void createAccount(){
        System.out.println("EMAIL CREATED: "+ this.firstName+ " "+this.lastName);

        setDepartment();
        System.out.println(this.department);

        setPasswordLength();
        this.password = setPassword(this.defaultPasswordLength);
        System.out.println("Your password is: " +this.password);

        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+this.department+"."+companyName.toLowerCase()+".com";
        System.out.println("Your email is: "+ email);
    }
    //set capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // set alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    //change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nEmail: " + email + "\n" +
                "Mailbox Capacity: " + mailboxCapacity;
    }


}
