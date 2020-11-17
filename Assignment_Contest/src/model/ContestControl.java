
package model;

import entity.Contest;
import entity.Participator;
import entity.Problem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContestControl implements Serializable {
    
    private List<Contest> list = new ArrayList<>();
    private String f;
    private IOFile fIO;
    private Control p;
    private Participator user;
    
    public ContestControl(Participator user, Control p) {
        
        this.f = "Contest_TimeStamp.txt";
        this.fIO = new IOFile();
        list = fIO.readFile(f);
        new Participator().setCount(list.size());
        this.p = p;
        this.user = user;
        
    }
    
    public List<Problem> chooseQuestion() {
        
        List<Problem> contest = new ArrayList<>();
        int k = 5;
        List<Problem>[] problem = new ArrayList[k];
        
        for(int i = 0; i < k; ++i) 
            problem[i] = new ArrayList<>();
        
        p.getList().forEach(i -> problem[i.getType()].add(i));
        
        for(List<Problem> i: problem) {
            if(i.isEmpty()) continue;
            int index = new Random().nextInt(i.size());
            contest.add(i.get(index));
        }
        
        return contest;
    }
    
    public void CreateNewContest() {
        Contest NewContest = new Contest(chooseQuestion(), user.getName());
        NewContest.writeToFile();
        list.add(NewContest);
        fIO.writeFile(f, list);
        System.out.println("Create successfully");
    }
    
    public void print() {
        Scanner sc = new Scanner(System.in);
        int amount;
        while(true) {
            System.out.print("Enter ID: ");
            String input = sc.nextLine();
            try {
                amount = Integer.parseInt(input);
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please input a valid number");
            }
        }
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            Contest c = list.get(i);
            if(c.getID() == amount) {
                pos = i; break;
            }
        }
        if(pos == -1) System.out.println("Not found ID: " + amount);
        else System.out.println(list.get(pos));
    }
    
}
