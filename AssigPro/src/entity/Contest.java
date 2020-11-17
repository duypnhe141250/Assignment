/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contest implements Serializable {
    private int ID;
    private static int cntContest = 0;
    private List<Problem> question;
    private String date;
    private double fullMark;
    private String creator;

    public Contest() {
        this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        this.fullMark = 0;
        for (Problem problem : question) {
            fullMark += problem.getMark_weight();
        }
        this.ID = cntContest++;
    }
    public void setCnt(int cnt) {
        cntContest = cnt;
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
        this.fullMark = 0;
        question.forEach(it -> fullMark+=it.getMark_weight());
        this.ID = cntContest++;
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
        output += ("Date create: " + this.date +"Code: " + this.ID +"Creator: " + this.creator);
        
        for (int i = 0; i < question.size(); i++) {
            Problem get = question.get(i);
            output += String.format("Ex%d (%.1f): %s\n\n", i+1, get.getMark_weight(), get.getDescription());
        }
        output += "Total: " + this.fullMark + "\n";
        return output;
    }
    
}

