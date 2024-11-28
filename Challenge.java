import java.util.Scanner;

public abstract Challenge{
protected String description;
public Challenge(String description){
    this.description = description;

}

public abstract boolean attempt{
    class Puzzle extends Challenge{
        private String question;
        private String answer;

        public Puzzle(String description, String question, String answer){
            super(description);
            this.question = question;
            this.answer = answer;


        }

        @Override
        public boolean attempt() {
            System.out.println(description);
            System.out.println("Puzzle" + question);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input Answer: ");
            String response = scanner.nextLine();
            return response.equalIgnoreCase(answer);

        }
    }
class Enemy extends Challenge{
    private int health;
    private int attackHit;

    public Enemy(String description, int health, int attackHit){
        super(description);
        this.health = health;
        this.attackHit = attackHit;
    }

    @Override

    public boolean attempt{
        Scanner scanner = new Scanner(System.in);
        while (health > 0){
            System.out.println(description + "Player Health: " + health);
            System.out.println("Type attack to strike");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("strike")){
                int damage = newRandom().nextInt(10) + 5;

                health -= damage;
                System.out.println("You received " + damage + "damage!!!");
            }else{
                System.out.println("Invalid Action!");

            }
            }
                System.out.println("You defeated the enemy!");
                return true;
    }       
}
}

}