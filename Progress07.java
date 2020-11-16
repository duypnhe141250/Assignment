
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Progress07 {
    String contestID;
    String date;
    String creater;
    String category;
    int overall;
    List<Progress07> a =new ArrayList<>();
    Scanner in= new Scanner(System.in);
    public Progress07() {
    }

    public Progress07(String contestID, String date, String creater, String category, int overall) {
        this.contestID = contestID;
        this.date = date;
        this.creater = creater;
        this.category = category;
        this.overall = overall;
    }

    
    
    public void printinfo(String checkcontestID){
        System.out.println("contestID, date, creater, q1, q2, q3, q4, q5, point1, point2, point3, point4, point5, overall");
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getcontestID.equals(checkcontestID)){
                System.out.println(a.get(i).contestID,a.get(i).creater,a.get(i).date,a.get(i).category,a.get(i).overall);
            }
        }
        return;
    }
    public void sortquest(List<Progress07>a){
        Collections.sort(a,new Comparator<Progress07>() {
            @Override
            public int compare(Progress07 o1, Progress07 o2) {
               if(o1.getcategory().comparetoIgnoreCase(o2.getcategory)<0)
               {
                   return 1;
               }
               else if(o1.getcategory().comparetoIgnoreCase(o2.getcategory)>0){
                   return -1;
               }
               else{
                   return 0;
               }
            }
        });
    }
}
