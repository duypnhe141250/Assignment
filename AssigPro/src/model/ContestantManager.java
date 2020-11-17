/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
import entity.Contestant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContestantManager {
    private List<Contestant> list = new ArrayList<>();
    private String file;
    private FileManu fileIO;
    
    
    public ContestantManager() {
        this.file = "constestants.dat";
        this.fileIO = new FileManu();
        list = fileIO.readFile(file);
        new Contestant().setCnt(list.size());
       list.add(new Contestant("Phung Nam Duy", "namduy@gmail.com", "41064146", "123456", 1)); 
       list.add(new Contestant("Pham Nhat Linh", "nhatlinh@gmail.com", "16103614", "123456", 2));
       list.add(new Contestant("Viet Anh", "vietanh@gmail.com", "06513315", "123456", 3));
       list.add(new Contestant("Hoang Hieu", "hoanghieu@gmail.com", "0361416", "123456", 4));
       list.add(new Contestant("Minh Huy", "minhhuy@gmail.com", "03614962", "123456", 5));
        fileIO.writeFile(file, list);
    }
    public int checkEmail(String email) {
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return 0;
    }
    public int login(String email, String password) {
        int i = checkEmail(email);
        if(i == 0) return 0;
        if(list.get(i).getPassword().equals(password)) 
            return i;
        return 1; 
    }
    public void changeInforInput() {
        int index;
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Change profile information\nEnter ID: ");
                index = Integer.parseInt(sc.nextLine());
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Please input a vaild number");
            }
        }
        changeInfor(index);
    }
    public void changeInfor(int ID) {
        Contestant c = list.get(ID);
        Scanner sc = new Scanner(System.in);
        loop: while(true) {
            System.out.println("1. Change name");
            System.out.println("2. Change email");
            System.out.println("3. Change phone");
            System.out.println("4. Change password");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Please enter a valid number");
                continue;
            }
            switch(choice) {
                case 1: 
                    while(true) {
                        System.out.print("Enter new name: ");
                        String io = sc.nextLine();
                        if(io.length() == 0) {
                            System.out.println("Please input non-null string");
                            continue;
                        }
                        c.setName(io);
                        break;
                    }
                    break;
                case 2: 
                    while(true) {
                        System.out.print("Enter new email: ");
                        String io = sc.nextLine();
                        if(io.length() == 0) {
                            System.out.println("Please input non-null string");
                            continue;
                        }
                        c.setEmail(io);
                        break;
                    }
                    break;
                case 3: 
                    while(true) {
                        System.out.print("Enter new phone: ");
                        String io = sc.nextLine();
                        if(io.length() == 0) {
                            System.out.println("Please input non-null string");
                            continue;
                        }
                        c.setPhone(io);
                        break;
                    }
                    break;
                case 4: 
                    while(true) {
                        System.out.print("Enter new password: ");
                        String io = sc.nextLine();
                        if(io.length() == 0) {
                            System.out.println("Please input non-null string");
                            continue;
                        }
                        c.setPassword(io);
                        break;
                    }
                    break;
                case 0: break loop;
                default: System.out.println("Please input valid choice");
            }
        }
        fileIO.writeFile(file, list);
        System.out.println("Change information successfully!");
    }

    public List<Contestant> getList() {
        return list;
    }

    public void setList(List<Contestant> list) {
        this.list = list;
    }
    
}

