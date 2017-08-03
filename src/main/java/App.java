import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Guest on 8/2/17.
 */
public class App {

  public static void main(String[] args) {

    String guessString;
    String resultString;
    String updatedResultString;
    boolean stillDashes;
    char guess;
    Game newGame = new Game();
    BufferedReader newBufferedReader = new BufferedReader(new InputStreamReader(System.in));

    resultString = newGame.initializeResultArray();
    System.out.println("Let's Play Epicodus Hangman ! ");

    try {
      stillDashes = true;
      while (stillDashes) {
        System.out.println("Guess the Word : " + resultString);
        System.out.println("Please enter your guess : ");

        guessString = newBufferedReader.readLine();
        guess = guessString.charAt(0);
        updatedResultString = newGame.playHangMan(guess, resultString);
        resultString = updatedResultString;
        stillDashes = updatedResultString.contains("-");
      }
      System.out.println("You got it : " + resultString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
