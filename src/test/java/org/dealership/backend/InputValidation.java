/*
 * Author:       Chandler Ward
 * Written:      4 / 16 / 2024
 * Last Updated: 4 / 16 / 2024
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

    //these patterns deal with matching information with people
    String namePattern = "^[a-zA-Z]+\\s[a-zA-Z]+$";
    String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";
    String addressPattern = "^\\d+\\s+([A-Za-z0-9\\s\\-\\.]+)(?:\\s(?:Ave|St|Blvd|Rd|Dr|Ln|Ct|Pl|Sq|Pkwy|Way|Cres|Al|Alley|Circle))?(?:\\s(?:E|W|N|S))?$";
    String bankNumPattern = "^^\\d{9,18}$";
    String phoneNumPattern = "^\\(\\d{3}\\)\\s?\\d{3}-\\d{4}$";

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

    
    //Methods for checking patterns dealing with people
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