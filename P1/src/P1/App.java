/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author thaycacac
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataInput.checkInputPhone("Contestant Phone number");
        DataInput.checkInputID("Contestant ID: ");
        DataInput.checkInputEmail("Contestant Email: ");
        System.out.println("Contestant Name");
        String hoTen = scanner.nextLine();
        System.out.println("Contestant  Rank");
        double rank = scanner.nextDouble();
    }
}
