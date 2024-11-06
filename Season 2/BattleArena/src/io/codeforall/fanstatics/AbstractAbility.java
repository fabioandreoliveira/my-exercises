package io.codeforall.fanstatics;

public abstract class AbstractAbility implements io.codeforall.fanstatics.Ability {
    private int cooldown;
    private String name;

    public AbstractAbility(String name){
        this.cooldown = 0;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public abstract void use(io.codeforall.fanstatics.hero.Hero source, io.codeforall.fanstatics.hero.Hero target);
}