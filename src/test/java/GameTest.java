import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/2/17.
 */
public class GameTest {

    @Test
    public void newGame_instantiatesCorrectly() throws Exception{
      Game testGame = new Game();
      assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void getRandomAnswer_DoubleLetterAnswer_String() throws Exception{
        Game testGame = new Game();
        assertEquals(true, testGame.getRandomAnswer() instanceof String);
        //assertEquals("ata",testGame.getRandomAnswer());
    }

//    @Test
//    public void compareAnswerandGuess_checkSingleLetter_boolean() throws Exception{
//        Game testGame = new Game();
//        List<Boolean> expectedOutput = new ArrayList<Boolean>();
//        expectedOutput.add(false);
//        expectedOutput.add(false);
//        expectedOutput.add(true);
//        expectedOutput.add(true);
//        expectedOutput.add(false);
//        assertEquals(expectedOutput, testGame.compareAnswerandGuess('r'));
//        //assertEquals(expectedOutput, testGame.playHangMan('a').checks());
//    }

//    @Test
//    public void playHangMan_singleLetterChecks_String() throws Exception{
//        Game testGame = new Game();
//        assertEquals("p----", testGame.playHangMan('p',));
//    }

    @Test



    public void playHangMan_guessAllLettersInPerry_String() throws Exception{
        Game testGame = new Game();
        testGame.goPlay('p');
        assertEquals("p----", testGame.playHangMan('p',"-----"));
        assertEquals("p-rr-", testGame.playHangMan('r',"p----"));
        assertEquals("perr-", testGame.playHangMan('e',"p-rr-"));
        assertEquals("perry", testGame.playHangMan('y',"perr-"));
    }
    @Test
    public void goPlay_WhileLoopTurnsOffGame_String() throws Exception{
        Game testGame = new Game();
    }

}