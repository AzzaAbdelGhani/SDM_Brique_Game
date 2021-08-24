package Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    private Board board = new Board();
    private Player P1 = new Player("Player 1", Piece_Color.BLACK);
    private Player P2 = new Player("Player 2 ", Piece_Color.WHITE);
    private Piece_Color P1_Color = P1.getColor();
    private Move move = new Move(board, P1, P2);

    @ParameterizedTest
    @CsvSource({"1,3", "4, 5", "6, 8", "10,1", "0,0", "14, 14", "0,7", "14, 12"})
    public void checkIfBoardIsUpdated(int row_id, int col_id)
    {
        Coordinates co = new Coordinates(row_id, col_id);
        move.fillBoardAndUpdateGraph(co);
        assertEquals(board.getPos(co).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"1,9", "5, 1", "10, 4", "0, 14", "9, 3"})
    public void checkIfAPositionIsFilledWithCurrentColor(int row_id, int col_id)
    {
        Coordinates co = new Coordinates(row_id, col_id);
        move.fillBoardAndUpdateGraph(co);
        assertTrue(move.isEscortFilled(co));
    }

    @ParameterizedTest
    @CsvSource({"1,7", "10,6", "4,12", "8,10", "3,9"})
    public void checkIfEscortsAreFilled_LightInnerPositions(int row_id, int col_id)
    {
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagUp());
        move.makeMove(co.getDiagDown());
        assertEquals(board.getPos(co.getRight()).getPieceColor(), P1_Color);
        assertEquals(board.getPos(co.getDown()).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "4,0", "10,0", "0,4", "0,12"})
    public void checkIfEscortsAreFilled_LightPositions_BottomAndLeft(int row_id, int col_id)
    {
        Board board = new Board();
        Move move = new Move(board, P1, P2);
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagUp());
        assertEquals(board.getPos(co.getRight()).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"14,14", "14,6", "6,14", "2,14", "4,14"})
    public void checkIfEscortsAreFilled_LightPositions_TopAndRight(int row_id, int col_id)
    {
        Board board = new Board();
        Move move = new Move(board, P1, P2);
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagDown());
        assertEquals(board.getPos(co.getDown()).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"8,7", "10,3", "5,12", "1,6", "2,11"})
    public void checkIfEscortsAreFilled_DarkInnerPositions(int row_id, int col_id)
    {
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagUp());
        move.makeMove(co.getDiagDown());
        assertEquals(board.getPos(co.getUp()).getPieceColor(), P1_Color);
        assertEquals(board.getPos(co.getLeft()).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"0,9", "3,0", "11,0", "0,9", "0,1"})
    public void checkIfEscortsAreFilled_DarkPositions_BottomAndLeft(int row_id, int col_id)
    {
        Board board = new Board();
        Move move = new Move(board, P1, P2);
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagUp());
        assertEquals(board.getPos(co.getUp()).getPieceColor(), P1_Color);
    }

    @ParameterizedTest
    @CsvSource({"14,1", "14,11", "3,14", "9,14", "13,14"})
    public void checkIfEscortsAreFilled_DarkPositions_TopAndRight(int row_id, int col_id)
    {
        Board board = new Board();
        Move move = new Move(board, P1, P2);
        Coordinates co = new Coordinates(row_id, col_id);
        move.makeMove(co);
        move.makeMove(co.getDiagDown());
        assertEquals(board.getPos(co.getLeft()).getPieceColor(), P1_Color);
    }


    @Test
    public void checkIfPlayerTurnIsChanged()
    {
        P1.setActive(Boolean.TRUE);
        P2.setActive(Boolean.FALSE);
        Move move = new Move(board, P1, P2);
        move.changePlayerTurn();
        assertTrue(P2.IsActive());
        assertFalse(P1.IsActive());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "4,7", "9,6", "13,8", "9,14", "0,0", "14,14"})
    public void checkMakeMove(int row_id, int col_id)
    {
        Coordinates coordinates = new Coordinates(row_id, col_id);
        Board board = new Board();
        Move move = new Move(board, P1, P2);
        assertTrue(move.makeMove(coordinates));
        assertEquals(this.board.getPos(coordinates).getPieceColor(), Piece_Color.BLACK);
    }

    @ParameterizedTest
    @CsvSource({"-1,6","16,3","4, -7", "1, 18", "18,-6","8,7" })
    public void checkInvalidMove(int row_id, int col_id)
    {
        move.makeMove(new Coordinates(8, 7));
        assertFalse(move.makeMove(new Coordinates(row_id, col_id)));
    }

}
