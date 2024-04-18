/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 *  
 * % java driverClass
 */

package org.dealership.Entities;

public class Vehicle{

    public String VehicleMake;
    public String VehicleModel; 
    public String VehicleType; 
    public String VehicleColor;
    public String VehicleYear; 
    public String VehicleTransmission; 
    public String VehicleMiles; 
    public String VehicleCondition; 
    public String VehiclePrice;
    public String VehicleAvail;
    public Float VehicleDiscount;
    public String OrderFrom;

    public Vehicle(String vehMake, String vehModel, String vehType, String vehColor, String vehYear, 
                    String vehTransmission, String vehMiles, String vehCondition, String vehPrice,
                    String vehAvail, Float vehDisc){
        this.VehicleMake = (vehMake);
        this.VehicleModel = (vehModel);
        this.VehicleType = (vehType);
        this.VehicleColor = (vehColor);
        this.VehicleYear = (vehYear);
        this.VehicleTransmission =  (vehTransmission);
        this.VehicleMiles =  (vehMiles);
        this.VehicleCondition =  (vehCondition);
        this.VehiclePrice =  (vehPrice);
        this.VehicleAvail =  (vehAvail);
        this.VehicleDiscount = (vehDisc);
    }

    public Vehicle(String vehMake, String vehModel, String vehType, String vehColor, String vehYear, 
                    String vehTransmission, String vehMiles, String vehCondition, String vehPrice,
                    String vehAvail, String Place){
        this.VehicleMake = (vehMake);
        this.VehicleModel = (vehModel);
        this.VehicleType = (vehType);
        this.VehicleColor = (vehColor);
        this.VehicleYear = (vehYear);
        this.VehicleTransmission =  (vehTransmission);
        this.VehicleMiles =  (vehMiles);
        this.VehicleCondition =  (vehCondition);
        this.VehiclePrice =  (vehPrice);
        this.VehicleAvail =  (vehAvail);
        this.OrderFrom = (Place);
    }

    public String getVehicleMake(){
        return VehicleMake;
    }

    public String getVehicleModel(){
        return VehicleModel;
    }

    public String getVehicleType(){
        return VehicleType;
    }

    public String getVehicleColor(){
        return VehicleColor;
    }

    public String getVehicleYear(){
        return VehicleYear;
    }

    public String getVehicleTransmission(){
        return VehicleTransmission;
    }

    public String getVehicleMiles(){
        return VehicleMiles;
    }

    public String getVehicleCondition(){
        return VehicleCondition;
    }

    public String getVehiclePrice(){
        return VehiclePrice;
    }

    public String getVehicleAvail(){
        return VehicleAvail;
    }

    public Float getVehicleDiscount(){
        return VehicleDiscount;
    }

}
