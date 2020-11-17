import entity.Contest;
import entity.Contestant;
import java.util.Scanner;
import model.ContestManager;
import model.ContestantManager;
import model.ProblemsManager;
import model.CheckValid;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContestantManager cManager = new ContestantManager();
        Contestant i = login(cManager);
        int userID = i.getID();
        ProblemsManager psm = new ProblemsManager();
        ContestManager ctManager = new ContestManager(i, psm);

        while(true) {
            System.out.println(" TO MANAGE CONTEST SYSTEM CHOOSE OPTIONS: ");
            System.out.println("1: Change profile information");
            System.out.println("2. Add new problem");
            System.out.println("3: Update problem");
            System.out.println("4: List of problem");
            System.out.println("5. Generate new contest");
            System.out.println("6. Print contest by ID");
            System.out.println("7. Sort all problems by Category as ascending order");
            System.out.println("8. Exit");
            int choice = CheckValid.Range(1, 8);
            
            switch(choice) {
                case 1: 
                        cManager.changeInfor(userID); break;
                case 2: 
                        System.out.println("Add new problem: ");
                        psm.addNewProblem();
                        break;
                case 3: 
                        System.out.println("Update problem\nEnter ID: ");
                        psm.updateByID();
                        break;
                case 4: 
                        psm.printAll(); 
                        break;
                case 5: 
                        ctManager.generateNewContest();
                        break;
                case 6: 
                        ctManager.print(); 
                        break;
                case 7: 
                        psm.sort();
                        break;
                case 8: System.out.println("Exit successfully"); return;                
            }
        }
    }
    public static Contestant login(ContestantManager cm) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("YOU MUST LOGIN TO ACCESS SYSTEM");
            System.out.print("Enter email: ");
            String email = CheckValid.checkString();            
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            
            
            int check = cm.login(email, pass);
            if(check == 0) {
                System.out.println("Not found email: " + email);
            }
            else if(check == 1) 
                System.out.println("Incorrect password, check again!");
            else return cm.getList().get(check);
        }
    }
    
}
