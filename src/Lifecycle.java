public class Lifecycle {
    Gameboard gameboard;
    Cell[][] nextGrid = new Cell[12][12];
    Cell[][] gameGrid = new Cell[12][12];
    int gridColumnNumber; // how many columns the grid has
    int gridRowNumber; // how many rows the grid has
    int gameColumnNumber; // how many columns the gameboard has
    int gameRowNumber; // how many rows the gameboard has

    public Lifecycle(Gameboard pGameboard){
        gameboard = pGameboard;
        gridRowNumber = gameboard.board_cells.length + 4;
        gridColumnNumber = gameboard.board_cells[0].length + 4;
        gameRowNumber = gameboard.board_cells.length;
        gameColumnNumber = gameboard.board_cells[0].length;

        nextGrid = new Cell[gridRowNumber][gridColumnNumber];
        gameGrid = new Cell[gridRowNumber][gridColumnNumber];

        cleanGrid();
        //copyCellsIntoGrid();
    }

    //Coping living cells from the gameboard into the gameGrid
    public void copyCellsIntoGrid(){
        for(int i = 0; i < gameRowNumber; i++){
            for(int j = 0; j < gameColumnNumber; j++){
                if(gameboard.board_cells[i][j].getAlive() == true){
                    gameGrid[i+2][j+2].setAlive(true);
                }
            }
        }
        //changeBounds(false);
    }

    //Coping the changed gird into the gameboard
    public void copyCellsIntoGameboard(){
        for(int i = 0; i < gameRowNumber; i++){
            for(int j = 0; j < gameColumnNumber; j++){
                if(nextGrid[i+2][j+2].getAlive() == true){
                    gameboard.board_cells[i][j].setAlive(true);
                    gameboard.board_cells[i][j].setBackground(gameboard.board_cells[i][j].getColor_alive());
                }else if(!(nextGrid[i+2][j+2].getAlive())){
                    gameboard.board_cells[i][j].setAlive(false);
                    gameboard.board_cells[i][j].setBackground(gameboard.board_cells[i][j].getColor_dead());
                }
            }
        }
    }

    //Creating nextGrid and gameGrid, which are bigger in lenght and height by 4, with dead cells
    public void cleanGrid(){
        for(int i = 0; i < gridRowNumber; i++){
            for(int j = 0; j < gridColumnNumber; j++){
                nextGrid[i][j] = new Cell(false, i, j);
                gameGrid[i][j] = new Cell(false, i, j);
            }
        }

    }

    //Putting living cells, which are "out of bounds", back into the bound of the gameboard
    //Or putting living cells, which are "in the bounds", out of the bound of the gameboard
    public void changeBounds(boolean pPutInBounds){
        int firstBound;
        int secondBound;

        //Deciding if the cells are put into the bound of the gameboard or out of the bound
        if(pPutInBounds == true){
            firstBound = 1;
            secondBound = 2;
        }else {
            firstBound = 2;
            secondBound = 1;
        }

        //Going through the row on the top and bottom
        for(int i = 2; i <= gridColumnNumber-firstBound; i++){
            if(gameGrid[firstBound][i].getAlive() == true){
                gameGrid[secondBound][i].setAlive(true);
            }
            if(gameGrid[gridRowNumber - firstBound][i].getAlive() == true){
                gameGrid[gridRowNumber - secondBound][i].setAlive(true);
            }
        }
        //Going through the column on the left and right
        for(int i = 2; i <= gridRowNumber-firstBound; i++){
            if(gameGrid[i][firstBound].getAlive() == true){
                gameGrid[i][secondBound].setAlive(true);
            }
            if(gameGrid[i][gridColumnNumber - firstBound].getAlive() == true){
                gameGrid[i][gridColumnNumber - secondBound].setAlive(true);
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

        changeBounds(true);

        copyCellsIntoGameboard();
        cleanGrid();

        return gameboard;
    }
}
