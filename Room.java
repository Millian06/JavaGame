import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<Challenge> challenges;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.challenges = new ArrayList<>();
    }

    public void addChallenge(Challenge challenge) {
        challenges.add(challenge);
    }

    public boolean enter() {
        System.out.println("You entered " + name + ". " + description);
        for (Challenge challenge : challenges) {
            if (!challenge.attempt()) {
                System.out.println("You failed the challenge! Try again...");
                return false;
            }
        }
        System.out.println("You completed all the challenges in " + name + "!");
        return true;
    }
}
