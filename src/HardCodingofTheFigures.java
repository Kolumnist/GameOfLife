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

    public void pentadecathlon(Cell c)
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

    public void glider(Cell c)
    {
        board_cells[c.getX_pos() - 1][c.getY_pos() + 1].switchAlive();
        board_cells[c.getX_pos()][c.getY_pos() + 1].switchAlive();
        board_cells[c.getX_pos() + 1][c.getY_pos() + 1].switchAlive();
        board_cells[c.getX_pos() + 1][c.getY_pos()].switchAlive();
        board_cells[c.getX_pos() + 1][c.getY_pos() - 1].switchAlive();
    }

    public void lightSpaceship(Cell c)
    {
        board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();
        board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()-1].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()-1][c.getY_pos()-1].switchAlive();
    }

    public void middleSpaceship(Cell c)
    {
        board_cells[c.getX_pos()+2][c.getY_pos()].switchAlive();
        board_cells[c.getX_pos()+1][c.getY_pos()+2].switchAlive();
        board_cells[c.getX_pos()][c.getY_pos()+3].switchAlive();
        board_cells[c.getX_pos()-1][c.getY_pos()+3].switchAlive();
        board_cells[c.getX_pos()-2][c.getY_pos()+3].switchAlive();
        board_cells[c.getX_pos()-2][c.getY_pos()+2].switchAlive();
        board_cells[c.getX_pos()-2][c.getY_pos()+1].switchAlive();
        board_cells[c.getX_pos()-2][c.getY_pos()].switchAlive();
        board_cells[c.getX_pos()-2][c.getY_pos()-1].switchAlive();
        board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();
    }

    public void heavySpaceship(Cell c){
        board_cells[c.getX_pos()-2][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()-1][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()+1][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()-2].switchAlive();
        board_cells[c.getX_pos()+3][c.getY_pos()-2].switchAlive();

        board_cells[c.getX_pos()-3][c.getY_pos()-1].switchAlive();
        board_cells[c.getX_pos()+3][c.getY_pos()-1].switchAlive();

        board_cells[c.getX_pos()+3][c.getY_pos()].switchAlive();

        board_cells[c.getX_pos()-3][c.getY_pos()+1].switchAlive();
        board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();

        board_cells[c.getX_pos()-1][c.getY_pos()+2].switchAlive();
        board_cells[c.getX_pos()][c.getY_pos()+2].switchAlive();
    }
}
