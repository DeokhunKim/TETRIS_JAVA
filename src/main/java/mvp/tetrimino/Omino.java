package mvp.tetrimino;

import java.awt.*;
import java.util.HashSet;

public class Omino extends Mino{
    public Omino(int x, int y, HashSet<Piece> legacyPieces) {
        super(x, y, new Piece[]{
                new Piece(x,y, Color.yellow),
                new Piece(x,y - 1, Color.yellow),
                new Piece(x - 1,y - 1, Color.yellow),
                new Piece(x - 1, y, Color.yellow)},
                legacyPieces
        );
    }
}
