package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<FarmAnimal> animals = new ArrayList<>();

//    public void addPig(Pig pig) {
//        animals.add(pig);
//    }
//
//    public void addCow(Cow cow) {
//        animals.add(cow);
//    }
//
//    public void addChicken(Chicken chicken) {
//        animals.add(chicken);
//    }

    public void addFarmAnimal(FarmAnimal farmAnimal) {
        animals.add(farmAnimal);
    }
}
