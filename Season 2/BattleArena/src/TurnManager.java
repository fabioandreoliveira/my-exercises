import java.util.List;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TurnManager {
    private Queue<Hero> turnQueue;

    public TurnManager(List<Hero> heroes) {
        Collections.shuffle(heroes);
        this.turnQueue = new LinkedList<>(heroes);
    }


    public Hero getNextHero() {
        Hero currentHero = turnQueue.poll();
        if (currentHero != null && currentHero.isAlive()) {
            turnQueue.offer(currentHero);
        }
        return currentHero;
    }


    public boolean isGameOver() {
        long aliveHeroes = turnQueue.stream().filter(Hero::isAlive).count();
        return aliveHeroes <= 1;
    }


    public List<Hero> getHeroes() {
        return List.copyOf(turnQueue);
    }
}
