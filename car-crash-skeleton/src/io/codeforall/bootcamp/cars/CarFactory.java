package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class CarFactory {



    public static  Car getNewCar() {
        return new Car(new Position());

    }

    }
