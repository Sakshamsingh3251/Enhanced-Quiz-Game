import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    char correctAnswer;

    Question(String q, String a, String b, String c, String d, char ans) {
        question = q;
        optionA = a;
        optionB = b;
        optionC = c;
        optionD = d;
        correctAnswer = ans;
    }

    void displayQuestion() {
        System.out.println("\n" + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }
}

class QuizGame {

    int score = 0;
    boolean timeUp = false;

    void startTimer(int seconds) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\nTime is up!");
                timer.cancel();
            }
        }, seconds * 1000);
    }

    void play() {

        Scanner sc = new Scanner(System.in);

        Question[] questions = {
                new Question(
                        "Which language is used for Android Development?",
                        "Java", "Python", "C++", "HTML", 'A'),

                new Question(
                        "Which company developed Java?",
                        "Microsoft", "Sun Microsystems", "Google", "Apple", 'B'),

                new Question(
                        "Which keyword is used to create an object?",
                        "new", "class", "void", "this", 'A')
        };

        for (Question q : questions) {

            timeUp = false;
            startTimer(10); // 10 seconds timer

            q.displayQuestion();
            System.out.print("Enter your answer: ");

            String answer = sc.nextLine().toUpperCase();

            if (timeUp) {
                System.out.println("You answered too late!");
                continue;
            }

            if (answer.length() > 0 && answer.charAt(0) == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctAnswer);
            }
        }

        System.out.println("\nQuiz Finished!");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}

public class Main {
    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.play();
    }
}
