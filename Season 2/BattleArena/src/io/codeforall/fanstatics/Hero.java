package io.codeforall.fanstatics.hero;

import io.codeforall.fanstatics.AbstractAbility;
import io.codeforall.fanstatics.Warrior;
import io.codeforall.fanstatics.Ability;
import io.codeforall.fanstatics.AbstractAbility;

public abstract class Hero {
    private String name;
    private String type;
    private int health = 200;
    private int mana = 500;
    private int attackDamage = 20;
    private int shield;

    private AbstractAbility ability;

    public Hero(String type, String name){
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public AbstractAbility getAbility() {
        return ability;
    }

    public void setAbility(AbstractAbility ability) {
        this.ability = ability;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getShield(){
        return this.shield;
    }

    public void setShield(int shield){
        this.shield = shield;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void giveDamage(Hero victim){
        if(victim instanceof Warrior && ((Warrior) victim).shieldOn){
            if(victim.getShield() > 10){
                victim.setShield(victim.getShield() - 10);
                return;
            }
            victim.setHealth(victim.getHealth() - (10 - victim.getShield()));
            victim.setShield(0);
        }
    }
}