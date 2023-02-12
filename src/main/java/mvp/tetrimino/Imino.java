package mvp.tetrimino;

import java.awt.*;
import java.util.HashSet;

public class Imino extends Mino{
    public Imino(int x, int y, HashSet<Piece> legacyPieces) {
        super(x, y, new Piece[]{
                new Piece(x + 0,y + 0, Color.CYAN),
                new Piece(x + 0,y - 1, Color.CYAN),
                new Piece(x + 0,y - 2, Color.CYAN),
                new Piece(x + 0, y + 1, Color.CYAN)},
                legacyPieces
        );
    }
}
