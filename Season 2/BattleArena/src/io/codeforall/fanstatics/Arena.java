package io.codeforall.fanstatics;

import io.codeforall.fanstatics.hero.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Arena {
    private List<Hero> players;
    private TurnManager turnManager;

    public Arena(Hero... players) {
        this.players = new ArrayList<>();
        for (Hero hero : players) {
            this.players.add(hero);
        }
        this.turnManager = new TurnManager(this.players);
    }

    public void start(int rounds) {
        Stream.of(this.players).forEach(System.out::println);
        for (int i = 0; i < rounds; i++) {

            List<Hero> playerOrder = this.turnManager.newRound();

            Hero attacker = null;
            Hero victim = null;

            // choose an attacker and a victim
            for (int j = 0; j < playerOrder.size(); j++) {
                attacker = playerOrder.get(j);
                int k = j;
                while (k == j) {
                    k = (int) (Math.random() * playerOrder.size());
                }
                victim = playerOrder.get(k);
                //System.out.println(attacker + " against " + victim);

                // attack logic
                switch (attacker.getType()) {
                    case "Cleric":
                    case "Warrior":
                        if (attacker.getAbility().getCooldown() == 0) {
                            attacker.getAbility().use(attacker, attacker);
                            System.out.println(attacker + " has used " + attacker.getAbility().getName());
                            break;
                        }
                        attacker.giveDamage(victim);
                        System.out.println(attacker + " has given damage to " + victim);
                        break;
                    default:
                        if (attacker.getAbility().getCooldown() == 0) {
                            attacker.getAbility().use(attacker, victim);
                            System.out.println(attacker +
                                    " has used " + attacker.getAbility().getName() +
                                    " against " + victim);
                            break;
                        }
                        attacker.giveDamage(victim);
                        System.out.println(attacker + " has given damage to " + victim);
                        break;
                }
            }
        }
    }


}