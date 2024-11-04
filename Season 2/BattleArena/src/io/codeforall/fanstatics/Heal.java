package io.codeforall.fanstatics;

public class Heal extends AbstractAbility {
    public Heal() {
        super("Heal", 20);
    }

    @Override
    public void use(Hero target) {
        target.heal(power);
        System.out.println(target.getName() + " is healed for " + power + " points.");
    }
}

// Similarly, create Fireball, ShieldBlock, SneakAttack with different implementations
