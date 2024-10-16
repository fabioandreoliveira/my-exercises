package io.codeforall.bootcamp.field;

public class Position {

    public int row;
    public int col;

    public Position (){
        this.col = (int) (Math.random()*Field.getWidth()-1);
        this.row=(int) (Math.random()*Field.getHeight()-1);
    }



    public int getCol() {

        return col;
    }

    public int getRow() {
        return row;
    }
}
