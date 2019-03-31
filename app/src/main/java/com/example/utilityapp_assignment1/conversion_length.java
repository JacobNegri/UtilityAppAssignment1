package com.example.utilityapp_assignment1;

public class conversion_length {

    //Variables of each unit comparison, with the base unit used as 1 kilometre

    final double killometres = 1;
    final double metres = 1000;
    final double centimetres = 100000;
    final double millimetres = 1000000;

    //input and output data variables

    private double beginning_qty;
    private double ending_qty;
    private String beg_unit_type;
    private String end_unit_type;


    public LengthConversion(){
        beginning_qty = 0;
        ending_qty = 0;
        beg_unit_type = "";
        end_unit_type = ""
    }

    public double getStartingValue() {
        return beginning_qty;
    }

    public void setStartingValue(double beginning_qty) {
        this.beginning_qty = beginning_qty
    }

    public double getEndingValue() {
        return ending_qty;
    }

    public void setEndingValue(double ending_qty) {
        this.ending_qty = ending_qty;
    }

    public String getStartUnitType() {
        return beg_unit_type
    }

    public void setStartUnitType(String beg_unit_type) {
        this.beg_unit_type = beg_unit_type;
    }

    public String getEndUnitType() {
        return end_unit_type;
    }

    public void setEndUnitType(String end_unit_type) {
        this.end_unit_type = end_unit_type;
    }

    
}
