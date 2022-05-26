import java.awt.*;

public class Lifecycle {
    Gameboard gameboard;
    Cell[][] nextGrid = new Cell[12][12];
    Cell[][] gameGrid = new Cell[12][12];
    int gridLenght; // how many colums the grid has
    int gridHeight; // how many rows the grid has
    int gameLenght; // how many colums the gameboard has
    int gameHeight; // how many rows the gameboard has

    public Lifecycle(Gameboard pGameboard){
        gameboard = pGameboard;
        gridHeight = gameboard.board_cells.length + 4;
        gridLenght = gameboard.board_cells[0].length + 4;
        gameHeight = gameboard.board_cells.length;
        gameLenght = gameboard.board_cells[0].length;

        nextGrid = new Cell[gridHeight][gridLenght];
        gameGrid = new Cell[gridHeight][gridLenght];

        cleanGrid();
        copyCellsIntoGrid();
    }

    //Coping living cells from the gameboard into the gameGrid
    public void copyCellsIntoGrid(){
        for(int i = 0; i < gameHeight; i++){
            for(int j = 0; j < gameLenght; j++){
                if(gameboard.board_cells[i][j].getAlive() == true){
                    gameGrid[i+2][j+2].setAlive(true);
                }
            }
        }
    }

    //Coping the changed gird into the gameboard
    public void copyCellsIntoGameboard(){
        for(int i = 0; i < gameHeight; i++){
            for(int j = 0; j < gameLenght; j++){
                if(nextGrid[i+2][j+2].getAlive() == true){
                    gameboard.board_cells[i][j].setAlive(true);
                    gameboard.board_cells[i][j].setColor_dead(Color.BLUE);
                }else if(!(nextGrid[i+2][j+2].getAlive())){
                    gameboard.board_cells[i][j].setAlive(false);
                    gameboard.board_cells[i][j].setColor_dead(Color.CYAN);
                }
            }
        }
    }

    //Creating nextGrid and gameGrid, which are bigger in lenght and height by 4, with dead cells
    public void cleanGrid(){
        for(int i = 0; i < gridHeight; i++){
            for(int j = 0; j < gridLenght; j++){
                nextGrid[i][j] = new Cell(false, i, j);
                gameGrid[i][j] = new Cell(false, i, j);
            }
        }

    }

    //Counting how many neighbours one cell has and setting its living status
    public void revive(Cell pCell){
        int neighbour = -1;
        int xPosition = pCell.getX_pos(); // x = row
        int yPosition = pCell.getY_pos(); // y = column

        //Counting the number of alive neighbours a living cell has
        for(int i = xPosition-1; i <= xPosition+1; i++){
            for(int j = yPosition-1; j <= yPosition+1; j++){
                if(!(xPosition == i && yPosition ==j) && gameGrid[i][j].getAlive() == true){
                    neighbour++;
                    System.out.println("HEY ICH FUNKTIONIER AUCH!");
                }
            }
        }

        //Wenn eine lebende Zelle 2oder3 andere Lebende Zelle neben sich hat lebt sie
        //Wenn eine tote Zelle 3 andere lebende Zellen neben sich hat lebt sie

        //Set the cell to be alive in the second grid
        if(gameGrid[xPosition][yPosition].getAlive() == true && (neighbour == 1 || neighbour == 2)){
            nextGrid[xPosition][yPosition].setAlive(true);
        }else if (gameGrid[xPosition][yPosition].getAlive() == false && neighbour == 2) {
            nextGrid[xPosition][yPosition].setAlive(true);
        }
    }


    public Gameboard nextCycle(){

        copyCellsIntoGrid();
        for(int i = 2; i < gameGrid.length-1; i++){
            for(int j = 2; j < gameGrid[0].length-1; j++){
                revive(gameGrid[i][j]);
            }
        }

        //Putting living cells, which are "out of bounds", back into the bound of the gameboard
        for(int i = 2; i < gridLenght; i++){
            if(gameGrid[1][i].getAlive() == true){
                gameGrid[2][i].setAlive(true);
            }
            if(gameGrid[gridHeight-1][i].getAlive() == true){
                gameGrid[gridHeight-2][i].setAlive(true);
            }
        }
        for(int i = 2; i < gridHeight; i++){
            if(gameGrid[i][1].getAlive() == true){
                gameGrid[i][2].setAlive(true);
            }
            if(gameGrid[i][gridLenght-1].getAlive() == true){
                gameGrid[i][gridLenght-2].setAlive(true);
            }
        }

        copyCellsIntoGameboard();
        cleanGrid();

        return gameboard;
    }
}
