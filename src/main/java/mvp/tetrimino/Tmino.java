package mvp.tetrimino;

import java.awt.*;
import java.util.HashSet;

public class Tmino extends Mino{
    public Tmino(int x, int y, HashSet<Piece> legacyPieces) {
        super(x, y, new Piece[]{
                new Piece(x + 0, y + 0, Color.magenta),
                new Piece(x + 0, y - 1, Color.magenta),
                new Piece(x - 1, y + 0, Color.magenta),
                new Piece(x + 1 , y + 0, Color.magenta)},
                legacyPieces
        );
    }
}
