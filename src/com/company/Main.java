package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Commodity{
    private String number;
    private String name;
    private float price;

    Commodity(String number, String name, float price){
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}

class Management{
    private ArrayList <Commodity> commodities;

    Management(){
        commodities = new ArrayList<>();
    }

    public void addCommodity(Commodity commodity){
        commodities.add(commodity);
        System.out.println("Add new commodity successfull!");
    }

    public void commodity_info(String number){
        int i;
        for(i=0;i<commodities.size();i++){
            Commodity commodity = commodities.get(i);
            if(commodity.getNumber().equals(number)){
                System.out.println("This commodity's info:");
                System.out.println("Commodity number is:" + commodity.getNumber());
                System.out.println("Commodity name is:" + commodity.getName());
                System.out.println("Commodity price is:" + commodity.getPrice());
                break;
            }
        }
        if(i==commodities.size()){
            System.out.println("Sorry, commodity not Found !!!");
        }
    }

    public void modify_price(String number, float price){
        int i;
        for(i=0;i<commodities.size();i++){
            Commodity commodity = commodities.get(i);
            if(commodity.getNumber().equals(number)) {
                commodity.setPrice(price);
                System.out.println("Modify commodity's price successful.");
                break;
            }
        }
        if(i==commodities.size()) {
            System.out.println("Sorry, commodity not Found£¬modify commodify's price Failed£¡£¡£¡");
        }
    }

    public void delete_commodify(String number){
        int i;
        if(commodities.size()==0){
            System.out.println("There is no commodify in the store");
        }

        for(i=0;i<commodities.size();i++){
            Commodity commodity = commodities.get(i);
            if(commodity.getNumber().equals(number)) { /* No need to overwrite when String */
                commodities.remove(i);
                System.out.println("Modify commodity's price successful.");
                break;
            }
        }

        if((i==commodities.size()) && (commodities.size()!=0)){
            System.out.println("Sorry, commodify not Found!!!");
        }


    }
}



public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        Management commodity_management = new Management();
        BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10000;i++) {
            System.out.println("Please choose operation:");
            System.out.println("1) Add commodity");
            System.out.println("2) Search commodity infomation");
            System.out.println("3) Modify commodity price");
            System.out.println("4) Delete commodity");
            System.out.println("0) Quit");
        }

        String op_no = sr.readLine();
        switch (op_no) {
            case "1": {
                System.out.println("Input commodity number:");
                String number = sr.readLine();
                System.out.println("Input commodity name;");
                String name = sr.readLine();
                System.out.println("Input commodify price:");
                float price = Float.parseFloat(sr.readLine());

                Commodity commodity = new Commodity(number, name, price);
                commodity_management.addCommodity(commodity);
                break;
            }
            case "2": {
                System.out.println("Input commodity number:");
                String number = sr.readLine();
                commodity_management.commodity_info(number);
                break;
            }
            case "3": {
                System.out.println("Input commodify price:");
                String number = sr.readLine();
                System.out.println("Input new price:");
                float price = Float.parseFloat(sr.readLine());
                commodity_management.modify_price(number, price);
                break;
            }
            case "4": {
                System.out.println("Input commodity number:");
                String number = sr.readLine();
                commodity_management.delete_commodify(number);
                break;
            }
            case "0":
                System.out.println("Thanks,byebye");
                System.exit(0);
            default:
                System.out.println("Input ERROR, Please input again:");
                break;
        }

    }
}
