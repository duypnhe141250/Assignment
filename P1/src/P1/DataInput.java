/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nguoitamxa
 */
public class DataInput {
    
    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    
     private static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static String checkInputPhone(String fieldName) {
        while (true) {           
        System.out.print("Enter " + fieldName + ": ");
            try {
                int phoneCheck = Integer.parseInt(in.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (resultCheck.matches(PHONE_VALID)) {
                    return resultCheck;                   
                } else {
                   System.err.println("Phone number must be 10 digits");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be number");
            }
        }
    }

    public static String checkInputID(String fieldName) {
        while (true) {
            System.out.print("Enter " + fieldName + ": ");
            try {
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dddddddddd").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.err.println("Date to correct format(dddddddddd)");
            }
        }
    }

    public static String checkInputEmail(String fieldName) {
        while (true) {
            System.out.print("Enter " + fieldName + ": ");
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
            } else {
                return emailCheck;
            }
        }
    }
      
}
