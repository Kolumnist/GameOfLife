/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
public class HardCodingofTheFigures {

    private Cell[][] board_cells;

    public HardCodingofTheFigures(Cell[][] board_cells)
    {
        this.board_cells = board_cells.clone();
    }

    public void oktagon(Cell c)
    {
        try{ board_cells[c.getX_pos()+4][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()+4][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()-1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+4].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()+2][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+4].switchAlive();}catch(Exception ignored){}
    }

    public void pentadecathlonVertical(Cell c)
    {
        try{ board_cells[c.getX_pos()+5][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+5][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+5][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+4][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()-6][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-6][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-6][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-5][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-4][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
    }
    public void pentadecathlonHorizontal(Cell c)
    {
        try{ board_cells[c.getX_pos()][c.getY_pos()+5].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+5].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+5].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+4].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}

        try{ board_cells[c.getX_pos()][c.getY_pos()-6].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-6].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-6].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-5].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-4].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
    }

    public void gliderDown(Cell c)
    {
        try{ board_cells[c.getX_pos() - 1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos() + 1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() + 1][c.getY_pos() + 1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() + 1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() + 1][c.getY_pos() - 1].switchAlive();}catch(Exception ignored){}
    }
    public void gliderUp(Cell c)
    {
        try{ board_cells[c.getX_pos() + 1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos() - 1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() - 1][c.getY_pos() - 1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() - 1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos() - 1][c.getY_pos() + 1].switchAlive();}catch(Exception ignored){}
    }
    public void gliderRight(Cell c)
    {
        try{ board_cells[c.getX_pos()][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
    }
    public void gliderLeft(Cell c)
    {
        try{ board_cells[c.getX_pos()][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
    }

    public void lightSpaceshipDown(Cell c)
    {
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{  board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
    }
    public void lightSpaceshipUp(Cell c)
    {
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
    }

    public void middleSpaceship(Cell c)
    {
        try{ board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
    }

    public void heavySpaceship(Cell c){
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
    }
}
