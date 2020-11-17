

package entity;


import java.io.Serializable;

public class Problem implements Serializable {
    private int ID;

    @Override
    public String toString() {
        return "Problem{" + "ID=" + ID + ", dateCreated=" + dateCreated + ", name=" + name + ", description=" + description + ", link=" + link + ", markWeight=" + markWeight + ", type=" + type + ", author=" + author + '}';
    }
    private String dateCreated, name, description, link;
    private double markWeight;
    private int type;
    private String author;
    private static int count = 0;

    public Problem(String dateCreated, String name, String description, String link, double mark_weight, int type, String author) {
        this.ID = count++;
        this.dateCreated = dateCreated;
        this.name = name;
        this.description = description;
        this.link = link;
        this.markWeight = markWeight;
        this.type = type;
        this.author = author;
    }

    public Problem() {
        this.ID = count++;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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

    public double getMarkWeight() {
        return markWeight;
    }

    public void setMarkWeight(double markWeight) {
        this.markWeight = markWeight;
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
    
}


