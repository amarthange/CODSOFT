import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;
        int totalRounds = 0;

        while (playAgain) {
            totalRounds++;
            if (playRound(sc)) {
                roundsWon++;
            }
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("You won " + roundsWon + " out of " + totalRounds + " rounds.");
        sc.close();
    }

    public static boolean playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100. You have 10 attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": ");
            int guess;
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); 
                continue;
            }

            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return true;
            }
        }

        System.out.println("Sorry, you have used all your attempts. The number was " + numberToGuess + ".");
        return false;
    }
}
