public abstract class AbstractAbility implements Ability{
        private String name;
        private int manaCost;
        private int power;
        private int cooldown;
        protected int currentCooldown;


        public AbstractAbility(String name, int manaCost, int power) {
            this.name = name;
            this.manaCost = manaCost;
            this.power = power;
            this.cooldown = 3;
            this.currentCooldown = 0;


            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getManaCost() {
                return manaCost;
            }

            @Override
            public int getPower() {
                return power;
            }

            @Override
            public int getCurrentCooldown() {
                return currentCooldown;
            }

            @Override
            public int getCooldown() {
                return cooldown;
            }

            @Override
            public abstract void startCooldown();

            @Override
            public abstract void reduceCooldown();

            @Override
            public abstract void activate(Hero user, Hero target);
        }
    }
