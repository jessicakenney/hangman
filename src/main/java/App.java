import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Guest on 8/2/17.
 */
public class App {

  public static void main(String[] args) {

    boolean stillDashes;

    //System.out.println("Let's Play Epicodus Hangman ! ");


    get("/", (request,response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game newGame = new Game();
      String initString = newGame.initializeResultArray();
      request.session().attribute("game",newGame);
      request.session().attribute("initString",initString);
      return new ModelAndView(model, "game.hbs");
    }, new HandlebarsTemplateEngine());
    //would it still work if I just added the initString/and game to the model?

    post("/game", (request,response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      String guessString = request.queryParams("guessString");
      char guess = guessString.charAt(0);
      Game game = request.session().attribute("game");
      String updatedResultString = game.playHangMan(guess, request.session().attribute("initString"));
      model.put("updatedResultString",updatedResultString);
      request.session().attribute("initString",updatedResultString);
      return new ModelAndView(model, "game.hbs");
    }, new HandlebarsTemplateEngine());

//    try {
//      stillDashes = true;
//      while (stillDashes) {
//        System.out.println("Guess the Word : " + resultString);
//        System.out.println("Please enter your guess : ");
//
//        guessString = newBufferedReader.readLine();
//        guess = guessString.charAt(0);
//        updatedResultString = newGame.playHangMan(guess, resultString);
//        resultString = updatedResultString;
//        stillDashes = updatedResultString.contains("-");
//      }
//      System.out.println("You got it : " + resultString);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

  }
}
