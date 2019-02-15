package com.example.week1fridaytest.jungle;

public abstract class Animal {

    protected int energy;

    Animal() {
    }

    public void makeSound() {
        energy-=3;
    }

    public void eatFood(String type) {
        energy+=5;
    }

    public void sleep() {
        energy+=10;
    }

    public abstract int getSpeciesCount();

    public static void main(String[] args) {
        Monkey monkey1 = new Monkey();
        Monkey monkey2 = new Monkey();
        Monkey monkey3 = new Monkey();

        monkey1.getSpeciesCount();
        monkey2.sleep();
        monkey3.play();
        monkey1.makeSound();
        monkey2.play();

        Tiger tiger1 = new Tiger();
        Tiger tiger2 = new Tiger();
        Tiger tiger3 = new Tiger();
        Tiger tiger4 = new Tiger();

        tiger1.eatFood("grain");
        tiger1.eatFood("fish");
        tiger2.makeSound();
        tiger3.sleep();
        tiger4.getSpeciesCount();
    }
}
