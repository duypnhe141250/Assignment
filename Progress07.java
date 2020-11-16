
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
public class Progress07 extends Problems{

    public Progress07() {
    }
    
    public void printinfo(String checkcontestID){
        System.out.println("contestID, date, creater, overall");
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getProblemid().equals(checkcontestID)){
                System.out.println(a.get(i));
            }
        }
        return;
    }
    public void sortquest(List<Problems>a){
        Collections.sort(a,new Comparator<Problems>() {
            @Override
            public int compare(Problems o1, Problems o2) {
                if(o1.getCategory().compareToIgnoreCase(o2.getCategory())<0)
               {
                   return 1;
               }
               else if(o1.getCategory().compareToIgnoreCase(o2.getCategory())>0){
                   return -1;
               }
               else{
                   return 0;
               }
            }
        });
    }
}
