package mvp.tetrimino;

import java.awt.*;
import java.util.Arrays;

import static mvp.Field.SCALE;

public class Lmino extends Mino{
    public Lmino(int x, int y) {
        super(x, y, new Piece[]{
                new Piece(x, y, Color.ORANGE),
                new Piece(x - 1,y, Color.ORANGE),
                new Piece(x - 1,y - 1, Color.ORANGE),
                new Piece(x - 1, y - 2, Color.ORANGE)}
        );
    }
}
