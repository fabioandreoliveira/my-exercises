package io.codeforall.fanstatics;

import io.codeforall.fanstatics.hero.Hero;

public class SneakAttack extends io.codeforall.fanstatics.ability.AbstractAbility {
    public SneakAttack(String name) {
        super(name);
    }

    @Override
    public void use(Hero source, Hero target) {
        source.setMana(source.getMana() - 20);
        target.setHealth(target.getHealth() - 20);
        source.getAbility().setCooldown(5);
    }
}