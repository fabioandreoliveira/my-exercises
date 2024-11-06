package io.codeforall.fanstatics;

import io.codeforall.fanstatics.hero.Hero;

public interface Ability {
    public void use(Hero source, Hero target);
}