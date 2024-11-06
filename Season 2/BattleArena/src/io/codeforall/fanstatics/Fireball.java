package io.codeforall.fanstatics.ability;

import io.codeforall.fanstatics.AbstractAbility;
import io.codeforall.fanstatics.hero.Hero;
import io.codeforall.fanstatics.hero.Warrior;

public class Fireball extends AbstractAbility {

    public Fireball(String name) {
        super(name);
    }

    @Override
    public void use(Hero source, Hero target) {
        source.setMana(source.getMana() - 20);
        if (target instanceof Warrior && ((Warrior) target).shieldOn) {
            if (target.getShield() > 20) {
                target.setShield(target.getShield() - 20);
                return;
            }
            target.setHealth(target.getHealth() - (20 - target.getShield()));
            target.setShield(0);
            return;
        }
        target.setHealth(target.getHealth() - 60);
        source.getAbility().setCooldown(5);
    }
}