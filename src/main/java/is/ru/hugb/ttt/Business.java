package is.ru.hugb.ttt;

public class Business 
{

  public static char[][] board;

  public Business() {

    board = new char[3][3];
    board = initializeBoard();
  }

  public static char[][] initializeBoard() {
    char board[][] = new char[3][3];

    int cellCounter = 49;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = (char) cellCounter;
        cellCounter++;
      }
    }
    return board;
  }

  public static char playerXorO(int player) {

    char XorO = 'F';

    if (player % 2 == 0) XorO = 'X';
    else XorO = 'O';

    return XorO;
  }

  public static int[] convertToXY(int input) {
    int x;
    int y;
    input = input - 1;
    y = input % 3;
    x = input / 3;

    int[] arr = {x, y};
    return arr;
  }

  public static boolean checkIfOccupied(char[][] board, int input) {

    int[] xy = convertToXY(input);
    int x = xy[0];
    int y = xy[1];
    if (board[x][y] == 'X' || board[x][y] == 'O') {
      return true;
    }
    return false;
  }

  public static boolean checkIfInRange(int input) {
    if (input > 9 || input < 1) {
      return false;
    }

    return true;
  }

  public static boolean isGameWon(char[][] board) {

    // Cross wins
    if (((board[0][0] == board[1][1]) && board[1][1] == board[2][2])
        || ((board[2][0] == board[1][1]) && board[1][1] == board[0][2])) {
      return true;
    }

    // Horizontal wins
    for (int i = 0; i < 3; i++) {
      if ((board[0][i] == board[1][i]) && board[1][i] == board[2][i]) {
        return true;
      }
    }

    // Vertical wins
    for (int i = 0; i < 3; i++) {
      if ((board[i][0] == board[i][1]) && board[i][1] == board[i][2]) {
        return true;
      }
    }

    return false;
  }

  public static void updateBoard(char XorO, int input) {

    int[] coordinates = convertToXY(input);
    //XorO = playerXorO(input);

    board[coordinates[0]][coordinates[1]] = XorO;
  }
}
