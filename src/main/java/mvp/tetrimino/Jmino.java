package mvp.tetrimino;

import java.awt.*;
import java.util.HashSet;

public class Jmino extends Mino{
    public Jmino(int x, int y, HashSet<Piece> legacyPieces) {
        super(x, y, new Piece[]{
                new Piece(x, y, Color.BLUE),
                new Piece(x + 0,y - 1, Color.BLUE),
                new Piece(x + 0,y - 2, Color.BLUE),
                new Piece(x - 1, y + 0, Color.BLUE)},
                legacyPieces
        );
    }
}
