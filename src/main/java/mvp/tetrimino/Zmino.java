package mvp.tetrimino;

import java.awt.*;
import java.util.HashSet;

public class Zmino extends Mino{
    public Zmino(int x, int y, HashSet<Piece> legacyPieces) {
        super(x, y, new Piece[]{
                new Piece(x + 0, y + 0, Color.RED),
                new Piece(x - 1, y - 1, Color.RED),
                new Piece(x - 1, y + 0, Color.RED),
                new Piece(x - 2 , y - 1, Color.RED)},
                legacyPieces
        );
    }
}
