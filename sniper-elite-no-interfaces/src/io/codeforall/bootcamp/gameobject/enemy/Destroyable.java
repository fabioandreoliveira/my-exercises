package io.codeforall.bootcamp.gameobject.enemy;

public interface Destroyable {

    public abstract void hit(int damage);

    public abstract boolean inDestroyed();
}
