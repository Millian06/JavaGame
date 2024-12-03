import java.util.Scanner;

public abstract class Challenge {
    protected String description;

    public Challenge(String description) {
        this.description = description;
    }

    public abstract boolean attempt();

    public static class Puzzle extends Challenge {
        private String question;
        private String answer;

        public Puzzle(String description, String question, String answer) {
            super(description);
            this.question = question;
            this.answer = answer;
        }

        @Override
        public boolean attempt() {
            System.out.println(description);
            System.out.println("Puzzle: " + question);
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Input Answer: ");
                String response = scanner.nextLine();
                return response.equalsIgnoreCase(answer);
            }
        }
    }

    public static class Enemy extends Challenge {
        private int health;
        @SuppressWarnings("unused")
        private int attackHit;

        public Enemy(String description, int health, int attackHit) {
            super(description);
            this.health = health;
            this.attackHit = attackHit;
        }

        @Override
        public boolean attempt(Player player) {
            Scanner scanner = new Scanner(System.in);
            java.util.Random random = new java.util.Random();
        
            while (health > 0 && player.isAlive()) {
                System.out.println(description + " Enemy Health: " + health);
                System.out.println("Type 'strike' to attack.");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("strike")) {
                    int damage = random.nextInt(10) + 5;
                    health -= damage;
                    System.out.println("You dealt " + damage + " damage!");
        
                    if (health > 0) {
                        int enemyDamage = attackHit;
                        player.takeDamage(enemyDamage);
                        if (!player.isAlive()) {
                            System.out.println("You were defeated by the enemy!");
                            return false;
                        }
                    }
                } else {
                    System.out.println("Invalid action!");
                }
            }
        
            System.out.println("You defeated the enemy!");
            return true;
        }

        @Override
        public boolean attempt() {
            throw new UnsupportedOperationException("Unimplemented method 'attempt'");
        }
        
                }
            }

            System.out.println("You defeated the enemy!") ;
            return true;
        
