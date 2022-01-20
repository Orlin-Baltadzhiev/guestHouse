package com.GuestHouseBaltadzhiev.model.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
public class Reservation {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String date;

    private String time;

    private int People;

    private String message;

    public Reservation(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId(){
        return id;
    }

    public Reservation setId(Long id){
        this.id = id;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName(){
        return name;
    }

    public Reservation setName(String name){
        this.name = name;
        return this;
    }

    @Column(name = "email", nullable = false)
    @Email
    public String getEmail(){
        return email;
    }

    public Reservation setEmail(String email){
        this.email = email;
        return this;
    }


    @Column(name = "phone", nullable = false)
    public String getPhone(){
        return phone;
    }

    public Reservation setPhone(String phone){
        this.phone = phone;
        return this;
    }

    @Column(name = "date", nullable = false)
    public String getDate(){
        return date;
    }

    public Reservation setDate(String date){
        this.date = date;
        return this;
    }

    @Column(name = "time")
    public String getTime(){
        return time;
    }

    public Reservation setTime(String time){
        this.time = time;
        return this;
    }

    @Column(name = "people")
//    @Min(value = 1, message = "Must be more than 1")
    public int getPeople(){
        return People;
    }

    public Reservation setPeople(int people){
        People = people;
        return this;
    }

    @Column(name = "message", columnDefinition = "text")
    public String getMessage(){
        return message;
    }

    public Reservation setMessage(String message){
        this.message = message;
        return this;
    }
}
