package com.example.dagger2example.car;

public class Wheels {

   private Rims rims;
   private Tires tires;

   public Wheels(Rims rims, Tires tires) {
       this.rims = rims;
       this.tires = tires;
   }
}
