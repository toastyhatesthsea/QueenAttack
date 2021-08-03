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
    private Queen firstQueen, secondQueen;
    private Board queenOneBoard, queenTwoBoard;

    public QueenAttackCalculator(Queen aFirstQueen, Queen aSecondQueen)
    {
        //theBoard = new Board(8, 8);
        this.firstQueen = aFirstQueen;
        this.secondQueen = aSecondQueen;

        queenOneBoard = new Board(8, 8);
        queenTwoBoard = new Board(8, 8);

        //theBoard.getBoard()[firstQueen.getRow()][firstQueen.getColumn()] = firstQueen;
        //theBoard.getBoard()[secondQueen.getRow()][secondQueen.getColumn()] = secondQueen;

        queenOneBoard.setPiece(firstQueen, firstQueen.getRow(), firstQueen.getColumn());
        queenTwoBoard.setPiece(secondQueen, secondQueen.getRow(), secondQueen.getColumn());
    }

    public boolean canQueensAttackOneAnother()
    {
        boolean answer = false;

        return answer;
    }

    public boolean assignAttackforPieces()
    {
        firstQueen.assignAttack(queenOneBoard);
        secondQueen.assignAttack(queenTwoBoard);

        return true;
    }

    public boolean assignAttackforDiagnols()
    {
        firstQueen.upperRightDiagnols(queenOneBoard);
        firstQueen.upperLeftDiagnols(queenOneBoard);
        secondQueen.upperLeftDiagnols(queenTwoBoard);
        secondQueen.upperRightDiagnols(queenTwoBoard);

        return true;
    }

}

class Queen extends Piece
{

    private int row, column;
    //private Board theBoard;

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public Queen(int aRow, int aColumn)
    {
        //this.theBoard = new Board(8, 8);
        this.row = aRow;
        this.column = aColumn;
        //this.theBoard.setPiece(this, aRow, aColumn);
    }

    @Override
    public void assignAttack(Board theBoard)
    {
        assignRowAttack(theBoard);
        assignColumnAttack(theBoard);
    }

    private void assignRowAttack(Board theBoard)
    {

        for (int i = 0; i < theBoard.getRows(); i++)
        {
            if (theBoard.getBoard()[row][i] == null || i != column)
            {
                theBoard.getBoard()[row][i] = new Covered();
            }
        }

        //TODO Assign columns for attack and test row and columns for attacks
    }

    private void assignColumnAttack(Board theBoard)
    {

        for (int i = 0; i < theBoard.getRows(); i++)
        {
            if (theBoard.getBoard()[i][column] == null || i != column)
            {
                theBoard.getBoard()[i][column] = new Covered();
            }
        }
    }

    public void assignDiagnols(Board theBoard)
    {
        upperRightDiagnols(theBoard);
    }

    private void assignDiagnolsHelper(Board theBoard, int horizontalVector, int verticalVector)
    {
        for (int i = row, j = column; i < theBoard.getRows() && j >= 0 && i >= 0 && j < theBoard.getColumns(); i = i + verticalVector, j = j + horizontalVector)
        {
            if (theBoard.getBoard()[i][j] == null || theBoard.getBoard()[i][j].getClass() != Queen.class)
            {
                theBoard.setPiece(new Covered(), i, j);
            }
        }
    }

    public void upperRightDiagnols(Board theBoard)
    {
        int horizontalVector = 1;
        int verticalVector = -1;

        assignDiagnolsHelper(theBoard, horizontalVector, verticalVector);
    }

    public void upperLeftDiagnols(Board theBoard)
    {
        int horizontalVector = -1;
        int verticalVector = -1;

        assignDiagnolsHelper(theBoard, horizontalVector, verticalVector);
    }

    
    //TODO Switch attacking methods to each piece class, otherwise harder to check if pieces can attack each other

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

    public boolean setPiece(Piece aPiece, int aRow, int aColumn)
    {
        if (aPiece.getRow() > aRow || aPiece.getColumn() > aColumn || aColumn < 0 || aRow < 0)
        {
            throw new IllegalArgumentException("Rows and columns for piece are out of range");
        }

        board[aRow][aColumn] = aPiece;
        return true;
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
    private int row, column;

    public void assignAttack(Board theBoard)
    {

    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
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
        Queen secondQueen = new Queen(3, 3);

        QueenAttackCalculator attack = new QueenAttackCalculator(aQueen, secondQueen);

        Board aBoard = new Board(8, 8);

        //attack.assignAttackforPieces();

        //aQueen.assignDiagnols(aBoard);
        //secondQueen.assignDiagnols(aBoard);

        attack.assignAttackforDiagnols();


        //aQueen.assignAttack();
    }
}