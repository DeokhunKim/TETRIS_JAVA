package mvp;

import mvp.tetrimino.Mino;
import mvp.tetrimino.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Field extends JPanel {
    public final static int SCALE = 20;
    public final static int MIN_X = 0 * SCALE;
    public final static int MAX_X = 10 * SCALE;
    public final static int MIN_Y = 0 * SCALE;
    public final static int MAX_Y = 20 * SCALE;

    public LinkedList<Piece> legacyPieces = new LinkedList<>();
    public Mino activeMino;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        activeMino.paint(g);

        for (Piece legacyPiece : legacyPieces) {
            legacyPiece.paint(g);
        }

    }
}
