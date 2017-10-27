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
          return ui.boardToString(board);
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
		  business.updateBoard(player, cell);
		  playerCounter++;
		  return ui.boardToString(board);
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

  private static String boardToString(char[][] board) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        builder.append(board[i][j]);
      }
    }
    return builder.toString();
  }

  static int getHerokuPort() {
    ProcessBuilder psb = new ProcessBuilder();
    if (psb.environment().get("PORT") != null) {
      return Integer.parseInt(psb.environment().get("PORT"));
    }
    return 4567;
  }
}
