import Model.IOFile;
import entity.Problem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.Validate;

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

    private void add(Problem p) {
        list.add(p);
        io.writeFile(file, list);
    }

    private Problem inputProblem() {

        Problem p = new Problem();

        System.out.print("Enter the date: ");
        String date = Validate.checkDate();
        p.setDateCreated(date);

        System.out.print("Enter the name: ");
        String name = Validate.checkString();
        p.setName(name);

        System.out.print("Enter short description: ");
        String des = Validate.checkString();
        p.setDescription(des);

        System.out.print("Enter link to full description: ");
        String link = sc.nextLine();
        p.setLink(link);

        System.out.print("Enter mark weight: ");
        double weight = Validate.checkDouble();
        p.setMarkWeight(weight);

        System.out.print("Enter type (0: toan giai tich, 1: toan hinh, 2: tham lam, 3: quy hoach dong, 4: do thi): ");
        int type = Validate.checkLimit(0, 4);
        p.setType(type);

        System.out.print("Enter author: ");
        String author = Validate.checkString();
        p.setAuthor(author);

        return p;
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
        
        int index = Validate.checkInteger();
        
        int pos = searchID(index);
        
        if (pos == -1) {
            System.out.println("Enter ID again: " + index);
            return;
        }
        
        Problem p = inputProblem();
        p.setCount(list.size());
        p.setID(list.get(pos).getID());
        list.set(pos, p);
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