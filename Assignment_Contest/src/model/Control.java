
package model;

import entity.Problem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Control {

    private List<Problem> list = new ArrayList<>();
    private String file = "QBs.dat";
    private IOFile io = new IOFile();
    private Scanner sc;

    public Control() {
        
        list = io.readFile(file);
        new Problem().setCount(list.size());
        sc = new Scanner(System.in);

    }

    private void add(Problem pb) {
        list.add(pb);
        io.writeFile(file, list);
    }

    private Problem inputProblem() {

        Problem pb = new Problem();

        System.out.print("Enter date: ");
        String date = Validate.checkInputDate();
        pb.setDateCreated(date);

        System.out.print("Enter problem name: ");
        String name = Validate.checkInputString();
        pb.setName(name);

        System.out.print("Enter short description: ");
        String des = Validate.checkInputString();
        pb.setDescription(des);

        System.out.print("Enter link to full description: ");
        String link = sc.nextLine();
        pb.setLink(link);

        System.out.print("Enter mark weight: ");
        double weight = Validate.checkInputDouble();
        pb.setmarkWeight(weight);

        System.out.print("Enter type (1: Analytics, 2: Geometry, 3: Greed, 4: Dynamic Planning, 5: Graph): ");
        int type = Validate.checkInputLimit(1, 5);
        pb.setType(type);

        System.out.print("Enter author: ");
        String author = Validate.checkInputString();
        pb.setAuthor(author);

        return pb;
    }

    public void addNewProblem() {
        add(inputProblem());
    }

    private int searchID(int ID) {
        for (int i = 0; i < list.size(); i++) {
            Problem get = list.get(i);
            if(get.getID() == ID) return i;
        }
        return -1;
    }

    public void updateID() {
        
        int index = Validate.checkInputInteger();
        
        int pos = searchID(index);
        
        if (pos == -1) {
            System.out.println("Not found ID: " + index);
            return;
        }
        
        Problem pb = inputProblem();
        pb.setCount(list.size());
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

    public void sort() {
        Collections.sort(list, (o1, o2) -> o2.getType() - o1.getType());
    }
}
