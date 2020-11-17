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
import entity.Contest;
import entity.Contestant;
import entity.Problem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContestManager implements Serializable {
    
    private List<Contest> list = new ArrayList<>();
    private String file;
    private FileManu fileIO;
    private ProblemsManager p;
    private Contestant user;
    
    public ContestManager(Contestant user, ProblemsManager p) {
        
        this.file = "constest.dat";
        this.fileIO = new FileManu();
        list = fileIO.readFile(file);
        new Contestant().setCnt(list.size());
        this.p = p;
        this.user = user;
        
    }
    
    public List<Problem> chooseQuestion() {
        
        List<Problem> contest = new ArrayList<>();
        int n = 5;
        List<Problem>[] problem = new ArrayList[n];
        
        for(int i = 0; i < n; ++i) 
            problem[i] = new ArrayList<>();
        
        p.getList().forEach(i -> problem[i.getType()].add(i));
        
        for(List<Problem> i: problem) {
            if(i.isEmpty()) continue;
            int index = new Random().nextInt(i.size());
            contest.add(i.get(index));
        }
        
        return contest;
    }
    
    public void generateNewContest() {
        Contest contest = new Contest(chooseQuestion(), user.getName());
        contest.writeToFile();
        list.add(contest);
        fileIO.writeFile(file, list);
        System.out.println("Generate successfully");
    }
    
    public void print() {
        Scanner sc = new Scanner(System.in);
        int number;
        while(true) {
            System.out.print("Enter ID: ");
            String input = sc.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please input a valid int number");
            }
        }
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            Contest c = list.get(i);
            if(c.getID() == number) {
                pos = i; break;
            }
        }
        if(pos == -1) System.out.println("Not found ID: " + number);
        else System.out.println(list.get(pos));
    }
    
}
