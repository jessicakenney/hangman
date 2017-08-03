import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jessicakenney
 * Test Plan: set random generator to '1' to always select "perry" to verify below tests
 */
public class GameTest {

    @Test
    public void newGame_instantiatesCorrectly() throws Exception{
      Game testGame = new Game();
      assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void getRandomAnswer_stringExists_Boolean() throws Exception{
        Game testGame = new Game();
        assertEquals(true, testGame.getRandomString() instanceof String);
    }
//    @Test
//    public void getRandomAnswer_randomStringCheck_String() throws Exception{
//        Game testGame = new Game();
//        List<String> expectedOutput = new ArrayList<String>();
//        expectedOutput.add("perry");
//        expectedOutput.add("tim");
//        String myRandom = testGame.getRandomString();
//        assertEquals(true, expectedOutput.contains(myRandom));
//    }
    @Test
    public void initializeResultArray_resultStringCreated_String() {
        Game testGame = new Game();
        assertEquals("-----", testGame.initializeResultArray());
    }

    @Test
    public void isMatch_checkSingleLetter_boolean() throws Exception{
        Game testGame = new Game();
        testGame.initializeResultArray();
        List<Boolean> expectedOutput = new ArrayList<Boolean>();
        expectedOutput.add(false);
        expectedOutput.add(false);
        expectedOutput.add(true);
        expectedOutput.add(true);
        expectedOutput.add(false);
        assertEquals(expectedOutput, testGame.isMatch('r'));
    }

    @Test
    public void playHangMan_singleLetterChecks_String() throws Exception{
        Game testGame = new Game();
        testGame.initializeResultArray();
        assertEquals("p----", testGame.playHangMan('p',"-----" ));
    }

    @Test
    public void playHangMan_guessAllLettersInPerry_String() throws Exception{
        Game testGame = new Game();
        testGame.initializeResultArray();
        assertEquals("p----", testGame.playHangMan('p',"-----"));
        assertEquals("p-rr-", testGame.playHangMan('r',"p----"));
        assertEquals("perr-", testGame.playHangMan('e',"p-rr-"));
        assertEquals("perry", testGame.playHangMan('y',"perr-"));
    }
}