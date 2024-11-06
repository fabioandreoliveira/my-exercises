package io.codeforall.fanstatics.ability;

import io.codeforall.fanstatics.AbstractAbility;
import io.codeforall.fanstatics.hero.Hero;

public class ShieldBlock extends AbstractAbility {
    public ShieldBlock(String name) {
        super(name);
    }

    @Override
    public void use(Hero source, Hero target) {
        source.setMana(source.getMana() - 20);
        target.setShield(20);
        source.getAbility().setCooldown(5);
    }
}