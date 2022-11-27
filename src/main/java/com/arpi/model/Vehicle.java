package com.arpi.model;

public enum Vehicle{
	
	//Vehicles with consumptions
	
    SCOOTER(1),
    CAR(7),
    TRUCK(20);

    public final Integer value;

    private Vehicle(Integer value) {
        this.value= value;
    }
}