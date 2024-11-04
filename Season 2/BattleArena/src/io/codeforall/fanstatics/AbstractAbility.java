package io.codeforall.fanstatics;

public abstract class AbstractAbility implements Ability {
    protected String name;
    protected int power;

    public AbstractAbility(String name, int power) {
        this.name = name;
        this.power = power;
    }
}
