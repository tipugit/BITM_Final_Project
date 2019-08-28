package com.example.tourmate;

public class Trip {


    private String tripName,tripDate,tripDiscription;
    private int tripImage;

    public Trip() {
    }

    public Trip(String tripName, String tripDate, String tripDiscription, int tripImage) {
        this.tripName = tripName;
        this.tripDate = tripDate;
        this.tripDiscription = tripDiscription;
        this.tripImage = tripImage;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripDate() {
        return tripDate;
    }

    public String getTripDiscription() {
        return tripDiscription;
    }

    public int getTripImage() {
        return tripImage;
    }
}
