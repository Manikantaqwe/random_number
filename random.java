import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            int score = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number!");
                    score = maxAttempts - attempts + 1; // Score based on remaining attempts
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your score for this round: " + score);
            totalScore += score;

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Your total score across all rounds: " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
