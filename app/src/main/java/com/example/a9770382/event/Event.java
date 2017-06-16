package com.example.a9770382.event;

import android.icu.util.Calendar;
import android.media.Image;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 9770382 on 14/06/2017.
 */

public class Event {
    private ArrayList<String> genre;
    private Calendar data;
    private String name;
    private String description;
    private HashMap<String,String> location;
    private Time startTime;
    private Time endTime;
    private double cost;
    private Image image;

    public Event(){

    }
    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
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

    public HashMap<String, String> getLocation() {
        return location;
    }

    public void setLocation(HashMap<String, String> location) {
        this.location = location;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
