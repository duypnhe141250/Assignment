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
import entity.Problem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemsManager {

    private List<Problem> list = new ArrayList<>();
    private String file = "QBs.dat";
    private FileManu io = new FileManu();
    private Scanner sc;

    public ProblemsManager() {
        
        list = io.readFile(file);
        new Problem().setCnt(list.size());
       
        
        list.add(new Problem("13/11/2020", "Limits","Show that the equation x^5 −3x = 1 has at least one root between 1 and 2 .", "https://pokrovka11.files.wordpress.com/2012/10/calculus.pdf", 4, 0, "Nam Duy"));
        list.add(new Problem("14/11/2020", "Geometry","Bố trí phòng họp (mất tính thứ tự so với dãy ban đầu)", "https://vnoi.info/wiki/algo/dp/basic-problems.md?fbclid=IwAR1CRjyBRFBj_z8nlhZGp8PP-0ieglOLmROD0xT4kfQR_pmYV28nPT9oag4#b%E1%BB%91-tr%C3%AD-ph%C3%B2ng-h%E1%BB%8Dp-m%E1%BA%A5t-t%C3%ADnh-th%E1%BB%A9-t%E1%BB%B1-so-v%E1%BB%9Bi-d%C3%A3y-ban-%C4%91%E1%BA%A7u", 4, 1, "Viet Anh"));
        list.add(new Problem("15/11/2020", "Greedy","Tim cach toi uu giai quyet van de", "https://vnoi.info/wiki/translate/topcoder/Greedy-is-Good.md?fbclid=IwAR2KWGBzTq7vhZCWcliWPdpkv9jV1lEVJSL8Tz8OOnEMI4Hv228CLHO-6sc", 5, 2, "Nhat Linh"));
        list.add(new Problem("17/11/2020", "Dynamic Programming","What is a dynamic programming, how can it be described? ", "https://www.topcoder.com/", 3, 3, "Hieu Hoang"));
        list.add(new Problem("17/11/2020", "Graph", "Fine the correctansw","https://www.mathgoodies.com/lessons/graphs/practice_unit11", 5, 4, "Minh Huy"));
        
        io.writeFile(file, list);
    }

    private void add(Problem pb) {
        list.add(pb);
        io.writeFile(file, list);
    }


      private Problem inputProblem() {

        Problem pb = new Problem();

        System.out.print("Enter date: ");
        String date = CheckValid.checkDate();
        pb.setDateCreated(date);

        System.out.print("Enter problem name: ");
        String name = CheckValid.checkString();
        pb.setName(name);

        System.out.print("Enter short description: ");
        String des = CheckValid.checkString();
        pb.setDescription(des);

        System.out.print("Enter link to full description: ");
        String link = sc.nextLine();
        pb.setLink(link);

        System.out.print("Enter mark weight: ");
        double weight = CheckValid.checkDouble();
        pb.setMark_weight(weight);

        System.out.print("Enter type (0:Analytics, 1: Geometry, 2: greed, 3: DynamicPlanning, 4: graph): ");
        int type = CheckValid.Range(0, 4);
        pb.setType(type);

        System.out.print("Enter author: ");
        String author = CheckValid.checkString();
        pb.setAuthor(author);

        return pb;
    }
    public void addNewProblem() {
        add(inputProblem());
    }

    private int searchByID(int ID) {
        for (int i = 0; i < list.size(); i++) {
            Problem get = list.get(i);
            if(get.getID()== ID) return i;
        }
        return -1;
    }

    public void updateByID() {
        
        int index = CheckValid.checkInteger();
        
        int pos = searchByID(index);
        
        if (pos == -1) {
            System.out.println("Not found ID: " + index);
            return;
        }
        
        Problem pb = inputProblem();
        pb.setCnt(list.size());
        pb.setID(list.get(pos).getID());
        list.set(pos, pb);
        io.writeFile(file, list);
    }

    public void printAll() {
        for (Problem problem : list) {
            System.out.println(problem);
        }
    }

    public List<Problem> getList() {
        return list;
    }

    public void setList(List<Problem> list) {
        this.list = list;
    }

    public void sort() {
        Collections.sort(list, (o1, o2) -> o2.getType() - o1.getType());
    }
}
