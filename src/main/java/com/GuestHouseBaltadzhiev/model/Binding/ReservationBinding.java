package com.GuestHouseBaltadzhiev.model.Binding;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class ReservationBinding {

    private String name;
    private String email;
    private String phone;
    private String date;
    private String time;
    private String People;
    private String message;

    public ReservationBinding(){
    }


    @Length(min = 2, message = "Username length must be minimum two characters!.")
    public String getName(){
        return name;
    }

    public ReservationBinding setName(String name){
        this.name = name;
        return this;
    }

    @Column(name = "email", nullable = false)
    @Email(message = "Enter valid email address.")
    public String getEmail(){
        return email;
    }

    public ReservationBinding setEmail(String email){
        this.email = email;
        return this;
    }

    //@Column(name = "phone", nullable = false)
   // @Length(min = 9, message = "Enter valid phone number.")
    public String getPhone(){
        return phone;
    }

    public ReservationBinding setPhone(String phone){
        this.phone = phone;
        return this;
    }

    //@Column(name = "date", nullable = false)
    public String getDate(){
        return date;
    }

    public ReservationBinding setDate(String date){
        this.date = date;
        return this;
    }

   // @Column(name = "time")
   // @Length(min = 2, message = "Enter a valid time for check in.")
    public String getTime(){
        return time;
    }

    public ReservationBinding setTime(String time){
        this.time = time;
        return this;
    }

   // @Min(value = 2, message = "What is the number of the guests")
    public String getPeople(){
        return People;
    }

    public ReservationBinding setPeople(String people){
        People = people;
        return this;
    }


    public String getMessage(){
        return message;
    }

    public ReservationBinding setMessage(String message){
        this.message = message;
        return this;
    }
}
