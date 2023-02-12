package mvp.tetrimino;

import java.awt.*;

public class Smino extends Mino{
    public Smino(int x, int y) {
        super(x, y, new Piece[]{
                new Piece(x + 0,y + 0, Color.GREEN),
                new Piece(x - 1, y + 0, Color.GREEN),
                new Piece(x + 0,y - 1, Color.GREEN),
                new Piece(x + 1, y - 1, Color.GREEN)}
        );
    }
}
