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
    @Column(name = "status", length = 45, nullable = false)
    private String status;

}
