import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctOption; // index (0-based)

    Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    boolean ask(Scanner sc) {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter your choice (1-" + options.length + "): ");
        int answer = sc.nextInt();
        return answer - 1 == correctOption;
    }
}

public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Question[] questions = {
            new Question("What is the capital of India?",
                         new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 0),
            new Question("Which language is used for Android development?",
                         new String[]{"Python", "Swift", "Java", "PHP"}, 2),
            new Question("Who is the founder of Microsoft?",
                         new String[]{"Steve Jobs", "Mark Zuckerberg", "Bill Gates", "Elon Musk"}, 2)
        };

        int score = 0;
        System.out.println("Welcome to the Java Quiz Game!");

        for (Question q : questions) {
            if (q.ask(sc)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect.");
            }
        }

        System.out.println("\nYour final score: " + score + "/" + questions.length);
        sc.close();
    }
}
