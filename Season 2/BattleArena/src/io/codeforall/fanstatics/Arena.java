package io.codeforall.fanstatics;

import java.util.List;
import java.util.ArrayList;

public class Arena {
    private List<Hero> heroes;

    public Arena() {
        heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void startBattle() {
        while (heroes.size() > 1) {
            for (int i = 0; i < heroes.size(); i++) {
                Hero attacker = heroes.get(i);
                if (!attacker.isAlive()) continue;

                int targetIndex = (i + 1) % heroes.size();
                Hero target = heroes.get(targetIndex);

                attacker.useAbility(0, target); // use the first ability
                if (!target.isAlive()) {
                    heroes.remove(target);
                }
            }
        }

        if (heroes.size() == 1) {
            System.out.println(heroes.get(0).getName() + " is the winner!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}