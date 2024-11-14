

public class Main {
    public static void main(String[] args) {

        //one dimension
        int [] tal = {1,2,3,4,5,6};

        System.out.println(tal[0]);

        //two dimension
        int ROWS = 3;
        int COLS = 3;

        int [][] gameBoard = new int[ROWS][COLS];

        // Diagonal
        gameBoard[0][0] = 1;
        gameBoard[1][1] = 1;
        gameBoard[2][2] = 1;

        // Vertical
        gameBoard[0][2] = 1;
        gameBoard[1][2] = 1;
        gameBoard[2][2] = 1;


        // print array

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                gameBoard[row][col] = -1;
            }
        }


        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                System.out.print(" , " + gameBoard[row][col]);
            }
            System.out.println();
        }

    }
}