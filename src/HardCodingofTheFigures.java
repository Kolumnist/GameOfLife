public class HardCodingofTheFigures {

    private Cell[][] board_cells;

    public HardCodingofTheFigures(Cell[][] board_cells)
    {
        this.board_cells = board_cells.clone();
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
        board_cells[c.getX_pos()+2][c.getY_pos()+1].switchAlive();


    }



}
