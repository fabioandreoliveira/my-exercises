import java.util.List;

public class Arena {
    private final TurnManager turnManager;
    private int roundNumber = 1;

    public Arena(List<Hero> heroes) {
        this.turnManager = new TurnManager(heroes);
    }

    public void startBattle() {
        System.out.println("The battle begins!");

        while (!turnManager.isGameOver()) {
            System.out.println("\nRound " + roundNumber + ":");
            handleRound();
            roundNumber++;
        }

        System.out.println("\nThe battle is over!");
        announceWinner();
    }

    private void handleRound() {
        Hero currentHero = turnManager.getNextHero();
        if (currentHero != null && currentHero.isAlive()) {
            handleHeroTurn(currentHero);

            for (Ability ability : currentHero.getAbilities()) {
                ability.reduceCooldown();
            }
            currentHero.endTurn();
        }
        printHeroStats();
    }

    private void handleHeroTurn(Hero currentHero) {
        boolean abilityUsed = false;


        for (int i = 0; i < currentHero.getAbilities().size(); i++) {
            Ability ability = currentHero.getAbilities().get(i);
            if (ability.getCurrentCooldown() == 0) {
                Hero target = chooseTarget(currentHero);
                if (target != null && target.isAlive()) {
                    currentHero.useAbility(i, target);
                    abilityUsed = true;
                    break;
                }
            }
        }


        if (!abilityUsed) {
            Hero target = chooseTarget(currentHero);
            if (target != null && target.isAlive()) {
                currentHero.normalAttack(target);
            }
        }
    }

    private Hero chooseTarget(Hero currentHero) {

        List<Hero> aliveHeroes = turnManager.getHeroes().stream()
                .filter(Hero::isAlive)
                .filter(hero -> hero != currentHero)
                .toList();
        if (!aliveHeroes.isEmpty()) {
            return aliveHeroes.getFirst();
        }
        return null;
    }

    private void printHeroStats() {
        System.out.println("\nCurrent Hero Stats:");
        for (Hero hero : turnManager.getHeroes()) {
            if (hero.isAlive()) {
                System.out.println(hero.getName() + ": Health=" + hero.getHealth() + ", Mana=" + hero.getMana());
            } else {
                System.out.println(hero.getName() + ": DEFEATED");
            }
        }
    }

    private void announceWinner() {
        List<Hero> aliveHeroes = turnManager.getHeroes().stream()
                .filter(Hero::isAlive)
                .toList();
        if (aliveHeroes.size() == 1) {
            System.out.println(aliveHeroes.getFirst().getName() + " is the winner!");
        } else {
            System.out.println("No heroes survived. It's a draw.");
        }
    }
}

