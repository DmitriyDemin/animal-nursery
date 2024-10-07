package model;

import java.util.ArrayList;

public class Nursery {
    private ArrayList<Animal> animalNursery = new ArrayList<Animal>();
    private String titleNursery;

    public Nursery(String title){
        this.titleNursery = title;
//        ArrayList<Animal> animalNursery = new ArrayList<Animal>();
    }

    public void add_animal (Animal animal){
        animalNursery.add(animal);
    }

    public int size_nursery (){
        int size = animalNursery.size();
        return size;
    }


//    @Override
//    public String toString(){
//        return for (Animal animal );
//    }



}
