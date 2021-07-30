/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


public class QueenAttackCalculator
{

    private Board theBoard;

    public QueenAttackCalculator(Queen firstQueen, Queen secondQueen)
    {
        theBoard = new Board(8, 8);
    }

    public boolean canQueensAttackOneAnother()
    {
        boolean answer = false;

        return answer;
    }


}


class Queen extends Piece
{

    private Board aBoard;
    private int row, column;


    public Queen(int aRow, int aColumn)
    {

        aBoard = new Board(8, 8);
        this.row = aRow;
        this.column = aColumn;

        aBoard.getBoard()[aRow][aColumn] = new Queen()

    }

    @Override
    public void assignAttack()
    {
        super.assignAttack();
        this.assignRowAttack();
    }

    private void assignRowAttack()
    {
        for(int i=0; i<aBoard.getRows(); i++)
        {
            if (aBoard.getBoard()[row][i] == null || i != column)
            {
                aBoard.getBoard()[row][i] = new Covered();
            }
        }

        //TODO Assign columns for attack and test row and columns for attacks
    }
}

class Board
{
    private Piece[][] board;
    private int rows, columns;

    public Board(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        this.board = new Piece[rows][columns];

    }

    public Piece[][] getBoard()
    {
        return board;
    }

    public void setBoard(Piece[][] board)
    {
        this.board = board;
    }

    public int getRows()
    {
         return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }
}

class Piece
{
    public void assignAttack()
    {

    }


}

class Covered extends Piece
{

}

class Testers
{
    public static void main(String[] asdasdasd)
    {
        Queen aQueen = new Queen(4, 4);

        aQueen.assignAttack();
    }
}