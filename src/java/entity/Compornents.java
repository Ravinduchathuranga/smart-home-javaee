/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rc007
 */
@Entity
@Table(name = "compornents")
public class Compornents implements Serializable {

    @Id
    @Column(name = "idcompornents")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_email")
    private String user_email;
    @Column(name = "bulbs", length = 10, nullable = false)
    private String bulbs;
    @Column(name = "fans", length = 10, nullable = false)
    private String fans;
    @Column(name = "doors", length = 10, nullable = false)
    private String doors;

    public Compornents() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email the user_email to set
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * @return the bulbs
     */
    public String getBulbs() {
        return bulbs;
    }

    /**
     * @param bulbs the bulbs to set
     */
    public void setBulbs(String bulbs) {
        this.bulbs = bulbs;
    }

    /**
     * @return the fans
     */
    public String getFans() {
        return fans;
    }

    /**
     * @param fans the fans to set
     */
    public void setFans(String fans) {
        this.fans = fans;
    }

    /**
     * @return the doors
     */
    public String getDoors() {
        return doors;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(String doors) {
        this.doors = doors;
    }

}
