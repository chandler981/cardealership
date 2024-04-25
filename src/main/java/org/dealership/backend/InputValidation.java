/*
 * Author:       Chandler Ward
 * Written:      4 / 16 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is specifically made to have a class
 * that takes input from controller classes and runs
 * the inputs in those textfields through methods created
 * in this class to do input validatin or regex on them.
 * 
 * The methods will return true if the inputs match the patterns
 * and false if else.
 *  
 * % java driverClass
 */

package org.dealership.backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputValidation {

    /*
     * These are the patterns used through out the entire program to 
     * check inputs on all of the controller classes.
     */

     /*
      * If anything is to be changed in this class there is a single method that corresponds to 
      * each pattern so if you change a pattern then the method will automatically be able to handle it.
      * However if you need to change something in the method you will need to make sure the pattern can still
      * be used with it and work correctly.
      */

    //these patterns deal with matching information with people
    String namePattern = "^[a-zA-Z]+\\s[a-zA-Z]+$";
    String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";
    String addressPattern = "^\\d+\\s+([A-Za-z0-9\\s\\-\\.]+)(?:\\s(?:Ave|St|Blvd|Rd|Dr|Ln|Ct|Pl|Sq|Pkwy|Way|Cres|Al|Alley|Circle))?(?:\\s(?:E|W|N|S))?$";
    String bankNumPattern = "^^\\d{9,18}$";
    String phoneNumPattern = "^\\(\\d{3}\\)\\s?\\d{3}-\\d{4}$";
    String IDPattern = "^\\d{4}$";
    String commissionPattern = "^\\d+(\\.\\d{1,2})?$";
    String creditScorePattern = "^\\d{3}$";
    String birthDayPattern = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$";
    String zipCodePattern = "^\\d{5}(?:-\\d{4})?$";
    String statePattern = "^[A-Z]{2}$";
    String licenseNumberPattern = "^[A-Za-z0-9]{6,10}$";
    String insuranceNumberPattern = "^[A-Za-z0-9]{6,20}$";

    //these patterns deal with matching information with vehicles
    String carColorPattern = "^([A-Za-z]+|\\s*)$";
    String carMakePattern = "^([A-Za-z]+(?:\\s[A-Za-z]+)*)$";
    String carMileagePattern = "^\\d+(?:,\\d{3})*$";
    String carModelPattern = "^([A-Za-z0-9]+(?:\\s[-A-Za-z0-9]+)*)$";
    String carTransmissionPattern = "^(Automatic|Manual|Semi-Automatic)$";
    String carTypePattern = "^([A-Za-z]+(?:\\s[A-Za-z]+)*)$";
    String carVINPattern = "^[A-HJ-NPR-Z0-9]{17}$";
    String carYearPattern = "^(19|20)\\d{2}$";
    String carConditionPattern = "^(New|Used)$";

    //This commented out method is a template for a inputValidation method
    // public boolean *Validation(){
    //     Pattern pattern = Pattern.compile();
    //     Matcher matcher = pattern.matcher();
    //     if(matcher.matches()){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }
    // }

    //This commented out if statement is a template that can be used in controller classes
    //to clear a text field if the input is invalid.
    // if(!validation.Validation(name.getText())){
    //     allValid = false;
    //     name.clear();
    // }

    //This is a template for a line in the test files that will let you test these input validation methods.
    //it can be true or false and word is replaced with the input to the specific method
    //Assert.assertEquals(true, word);

    //This commented out part is for the objects and variable required for doing RegEx in the controller classes
    // InputValidation validation = new InputValidation();
    // boolean allValid = true;
    
    //Methods for checking patterns dealing with people
    public boolean CreditScoreValidation(String score){
        Pattern pattern = Pattern.compile(creditScorePattern);
        Matcher matcher = pattern.matcher(score);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean BirthDayValidation(String birthDay){
        Pattern pattern = Pattern.compile(birthDayPattern);
        Matcher matcher = pattern.matcher(birthDay);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean ZipCodeValidation(String zipCode){
        Pattern pattern = Pattern.compile(zipCodePattern);
        Matcher matcher = pattern.matcher(zipCode);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean StateAbrvValidation(String state){
        Pattern pattern = Pattern.compile(statePattern);
        Matcher matcher = pattern.matcher(state);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean LicenseNumberValidation(String LicenseNum){
        Pattern pattern = Pattern.compile(licenseNumberPattern);
        Matcher matcher = pattern.matcher(LicenseNum);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean InsuranceNumberValidation(String InsuranceNum){
        Pattern pattern = Pattern.compile(insuranceNumberPattern);
        Matcher matcher = pattern.matcher(InsuranceNum);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean IDValidaiton(String ID){
        Pattern pattern = Pattern.compile(IDPattern);
        Matcher matcher = pattern.matcher(ID);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean commissionValidation(String commission){

        double commissionCheck;
        try{
            commissionCheck = Double.parseDouble(commission);
            Pattern pattern = Pattern.compile(commissionPattern);
            Matcher matcher = pattern.matcher(commission);
            if(matcher.matches()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean NameValidation(String name){
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean AddressValidation(String address){
        Pattern pattern = Pattern.compile(addressPattern);
        Matcher matcher = pattern.matcher(address);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean SSNValidation(String ssn){
        Pattern pattern = Pattern.compile(ssnPattern);
        Matcher matcher = pattern.matcher(ssn);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean PhoneNumValidation(String phoneNum){
        Pattern pattern = Pattern.compile(phoneNumPattern);
        Matcher matcher = pattern.matcher(phoneNum);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean BankNumValidation(String bankNum){
        Pattern pattern = Pattern.compile(bankNumPattern);
        Matcher matcher = pattern.matcher(bankNum);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Methods for checking patterns dealing with vehicles
    public boolean carColorValidation(String color){
        Pattern pattern = Pattern.compile(carColorPattern);
        Matcher matcher = pattern.matcher(color);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    
    }
    public boolean carMakeValidation(String Make){
        Pattern pattern = Pattern.compile(carMakePattern);
        Matcher matcher = pattern.matcher(Make);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carMileageValidation(String miles){
        Pattern pattern = Pattern.compile(carMileagePattern);
        Matcher matcher = pattern.matcher(miles);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carModelValidation(String Model){
        Pattern pattern = Pattern.compile(carModelPattern);
        Matcher matcher = pattern.matcher(Model);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carTransmissionValidation(String Transmission){
        Pattern pattern = Pattern.compile(carTransmissionPattern);
        Matcher matcher = pattern.matcher(Transmission);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carTypeValidation(String Type){
        Pattern pattern = Pattern.compile(carTypePattern);
        Matcher matcher = pattern.matcher(Type);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carVINValidation(String VIN){
        Pattern pattern = Pattern.compile(carVINPattern);
        Matcher matcher = pattern.matcher(VIN);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carYearValidation(String Year){
        Pattern pattern = Pattern.compile(carYearPattern);
        Matcher matcher = pattern.matcher(Year);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean carConditionValidation(String Condition){
        Pattern pattern = Pattern.compile(carConditionPattern);
        Matcher matcher = pattern.matcher(Condition);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
}