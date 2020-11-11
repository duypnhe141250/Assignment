/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


    

public class Problems {
   String problemid;
   String Date;
   String Problem ;
   String shortdescription;
   String link;
   double Markweigt;
   String category;

    public Problems() {
    }

    public Problems(String problemid, String Date, String Problem, String shortdescription, String link, double Markweigt, String category) {
        this.problemid = problemid;
        this.Date = Date;
        this.Problem = Problem;
        this.shortdescription = shortdescription;
        this.link = link;
        this.Markweigt = Markweigt;
        this.category = category;
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String Problem) {
        this.Problem = Problem;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getMarkweigt() {
        return Markweigt;
    }

    public void setMarkweigt(double Markweigt) {
        this.Markweigt = Markweigt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Problems> getA() {
        return a;
    }

    public void setA(List<Problems> a) {
        this.a = a;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

  

    @Override
    public String toString() {
        return "Problems{" + "problemid=" + problemid + ", Date=" + Date + ", Problem=" + Problem + ", shortdescription=" + shortdescription + ", link=" + link + ", Markweigt=" + Markweigt + ", category=" + category + '}';
    }
    
   
     List<Problems> a = new ArrayList<>();
     Scanner sc = new Scanner(System.in);
    public void addProblem(Problems p) {
        a.add(p);
        System.out.println("Add a product success!!!");
    }
    
    
     //Check product id valid
    public boolean checkProblemid(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).problemid.equals(id)) {
                return true;
            }
        }
        return false;
    }
    //Input information of problem
    public void input(Problems p2) {
        Random rand = new Random();
        System.out.print("Enter problemID:  ");
        p2.setProblemid(sc.nextLine());
        System.out.print("Enter date: ");
        p2.setDate(sc.nextLine());
        System.out.println("Enter problem: ");
        p2.setProblem(sc.nextLine());
        System.out.println("Enter Shortdescription");
        p2.setShortdescription(sc.nextLine());
        System.out.println("Enter link");
        p2.setLink(sc.nextLine());
        System.out.println("Enter Markweight");
        p2.setMarkweigt(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter Category");
        p2.setCategory(sc.nextLine());
    }

    //Input update informations for problems
    public void inputInformation(Problems p) {
        System.out.print("Enter product id: ");
        String productId = sc.nextLine();
        if (p.checkProblemid(productId)== false) {//check product id
            System.out.println("Not found product id");
            return;
        }
       
        System.out.print("Enter updated date: ");
        String date = sc.nextLine();
        p.updatedate(date);
        System.out.println("Enter updated problem: ");
        String problem = sc.nextLine();
        p.updateproblem(problem);
        System.out.println("Enter Shortdescription");
        String desc = sc.nextLine();
        p.updatedesc(desc);
        System.out.println("Enter link");
        String link = sc.nextLine();
        p.updatelink(link);
        System.out.println("Enter Markweight");
        double mark = sc.nextDouble();
        p.updatemark(Markweigt);
        System.out.println("Enter Category");
        String category = sc.nextLine();
        p.updatecate(date);
        
    }
    
    //Update price of product
    public void updatedate( String newDate) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).Date.equals(newDate)) {
                a.get(i).setDate(newDate);
                System.out.println("Update success!!!");
                return;
            }
            
        }
    }
    public void updateproblem( String newproblem) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).Problem.equals(newproblem)) {
                a.get(i).setProblem(newproblem);
                System.out.println("Update success!!!");
                return;
            }
            
        }
    }
    public void updatedesc(String newdesc) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).shortdescription.equals(newdesc)) {
                a.get(i).setShortdescription(newdesc);
                System.out.println("Update success!!!");
                return;
            }
            
        }}
       public void updatelink( String newlink) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).link.equals(newlink)) {
                a.get(i).setLink(newlink);
                System.out.println("Update success!!!");
                return;
            }
            
        }}
        public void updatemark(double newmark) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).Markweigt==(newmark)) {
                a.get(i).setMarkweigt(newmark);
                System.out.println("Update success!!!");
                return;
            }
            
        }
        }
        public void updatecate( String newcate) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).category.equals(newcate)) {
                a.get(i).setCategory(newcate);
                System.out.println("Update success!!!");
                return;
            }
            
        }
    }
    }
    


   

