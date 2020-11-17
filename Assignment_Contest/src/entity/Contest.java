
package entity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contest implements Serializable {
    private int ID;
    private static int CountContest = 0;
    private List<Problem> question;
    private String date;
    private double Mark;
    private String creator;

    public Contest() {
        this.date = new SimpleDateFormat("DD/MM/YYYY HH:mm").format(new Date());
        this.Mark = 0;
        
        for (Problem p : question) {
            Mark += p.getmarkWeight();
        }
        this.ID = CountContest++;
    }
    public void setCount(int Count) {
        CountContest = Count;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Contest(List<Problem> question, String creator) {
        this.question = question;
        this.date = new SimpleDateFormat("DD/MM/YYYY HH:mm").format(new Date());
        this.Mark = 0;
        question.forEach(it -> Mark+=it.getmarkWeight());
        this.ID = CountContest++;
        this.creator = creator;
    }
    public void writeToFile() {
        String file = "Contest_" + (new Date().getTime()) + ".txt";
        String output = this.toString();
        try {
            FileWriter f = new FileWriter(file);
            f.write(output);
            f.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String toString() {
        String output = "";
        output += "Date create: " + this.date + "\n";
        output += "Code: " + this.ID + "\n";
        output += "Creator: " + this.creator + "\n";
        for (int i = 0; i < question.size(); i++) {
            Problem get = question.get(i);
            output += String.format("Ex%d (%.1f): %s\n\n", i+1, get.getmarkWeight(), get.getDescription());
        }
        output += "Total: " + this.Mark + "\n";
        return output;
    }
}

