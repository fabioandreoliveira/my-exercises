package io.codeforall.bootcamp.gameobject.enemy;

import io.codeforall.bootcamp.gameobject.GameObject;

public class Barrel extends GameObject implements Destroyable {

    @Override
    public void hit(int damage) {

    }

    @Override
    public boolean inDestroyed() {
        return false;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
