package is.ru.hugb.ttt;

import static spark.Spark.*;

public class WebUI {

  private static Business business;
  private static char[][] board;
  private static int playerCounter;

  public WebUI() {
    business = new Business();
    board = business.board;
    playerCounter = 0;
  }

  public static void main(String[] args) {
    port(getHerokuPort());
    staticFileLocation("/public");
    WebUI ui = new WebUI();

    get(
        "/getTable",
        (request, response) -> {
          return business.boardToString(board);
        });

    get(
        "/player",
        (request, response) -> {
          return business.playerXorO(playerCounter);
        });

    post(
        "/game",
        (req, res) -> {
          int cell = Integer.parseInt(req.queryParams("xIn"));
          char player = business.playerXorO(playerCounter);

		  if(business.checkIfOccupied(board, cell)){
			  throw new Exception();
		  }
		  
		  business.updateBoard(player, cell);
		  playerCounter++;
		  if(business.isGameWon(business.board)){
			  return business.boardToString(board) + "Game over";
		  }
		  
		  
		  return business.boardToString(board);
        });

    get(
        "/game/:input",
        (req, res) -> {
          String cell = req.params(":input");
          return cell;
        });
  }

  private static char[][] printBoard() {
    return board;
  }

  static int getHerokuPort() {
    ProcessBuilder psb = new ProcessBuilder();
    if (psb.environment().get("PORT") != null) {
      return Integer.parseInt(psb.environment().get("PORT"));
    }
    return 4567;
  }
}
