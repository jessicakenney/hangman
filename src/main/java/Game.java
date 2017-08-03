import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Guest on 8/2/17.
 */
public class Game {

    private String randomString;
    private char guess;

    public Game(){
        this.randomString = randomString;
        this.guess = guess;
    }

    public String initializeResultArray () {
        String resultString = "";

       randomString = getRandomString();
       int length = randomString.length();
       for (int i=0; i < length ; i++){
           resultString = resultString + "-";
       }
        return resultString;
    }

    public String playHangMan(char guess, String resultArray ){

        char [] resultChars = resultArray.toCharArray();
        List<Boolean> isMatches = isMatch(guess);
        for (int i= 0; i < isMatches.size(); i++ ) {
            if (isMatches.get(i)) {
                resultChars[i] = guess;
            }
        }
        String newResult = new String(resultChars);
        return newResult;
    }

    public List<Boolean> isMatch(char guess){
      List<Boolean> isMatches = new ArrayList<>();
      char[] answerChars = randomString.toCharArray();
      for ( char letter : answerChars) {
        Character wrapperLetter = letter;
        if (wrapperLetter.equals(guess)) {
          isMatches.add(true);
        } else {
          isMatches.add(false);
        }
      }
      return isMatches;
    }

    public String getRandomString (){
        Random randomWordGen = new Random();
        int word = randomWordGen.nextInt(10);
        String wordString = "";
        switch (word) {
            case 0: wordString = "perry";
                    break;
            case 1: wordString = "tim";
                    break;
            case 2: wordString = "pairprogramming";
                    break;
            case 3: wordString = "standingdesk";
                    break;
            case 4: wordString = "queue";
                    break;
            case 5: wordString = "youaretheproject";
                    break;
            case 6: wordString = "foodtruck";
                    break;
            case 7: wordString = "atom";
                    break;
            case 8: wordString = "intellij";
                    break;
            case 9 : wordString = "softwrap";
                    break;
        }
        return wordString;
    }
}
