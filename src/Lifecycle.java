/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
public class Lifecycle {
    private Gameboard gameboard;
    private Cell[][] nextGrid = new Cell[12][12];
    private Cell[][] gameGrid = new Cell[12][12];
    private int gridColumnNumber; // how many columns the grid has
    private int gridRowNumber; // how many rows the grid has
    private int gameColumnNumber; // how many columns the gameboard has
    private int gameRowNumber; // how many rows the gameboard has

    public Lifecycle(Gameboard pGameboard) {
        gameboard = pGameboard;
        gridRowNumber = gameboard.board_cells.length + 4;
        gridColumnNumber = gameboard.board_cells[0].length + 4;
        gameRowNumber = gameboard.board_cells.length;
        gameColumnNumber = gameboard.board_cells[0].length;

        nextGrid = new Cell[gridRowNumber][gridColumnNumber];
        gameGrid = new Cell[gridRowNumber][gridColumnNumber];

        cleanGrid();
        copyCellsIntoGrid();
    }

    //Coping living cells from the gameboard into the gameGrid
    private void copyCellsIntoGrid() {
        for (int i = 0; i < gameRowNumber; i++) {
            for (int j = 0; j < gameColumnNumber; j++) {
                if (gameboard.board_cells[i][j].getAlive() == true) {
                    gameGrid[i + 2][j + 2].setAlive(true);
                }
            }
        }
    }

    //Coping the changed gird into the gameboard
    private void copyCellsIntoGameboard() {
        for (int i = 0; i < gameRowNumber; i++) {
            for (int j = 0; j < gameColumnNumber; j++) {
                if (nextGrid[i + 2][j + 2].getAlive() == true) {
                    gameboard.board_cells[i][j].setAlive(true);
                    gameboard.board_cells[i][j].setBackground(gameboard.board_cells[i][j].getColor_alive());
                } else if (!(nextGrid[i + 2][j + 2].getAlive())) {
                    gameboard.board_cells[i][j].setAlive(false);
                    gameboard.board_cells[i][j].setBackground(gameboard.board_cells[i][j].getColor_dead());
                }
            }
        }
    }

    //Creating nextGrid and gameGrid, which are bigger in lenght and height by 4, with dead cells
    private void cleanGrid() {
        for (int i = 0; i < gridRowNumber; i++) {
            for (int j = 0; j < gridColumnNumber; j++) {
                nextGrid[i][j] = new Cell(false, i, j);
                gameGrid[i][j] = new Cell(false, i, j);
            }
        }

    }

    //Counting how many neighbours one cell has and setting its living status
    private void revive(Cell pCell) {
        int neighbour = -1;
        int xPosition = pCell.getX_pos(); // x = row
        int yPosition = pCell.getY_pos(); // y = column

        //Counting the number of alive neighbours a living cell has
        for (int i = xPosition - 1; i <= xPosition + 1; i++) {
            for (int j = yPosition - 1; j <= yPosition + 1; j++) {
                if (!(xPosition == i && yPosition == j) && gameGrid[i][j].getAlive() == true) {
                    neighbour++;
                    //System.out.println("HEY ICH FUNKTIONIER AUCH!");
                }
            }
        }

        //Set the cell to be alive in the second grid
        if (gameGrid[xPosition][yPosition].getAlive() == true && (neighbour == 1 || neighbour == 2)) {
            nextGrid[xPosition][yPosition].setAlive(true);
        } else if (gameGrid[xPosition][yPosition].getAlive() == false && neighbour == 2) {
            nextGrid[xPosition][yPosition].setAlive(true);
        }
    }

    public void nextCycle() {
        copyCellsIntoGrid();
        //region Putting living cells, which are at the bounds of the gameboard, out of the bound of the gameboard
        for (int i = 2; i < gridColumnNumber; i++) {
            if (gameGrid[2][i].getAlive() == true) {
                gameGrid[gridRowNumber - 2][i].setAlive(true);
            }
            if (gameGrid[gridRowNumber - 3][i].getAlive() == true) {
                gameGrid[1][i].setAlive(true);
            }
        }
        for (int i = 2; i < gridRowNumber; i++) {
            if (gameGrid[i][2].getAlive() == true) {
                gameGrid[i][gridColumnNumber - 2].setAlive(true);
            }
            if (gameGrid[i][gridColumnNumber - 3].getAlive() == true) {
                gameGrid[i][1].setAlive(true);
            }
        }
        //endregion

        for (int i = 2; i < gameGrid.length - 1; i++) {
            for (int j = 2; j < gameGrid[0].length - 1; j++) {
                revive(gameGrid[i][j]);
            }
        }

        //region Putting living cells, which are "out of bounds", back into the bound of the gameboard
        for (int i = 2; i < gridColumnNumber; i++) {
            if (nextGrid[1][i].getAlive() == true) {
                nextGrid[gridRowNumber - 2][i].setAlive(true);
            }
            if (nextGrid[gridRowNumber - 1][i].getAlive() == true) {
                nextGrid[2][i].setAlive(true);
            }
        }
        for (int i = 2; i < gridRowNumber; i++) {
            if (nextGrid[i][1].getAlive() == true) {
                nextGrid[i][2].setAlive(true);
            }
            if (nextGrid[i][gridColumnNumber - 1].getAlive() == true) {
                nextGrid[i][gridColumnNumber - 2].setAlive(true);
            }
        }
        //endregion

        copyCellsIntoGameboard();
        cleanGrid();
    }

    //region Just a toString for debuging purpose
    public void toString(Cell[][] pCell) {
        for (Cell[] one : pCell) {
            for (Cell two : one) {
                if (two.getAlive() == true) {
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }
    }
    //endregion
}
