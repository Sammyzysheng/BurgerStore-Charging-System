package com.timbuchalka;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

class Burger {
    // The purpose of the application is to help a ficticious company called Bills Burgers to manage
    // their process of selling hamburgers
    // Our application will help Bill to select types of burgers, some of the additional items (additions) to
    // be added to the burgers and pricing.
    // We want to create a base hamburger, but also two other types of hamburgers that are popular ones in
    // Bills store.
    // The basic hamburger should have the following items.
    // bread roll type, meat and up to 4 additional additions (things like lettuce, tomato, carrot, etc) that
    // the customer can select to be added to the burger.
    // Each one of these items gets charged an additional
    // price so you need some way to track how many items got added and to calculate the final price (base
    // burger with all the additions).
    // This burger has a base price and the additions are all seperately priced (up to 4 additions, see above).
    // Create a Hamburger class to deal with all the above.
    // The constructor should only include the roll type, meat and price, can also include name of burger or you can use setter.
    // Also create two extra varieties of Hamburgers (subclasses) to cater for
    String breadRoll;
    String meat;
    double price;
    int lettuce;
    int tomato;
    int carrot;
    int butter;

    public Burger(String breadRoll, String meat) {
        this.breadRoll = breadRoll;
        this.meat = meat;
        double price= 3.5;
        this.lettuce=0;
        this.tomato=0;
        this.carrot=0;
        this.butter=0;

        if ("brown rye".equals(breadRoll)) {
            price += 1;
        } else if ("rye".equals(breadRoll)) {
            price += 0.5;
        } else {
            price += 0;
        }


        if(meat=="beef"){
            price+=2;
        }
        else{
            price+=1;
        }
        this.price=price;
    }


    public void setLettuce(int lettuce) {
        this.lettuce = lettuce;
    }

    public void setTomato(int tomato) {
        this.tomato = tomato;
    }

    public void setCarrot(int carrot) {
        this.carrot = carrot;
    }

    public void setButter(int butter) {
        this.butter = butter;
    }
    public void pricing(){
        this.price=this.price+(this.lettuce+this.tomato+this.carrot+this.butter)*0.5;

        System.out.println("The hamburger is made of "+this.breadRoll+" "+this.meat+".");
        System.out.println("Ingredients are: ");
        if(this.lettuce>0){
            System.out.println(this.lettuce+" lettuce");
        }
        if(this.tomato>0){
            System.out.println(this.tomato+" tomato");
        }
        if(this.carrot>0){
            System.out.println(this.carrot+" carrot");
        }
        if(this.butter>0){
            System.out.println(this.butter+" butter");
        }

    }
    public void getPrice(){
        System.out.println("The burger is "+this.price+" dollars.");
    }
}
// a) Healthy burger (on a brown rye bread roll), plus two addition items can be added.
// The healthy burger can have 6 items (Additions) in total.
// hint:  you probably want to process the 2 additional items in this new class (subclass of Hamburger), not the base class (Hamburger),
// since the 2 additions are only appropriate for this new class (in other words new burger type).
// b) Deluxe hamburger - comes with chips and drinks as additions, but no extra additions are allowed.
// hint:  You have to find a way to automatically add these new additions at the time the deluxe burger
// object is created, and then prevent other additions being made.
//  All 3 classes should have a method that can be called anytime to show the base price of the hamburger
// plus all additionals, each showing the addition name, and addition price, and a grand/final total for the
// burger (base price + all additions)
// For the two additional classes this may require you to be looking at the base class for pricing and then
// adding totals to final price.
class healthyBurger extends Burger{
    int mushrooms;
    int cabbage;

    public healthyBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
        this.breadRoll="brown rye";

    }

    public void setMushrooms(int mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setCabbage(int cabbage) {
        this.cabbage = cabbage;
    }
    @Override
    public void pricing(){
        super.pricing();
        if(this.mushrooms>0){
            System.out.println(this.mushrooms+" mushrooms");}
        if(this.cabbage>0){
            System.out.println(this.cabbage+" cabbage");
        }
        this.price=this.price+(this.mushrooms+this.cabbage)*0.5;
    }
    //b) Deluxe hamburger - comes with chips and drinks as additions, but no extra additions are allowed.
// hint:  You have to find a way to automatically add these new additions at the time the deluxe burger
// object is created, and then prevent other additions being made.
}
class Deluxe extends Burger{
    String chips;
    String drinks;


    public Deluxe(String breadRoll, String meat,String chips,String drinks) {
        super(breadRoll, meat);
        this.chips=chips;
        this.drinks=drinks;
        this.price=7.0;
    }



    @Override
    public void pricing(){
        super.pricing();
        System.out.println("With chips: "+this.chips+" and "+this.drinks);
    }


}
public class Main{
    public static void main(String [] args){
        Burger burger=new Burger("brown rye","beef");
        burger.setButter(1);
        burger.setCarrot(2);
        burger.pricing();
        burger.getPrice();

        healthyBurger hamburger1=new healthyBurger("rye","chicken");
        hamburger1.setCabbage(2);
        hamburger1.setMushrooms(2);
        hamburger1.setTomato(1);
        hamburger1.pricing();
        hamburger1.getPrice();

        Deluxe deluxe=new Deluxe("white","beef","lays","coco");
        deluxe.setCarrot(1);
        deluxe.pricing();
        deluxe.getPrice();


    }
}