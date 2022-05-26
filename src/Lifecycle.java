public class Lifecycle {
    Gameboard gameboard;
    Cell[][] nextGrid;
    Cell[][] gameGrid;
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

        cleanGrid();
        copyCellsIntoGrid();
    }

    //Coping living cells from the gameboard into the gameGrid
    public void copyCellsIntoGrid(){
        for(int i = 0; i < gameHeight; i++){
            for(int j = 0; j < gameLenght; j++){
                if(gameboard.board_cells[i][j].alive == true){
                    gameGrid[i+2][j+2].alive = true;
                }
            }
        }
    }

    //Coping the changed gird into the gameboard
    public void copyCellsIntoGameboard(){
        for(int i = 0; i < gameHeight; i++){
            for(int j = 0; j < gameLenght; j++){
                if(nextGrid[i+2][j+2].alive == true){
                    gameboard.board_cells[i][j].alive = true;
                }else{
                    gameboard.board_cells[i][j].alive = false;
                }
            }
        }
    }

    //Creating nextGrid and gameGrid, which are bigger in lenght and height by 4, with dead cells
    public void cleanGrid(){
        for(int i = 0; i <= gridHeight; i++){
            for(int j = 0; j <= gridLenght; j++){
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
            for(int j = yPosition-1; j <= yPosition+1 ; j++){
                if(!(i == xPosition && j == yPosition)){
                    if(gameGrid[i][j].alive == true){
                        neighbour++;
                    }
                }
            }
        }

        //Set the cell to be alive in the second grid
        if(gameGrid[xPosition][yPosition].alive == true && (neighbour == 1 || neighbour == 2)){
            nextGrid[xPosition][yPosition].alive = true;
        }else if (gameGrid[xPosition][yPosition].alive == false && neighbour == 2) {
            nextGrid[xPosition][yPosition].alive = true;
        }
    }


    public Gameboard nextCycle(){
        for(int i = 1; i < gameGrid.length-1; i++){
            for(int j = 1; j < gameGrid[0].length-1; j++){
                revive(gameGrid[i][j]);
            }
        }

        //Putting living cells, which are "out of bounds", back into the bound of the gameboard
        for(int i = 2; i < gridLenght; i++){
            if(gameGrid[1][i].alive == true){
                gameGrid[2][i].alive = true;
            }
            if(gameGrid[gridHeight-1][i].alive == true){
                gameGrid[gridHeight-2][i].alive = true;
            }
        }
        for(int i = 2; i < gridHeight; i++){
            if(gameGrid[i][1].alive == true){
                gameGrid[i][2].alive = true;
            }
            if(gameGrid[i][gridLenght-1].alive == true){
                gameGrid[i][gridLenght-2].alive = true;
            }
        }

        copyCellsIntoGameboard();
        cleanGrid();

        return gameboard;
    }
}
