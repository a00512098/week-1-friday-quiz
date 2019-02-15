package com.example.week1fridaytest.jungle;

public class Tiger extends Animal {
    private static int count = 0;

    public Tiger() {
        count++;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Roar! " + "Energy lvl: " + energy);
    }

    @Override
    public void sleep() {
        energy+=5;
    }

    @Override
    public int getSpeciesCount() {
        System.out.println("Count: " + count);
        return count;
    }

    @Override
    public void eatFood(String type) {
        if (type.equals("grain")) {
            System.out.println("Tigers cannot eat grain!");
            return;
        }
        super.eatFood(type);
    }
}
