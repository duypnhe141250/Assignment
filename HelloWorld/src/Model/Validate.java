
package model;

import java.util.Scanner;


public class Validate {
    static Scanner scanner = new Scanner(System.in);
        private static final String PNumber_VALID = "^\\d{10}$";

       public static double checkDouble(){
            while(true){
                try{
                    double number = Double.parseDouble(scanner.nextLine().trim());
                    if (number < 0) {
                        throw new NumberFormatException() ;
                    }else{
                        return number;
                    }
                }catch(NumberFormatException e){
                    System.err.println("Enter the number > 0");
                    System.out.println("Enter again: ");
                }
            }
        }
        public static int checkLimit(int min, int max){
            while(true){
                try{
                    int choice = Integer.parseInt(scanner.nextLine().trim());
                    if (min > choice || choice > max) {
                        throw new NumberFormatException();
                    }
                    return choice;
                }catch(NumberFormatException e){
                    System.err.println("Your choice must in range [ " + min + "-" + max + " ]");
                    System.out.println("Enter again: ");
                }
            }
        }
         public static int checkInteger(){
        while(true){
            try{
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number < 0) {
                    throw new NumberFormatException() ;
                }else{
                    return number;
                }
            }catch(NumberFormatException e){
                System.err.println("Enter the number > 0");
                System.out.println("Enter again: ");
            }
        }
    }
         

        public static String checkString(){
            while(true){
                String result = scanner.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println("Enter the information into here:");
                    System.out.println("Enter again: ");
                }else{
                    return result;
                }
            }
        }

        

   

        public static String checkDate() {
            while (true) {               
                String input = checkString();

                String regex = "^(([012]?\\d)|(3[01]))\\/((0?\\d)|(1[012]))\\/\\d{4}$";
                if (!input.matches(regex)) {
                    System.out.println("Enter the validate");
                } else {
                    return input;
                }
            }
        }

        public static String checkPhone(){
            while (true){
                String result = checkString();
                if (result.matches(PNumber_VALID)){
                    return result;
                }else{
                    System.err.println("Enter phone number at least 10 numbers!!!");
                    System.out.println("Enter again: ");
                }
            }
        }
}
