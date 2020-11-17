
package entity;

import java.io.Serializable;


public class Participator implements Serializable {
    private int ID;

    private String name, email, phone, password;
    private int rank;
    private static int countParticipator = 0;
    public Participator() {
        this.ID = countParticipator++;
    }
    
    public void setCount(int count) {
        countParticipator = count;
    }

    public Participator(String name, String email, String phone, String password, int rank) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.rank = rank;
        this.ID = countParticipator++;
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

