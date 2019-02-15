package com.example.week1fridaytest.jungle;

public class Snake extends Animal {
    private static int count = 0;

    public Snake() {
        count++;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Sssssss " + "Energy lvl: " + energy);
    }

    @Override
    public int getSpeciesCount() {
        System.out.println("Count: " + count);
        return count;
    }
}
