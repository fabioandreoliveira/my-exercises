package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Car {

    /*public int carRow;
    public int carCol;

    public Car (int carRow, int carCol) {
        this.carCol = carCol;
        this.carRow = carRow;
    }

     */


    /** The position of the car on the grid */
    private Position pos;
    public Car (Position pos){
        this.pos=pos;
    }
    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return false;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


