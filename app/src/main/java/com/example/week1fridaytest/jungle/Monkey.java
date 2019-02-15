package com.example.week1fridaytest.jungle;

public class Monkey extends Animal{
    private static int count = 0;

    public Monkey() {
        count++;
    }

    @Override
    public void makeSound() {
        energy-=4;
        System.out.println("Oooo Oooo " + "Energy lvl: " + energy);
    }

    @Override
    public void eatFood(String type) {
        energy+=2;
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public int getSpeciesCount() {
        System.out.println("Count: " + count);
        return count;
    }

    public void play() {
        energy-=8;
        if (energy < 0)
            System.out.println("Monkey is too tired");
        else System.out.println("Oooo Oooo Oooo");
    }
}
