package is.ru.hugb.ttt;

import static spark.Spark.*;
import java.net.URLDecoder;

public class WebUI{
	
	private static Business business;
	private static char[][] board;
	private static int playerCounter;
	
	public WebUI(){
		business = new Business();
		board = business.board;
		playerCounter = 0;
	}
	
	public static void main(String[] args){
		staticFileLocation("/public");
		WebUI ui = new WebUI();
		
		get("/start", (request, response) -> {
			return ui.boardToString(board);
		});
	}
	
	private static char[][] printBoard(){
		return board;
	}
	
	private static String boardToString(char[][] board){
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				builder.append(board[i][j]);
			}
		}
		return builder.toString();
	}
}