import java.util.Scanner;
import java.util.Random;


class Enemy extends Challenge {
    private int health;
    private int attackHit;

    public Enemy(String description, int health, int attackHit) {
        super(description);
        this.health = health;
        this.attackHit = attackHit;
    }

    @Override
    public boolean attempt() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (health > 0) {
            System.out.println(description + " Enemy Health: " + health);
            System.out.println("Type 'attack' to strike");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("attack")) {
                int damage = random.nextInt(10) + 5;
                health -= damage;
                System.out.println("You dealt " + damage + " damage!!!");

                if (health > 0) {
                    int enemyDamage = random.nextInt(attackHit);
                    System.out.println("Enemy strikes back for " + enemyDamage + " damage!");
                }
            } else {
                System.out.println("Invalid Action!");
            }
        }

        System.out.println("You defeated the enemy!");
        return true;
    }
}
