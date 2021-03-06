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

    /*This Class mainly handles the positions of the cells that should be alive for the figures
    * Our Idea was to make it the Hardcoding way which is why I don't have to say much more to it!
    */

    //region WARNING this code may disturb you and your eyes will most definitely bleed!
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


    public void middleSpaceshipDown(Cell c)
    {
        try{ board_cells[c.getX_pos()-2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
    }
    public void middleSpaceshipUp(Cell c)
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

    public void heavySpaceshipRight(Cell c)
    {
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

    public void heavySpaceshipLeft(Cell c)
    {
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
    }

    public void heavySpaceshipDown(Cell c)
    {
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
    }

    public void heavySpaceshipUp(Cell c)
    {
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+2][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()+1][c.getY_pos()-3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-3][c.getY_pos()].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()+3].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()-2][c.getY_pos()+1].switchAlive();}catch(Exception ignored){}
        try{ board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();}catch(Exception ignored){}
    }
    //endregion
}
