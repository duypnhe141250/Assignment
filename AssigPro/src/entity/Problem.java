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
import java.io.Serializable;

public class Problem implements Serializable {
    private int ID;
    private String date, name, description, link;
    private double mark_weight;
    private int type;
    private String author;
    private static int cntProblem = 0;

    public Problem(String date, String name, String description, String link, double mark_weight, int type, String author) {
        this.ID = cntProblem++;
        this.date = date;
        this.name = name;
        this.description = description;
        this.link = link;
        this.mark_weight = mark_weight;
        this.type = type;
        this.author = author;
    }

    public Problem() {
        this.ID = cntProblem++;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCnt(int cnt) {
        cntProblem = cnt;
    }

    public String getDateCreated() {
        return date;
    }

    public void setDateCreated(String dateCreated) {
        this.date = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getMark_weight() {
        return mark_weight;
    }

    public void setMark_weight(double mark_weight) {
        this.mark_weight = mark_weight;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
     @Override
    public String toString() {
        return "Problem{" + "ID=" + ID + ", dateCreated=" + date + ", name=" + name + ", description=" + description + ", link=" + link + ", mark_weight=" + mark_weight + ", type=" + type + ", author=" + author + '}';
    }
}

