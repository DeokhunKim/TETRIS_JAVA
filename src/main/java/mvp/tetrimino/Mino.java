package mvp.tetrimino;

import javax.swing.*;
import java.awt.*;
import static mvp.Field.SCALE;

public class Mino extends JComponent {
    protected int x;
    protected int y;

    protected Piece[] pieces;

    public Mino(int x, int y, Piece[] pieces) {
        this.x = x;
        this.y = y;
        this.pieces = pieces;
    }

    public boolean moveDown() {
        y += 1 ;

        //TODO - if crash, return false

        for (Piece piece : pieces) {
            piece.setY(piece.getY() + 1 * SCALE);
        }

        return true;
    }

    public boolean moveRight() {
        x += 1;

        //TODO - if crash, return false

        for (Piece piece : pieces) {
            piece.setX(piece.getX() + 1 * SCALE);
        }

        return true;
    }

    public boolean moveLeft() {
        x -= 1;

        //TODO - if crash, return false

        for (Piece piece : pieces) {
            piece.setX(piece.getX() - 1 * SCALE);
        }

        return true;
    }

    public boolean rotation() {
        //TODO - if crash, return false

        for (Piece piece : pieces) {
            int px = piece.getX() / SCALE;
            int py = piece.getY() / SCALE;
            int mx = this.x;
            int my = this.y;

            if(mx > px ) {
                if (my > py) {//1사분면
                    piece.setX((mx + (my - py) - 1) * SCALE);
                    piece.setY((my - (mx - px)) * SCALE);
                } else if (my <= py) { //4사분면
                    piece.setX((mx - (py - my) - 1) * SCALE);
                    piece.setY((my - (mx - px)) * SCALE);
                } else {
                    System.out.println("rotation error");
                }
            } else if (mx <= px ) {
                if (my > py) {//2사분면
                    piece.setX((mx + (my - py) - 1) * SCALE);
                    piece.setY((my + (px - mx)) * SCALE);
                } else if (my <= py) { //3사분면
                    piece.setX((mx - (py - my) - 1) * SCALE);
                    piece.setY((my + (px - mx)) * SCALE);
                } else {
                    System.out.println("rotation error");
                }
            }

            /*
            if(mx > px ) {
                if (my > py) {//1사분면
                    piece.setX((mx + (my - py)) * SCALE);
                    piece.setY((my - (mx - px)) * SCALE);
                } else if (my <= py) { //4사분면
                    piece.setX((mx - (py - my)) * SCALE);
                    piece.setY((my - (mx - px)) * SCALE);
                } else {
                    System.out.println("rotation error");
                }
            } else if (mx <= px ) {
                if (my > py) {//2사분면
                    piece.setX((mx + (my - py)) * SCALE);
                    piece.setY((my + (px - mx)) * SCALE);
                } else if (my <= py) { //3사분면
                    piece.setX((mx - (py - my)) * SCALE);
                    piece.setY((my + (px - mx)) * SCALE);
                } else {
                    System.out.println("rotation error");
                }
            }
             */


        }

        return true;
    }

    public void paint(Graphics g) {
        for (Piece piece : pieces) {
            piece.paint(g);
        }
    }

}
