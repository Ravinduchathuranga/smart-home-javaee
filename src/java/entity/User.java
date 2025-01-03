/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rc007
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;
    @Column(name = "password", length = 45, nullable = false)
    private String password;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "date_joined", nullable = false)
    private Date date_joined;
    @Column(name = "status", length = 10, nullable = false)
    private String status;

    public User() {
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the date_joined
     */
    public Date getDate_joined() {
        return date_joined;
    }

    /**
     * @param date_joined the date_joined to set
     */
    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
