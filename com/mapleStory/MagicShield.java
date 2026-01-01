/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mapleStory;

/**
 *
 * @author jites
 */
public class MagicShield {
    // Instance variables
    private double radius;
    private double thickness;
    private String elementType;
    
    // Static variables
    private static final double DEFAULT_RADIUS = 1.0;
    private static final double DEFAULT_THICKNESS = 5.0;
    private static int shieldCount = 0;
    
    // No argument constructor
    public MagicShield(){
        this.radius = DEFAULT_RADIUS;
        this.thickness = DEFAULT_THICKNESS;
        this.elementType = "Neutral";
        shieldCount++;
    }
    
    // Parametric constructor
    public MagicShield(double radius, double thickness, String elementType){
        this.radius = radius;
        this.thickness = thickness;
        this.elementType = elementType;
        shieldCount++;
    }
    
    // Encapsulation methods
    public void setRadius(double radius){
        if (radius < 0){
            throw new IllegalArgumentException("Invalid radius.");
        }
        else {
            this.radius = radius;
        }
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setThickness(double thickness){
        if (thickness < 0){
            throw new IllegalArgumentException("Invalid thickness.");
        }
        else {
            this.thickness = thickness;
        }
    }
    
    public double getThickness(){
        return thickness;
    }
    
    public void setElementType(String type){
        if (type == null || type.equals("")){
            elementType = "Neutral";
        }
        else {
            elementType = type;
        }
    }
    
    public String getElementType(){
        return elementType;
    }
    
    // Instance methods
    public double calculateDefensePower(){
        return calculateDefensePower(this.radius, this.thickness, this.elementType);
    }
    
    public double calculateManaCost(){
        return calculateManaCost(this.radius, this.thickness);
    }
    
    /**
     *
     * @return String format*/
    @Override
    public String toString(){
        return String.format(
                        "[MagicShield Info]%n" +
                        "Element Type: %s%n" + 
                        "Radius: %.1f m%n" +
                        "Thickness: %.1f cm%n" +
                        "Defense Power: %.2f%n" +
                        "Mana Cost: %.1f%n",
                this.elementType, this.radius, this.thickness, calculateDefensePower(),calculateManaCost()
        );
    }
    
    // Static methods
    public static int getShieldCount(){
        return shieldCount;
    }
    
    public static boolean isValidSize(double size){
        return size >= 0;
    }
    
    public static double calculateManaCost(double radius, double thickness){
        return radius * 10 + thickness * 2;
    }
    
    public static double calculateDefensePower(double radius, double thickness, String elementType){
        double coeff = 0;
        coeff = switch (elementType) {
            case "Fire" -> 1.1;
            case "Ice" -> 1.2;
            case "Light" -> 1.3;
            case "Dark" -> 1.4;
            default -> 1.0;
        };
        return (radius * thickness) * coeff;
    }
}
