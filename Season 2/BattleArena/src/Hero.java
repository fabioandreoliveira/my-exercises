import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private String name;
    private int health;
    private int mana;
    private List<AbstractAbility> abilities;
    private int turnCooldown;


    public Hero(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.abilities = new ArrayList<>();
        this.turnCooldown = 0;


        public String getName() {
            return name;
        }

        public boolean isAlive() {
            return health > 0;
        }

        public void addAbility(Ability ability) {
            abilities.add(ability);
        }

        // Get the list of abilities
        public List<Ability> getAbilities() {
            return abilities;
        }

        public void takeDamage(int amount) {
            if (amount < 0) {
                System.out.println(name + " cannot take negative damage.");
                return;
            }

            health -= amount;
            if (health < 0) {
                health = 0;
            }

            System.out.println(name + " takes " + amount + " damage! Current health: " + health);

            if (!isAlive()) {
                System.out.println(name + " has been defeated!");

            }
        }


        public void normalAttack(Hero target) {
            int damage = 50;
            System.out.println(name + " uses a normal attack!");
            target.takeDamage(damage);
        }


        public void endTurn() {
            if (turnCooldown > 0) {
                turnCooldown--;
            }
            System.out.println(name + " ends their turn. Cooldown remaining: " + turnCooldown);
        }


        public abstract void useAbility(int index, Hero target);


        public int getHealth() {
            return health;
        }

        public int getMana() {
            return mana;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        public void setHealth(int health) {
            this.health = health;
        }
    }
