import java.util.Scanner;


class Puzzle extends Challenge {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Answer: ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase(answer);
    }
}
