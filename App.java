import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Room> rooms = new ArrayList<>();
    private static int currentRoomIndex = 0;

    public static void main(String[] args) {
        setupGame();
        System.out.println("Welcome to the Aberdeen Adventures!!!");
        Scanner scanner = new Scanner(System.in);

        while (currentRoomIndex < rooms.size()) {
            Room currentRoom = rooms.get(currentRoomIndex);
            if (currentRoom.enter()) {
                currentRoomIndex++;
            } else {
                System.out.println("Do you want to retry the current room? (yes/no)");
                String retry = scanner.nextLine();
                if (!retry.equalsIgnoreCase("yes")) {
                    System.out.println("Game over!");
                    break;
                }
            }
        }

        if (currentRoomIndex == rooms.size()) {
            System.out.println("Congratulations! You completed the Aberdeen adventures!");
        }
    }

    private static void setupGame() {
        // Room 1: Central Library
        Room library = new Room("The Central Library", "filled with books and a mysterious aura.");
        library.addChallenge(new Puzzle(
            "Solve this puzzle to proceed.",
            "What is 10 + 15?",
            "25"
        ));
        rooms.add(library);

        // Room 2: Union Terrace Gardens
        Room garden = new Room("The Union Terrace Gardens", "Bright and filled with flowers, but a dangerous flower monster lurks here.");
        garden.addChallenge(new Enemy(
            "An angry flower monster attacks you!",
            50,
            10
        ));
        rooms.add(garden);

        // Room 3: Greggs
        Room greggs = new Room("Greggs", "The smell of fresh sausage rolls is inviting, but a final challenge awaits.");
        greggs.addChallenge(new Puzzle(
            "Answer this riddle to win your sausage rolls.",
            "I never was and always to be. No one ever saw me, nor ever will. And yet, I am the confidence of all who live and breathe on this terrestrial ball. What am I?",
            "Tomorrow"
        ));
        greggs.addChallenge(new Enemy(
            "A hungry zombie chef is guarding the sausage rolls!",
            70,
            15
        ));
        rooms.add(greggs);
    }
}
