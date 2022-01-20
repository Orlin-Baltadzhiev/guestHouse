package com.GuestHouseBaltadzhiev.model.service;

public class ReservationServiceModel {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String date;
    private String time;
    private int People;
    private String message;

    public ReservationServiceModel(){
    }

    public Long getId(){
        return id;
    }

    public ReservationServiceModel setId(Long id){
        this.id = id;
        return this;
    }

    public String getName(){
        return name;
    }

    public ReservationServiceModel setName(String name){
        this.name = name;
        return this;
    }

    public String getEmail(){
        return email;
    }

    public ReservationServiceModel setEmail(String email){
        this.email = email;
        return this;
    }

    public String getPhone(){
        return phone;
    }

    public ReservationServiceModel setPhone(String phone){
        this.phone = phone;
        return this;
    }

    public String getDate(){
        return date;
    }

    public ReservationServiceModel setDate(String date){
        this.date = date;
        return this;
    }

    public String getTime(){
        return time;
    }

    public ReservationServiceModel setTime(String time){
        this.time = time;
        return this;
    }

    public int getPeople(){
        return People;
    }

    public ReservationServiceModel setPeople(int people){
        People = people;
        return this;
    }

    public String getMessage(){
        return message;
    }

    public ReservationServiceModel setMessage(String message){
        this.message = message;
        return this;
    }
}
