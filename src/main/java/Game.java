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

    public String goPlay(char guess) {
        String newString ="";
        boolean stillDashes = true;
        String resultArray = initializeResultArray();
         while (stillDashes) {
             newString = playHangMan(guess, resultArray);
             //stillDashes = newString.matches("(^+-$)");
             stillDashes = newString.contains("-");

             System.out.println("NewString :"+newString+"stillDashes :"+stillDashes);
         }
        System.out.println("while loop ended: "+newString);
         return newString;

    }

    public String initializeResultArray () {
        String displayArray = "";
       randomString = getRandomAnswer();
       int length = randomString.length();
       for (int i=0; i < length ; i++){
           displayArray = displayArray + "-";
       }
       System.out.println(displayArray);
        return displayArray;

    }

    public String playHangMan(char guess, String resultArray ){

        char [] resultChars = resultArray.toCharArray();
        List<Boolean> checks = compareAnswerandGuess(guess);
        for (int i= 0; i < checks.size(); i++ ) {
            if (checks.get(i)) {
                resultChars[i] = guess;
            }
        }
        String newResult = new String(resultChars);
        System.out.println(newResult);
        return newResult;
    }

    public String getRandomAnswer (){
        Random randomWordGen = new Random();
        int word = randomWordGen.nextInt(1);
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
            case 5: wordString = "epicodus";
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
        System.out.println(wordString);
        return wordString;
    }

    public List<Boolean> compareAnswerandGuess(char guess){
        List<Boolean> isMatches = new ArrayList<Boolean>();
        System.out.println("RandomString "+randomString);
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


}
