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


public class Contestant implements Serializable {
    private int ID;

    private String name, email, phone, password;
    private int rank;
    private static int cntContestant = 0;
    public Contestant() {
        this.ID = cntContestant++;
    }
    
    public void setCnt(int cnt) {
        cntContestant = cnt;
    }

    public Contestant(String name, String email, String phone, String password, int rank) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.rank = rank;
        this.ID = cntContestant++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    @Override
    public String toString() {
        return "Contestant{" + "ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + ", rank=" + rank + '}';
    }
    
}

