package com.project.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class OilRig {

    private int id;
    private String name = "Default";

    private String coordinates;

    private float amountOfOilProductionPerDay;

    private int fillingOfTank;

    private String dateOfShipmentOil;

    public OilRig(int id, String name, String coordinates, float amountOfOilProductionPerDay, int fillingOfTank, String dateOfShipmentOil) {
        this.name = name;
        this.coordinates = coordinates;
        this.amountOfOilProductionPerDay = amountOfOilProductionPerDay;
        this.fillingOfTank = fillingOfTank;
        this.id = id;
        this.dateOfShipmentOil = dateOfShipmentOil;
    }

    public static String getHeaders() {
        return "name, coordinates, amount of production per day, filling of tanks";
    }

    public String toCSV() {
        return this.getName() + "," + this.getCoordinates() + "," + this.getAmountOfOilProductionPerDay() + "," + this.getFillingOfTank();
    }

}
