import java.util.Random;
import java.util.Scanner;


public class GuessANum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();

		char again = 'y';

		do {
			//int randomval = (int) (Math.random() * 100 + 1); does same thing as next line, only using Math class
			int randomval = 1 + generator.nextInt(100);
			System.out.println("I'm thinking of a number between 1 and 100 (inclusive). Take a guess: ");
			int guess = input.nextInt();

			int guesscount = 1;

			while (guess != randomval) {

				if (!(guess >= 1 && guess <= 100)) {
					System.out.println("Guess again, and make sure it's in the range of 1 to 100 (inclusive).");
					guess = input.nextInt();
					continue;
				}

				else {

					int distFromVal = Math.abs(guess - randomval);

					if (guess > randomval) {
						if (distFromVal < 10) {
							System.out.println("Too high - guess again: ");
							guess = input.nextInt();
						} else {
							System.out.println("Way too high - guess again: ");
							guess = input.nextInt();
						}

					} else {
						if (distFromVal < 10) {
							System.out.println("Too low - guess again: ");
							guess = input.nextInt();
						} else {
							System.out.println("Way too low - guess again: ");
							guess = input.nextInt();
						}
					}

					guesscount++;
				}
			}

			if (guesscount <= 3) {
				System.out.printf("Whoa, was quick! It only took you %d tries to guess the number %d.", guesscount,
						randomval);
			} else if (guesscount <= 6) {
				System.out.printf("That was fast! It took you %d tries to guess the number %d.", guesscount,
						randomval);
			} else if (guesscount <= 10) {
				System.out.printf("Nice - it took you %d tries to guess the number %d.", guesscount, randomval);
			} else if (guesscount <= 20) {
				System.out.printf("Not bad. It took you %d tries to guess the number %d.", guesscount, randomval);
			} else {
				System.out.printf("It took you %d tries to guess the number %d.", guesscount, randomval);
			}

			System.out.println(" Want to play again? Enter y or n: ");
			again = input.next().charAt(0);
			while (!(again == 'y' || again == 'n')) {
				System.out.println("Please enter a 'y' or 'n': ");
				again = input.next().charAt(0);
			}
		} while (again == 'y');

		System.out.println("Thanks for playing!");
		input.close();

	}

}
