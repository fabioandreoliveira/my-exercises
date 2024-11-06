package io.codeforall.fanstatics.hero;

import io.codeforall.fanstatics.ability.Heal;

public class Cleric extends io.codeforall.fanstatics.hero.Hero {
    public Cleric(String name){
        super("Cleric", name);
        this.setAbility(new Heal("Heal"));
    }
}