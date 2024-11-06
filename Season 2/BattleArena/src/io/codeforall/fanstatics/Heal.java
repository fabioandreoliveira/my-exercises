package io.codeforall.fanstatics;

import io.codeforall.fanstatics.AbstractAbility;
import io.codeforall.fanstatics.hero.Hero;

public class Heal extends AbstractAbility {
    public Heal(String name) {
        super(name);
    }

    @Override
    public void use(Hero source, Hero target){
        source.setMana(source.getMana() - 20);
        target.setHealth(target.getHealth() + 50);
        source.getAbility().setCooldown(5);
    }
}