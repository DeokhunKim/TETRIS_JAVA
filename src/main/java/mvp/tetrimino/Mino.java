package mvp.tetrimino;

import mvp.Field;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

import static mvp.Field.*;

public class Mino extends JComponent {
    protected int x;
    protected int y;

    protected Piece[] pieces;
    public HashSet<Piece> legacyPieces;

    public Mino(int x, int y, Piece[] pieces, HashSet<Piece> legacyPieces) {
        this.x = x;
        this.y = y;
        this.pieces = pieces;
        this.legacyPieces = legacyPieces;
        for (Piece piece : pieces) {
            piece.setLegacy(false);
        }
    }

    public boolean moveDown() {
        y += 1 ;

        // is blocking
        for (Piece piece : pieces) {
            if (legacyPieces.contains(new Piece(piece.getX() / SCALE, piece.getY() / SCALE + 1, null))
            || piece.getY() + 1 * SCALE >= Field.MAX_Y - 1 * SCALE ){
                for (Piece addedPiece : pieces) {
                    addedPiece.setLegacy(true);
                    legacyPieces.add(addedPiece);
                }
                return false;
            }
        }

        for (Piece piece : pieces) {
            piece.setY(piece.getY() + 1 * SCALE);
        }

        return true;
    }

    public boolean moveRight() {
        // is blocking
        for (Piece piece : pieces) {
            if (legacyPieces.contains(new Piece(piece.getX() / SCALE + 1, piece.getY() / SCALE, null))
                    || piece.getX() + 1 * SCALE >= MAX_X ){
                return false;
            }
        }

        x += 1;

        for (Piece piece : pieces) {
            piece.setX(piece.getX() + 1 * SCALE);
        }

        return true;
    }

    public boolean moveLeft() {
        // is blocking
        for (Piece piece : pieces) {
            if (legacyPieces.contains(new Piece(piece.getX() / SCALE - 1, piece.getY() / SCALE, null))
                    || piece.getX() - 1 * SCALE <= Field.MIN_X - 1 ){
                return false;
            }
        }

        x -= 1;
        for (Piece piece : pieces) {
            piece.setX(piece.getX() - 1 * SCALE);
        }

        return true;
    }

    public boolean rotation() {
        //TODO - if crash, return false
        boolean isBlocking = false;

        Piece newPieces[] = new Piece[4];
        int idx = 0;
        for (Piece piece : pieces) {
            int px = piece.getX() / SCALE;
            int py = piece.getY() / SCALE;
            int mx = this.x;
            int my = this.y;

            if(mx > px ) {
                if (my > py) {//1사분면
                    newPieces[idx] = new Piece((mx + (my - py) - 1), (my - (mx - px)), piece.getColor());
                } else if (my <= py) { //4사분면
                    newPieces[idx] = new Piece((mx - (py - my) - 1), (my - (mx - px)), piece.getColor());
                } else {
                    System.out.println("rotation error");
                }
            } else if (mx <= px ) {
                if (my > py) {//2사분면
                    newPieces[idx] = new Piece((mx + (my - py) - 1), (my + (px - mx)), piece.getColor());
                } else if (my <= py) { //3사분면
                    newPieces[idx] = new Piece((mx - (py - my) - 1), (my + (px - mx)), piece.getColor());
                } else {
                    System.out.println("rotation error");
                }
            }
            // is blocking
            if (isBlockingByPiece(newPieces[idx])) {
                isBlocking = true;
            }
            idx++;
        }

        // if blocking, try move 1
        if (isBlocking) {
            // left
            for (Piece newPiece : newPieces) {
                newPiece.setX(newPiece.getX() - 1 * SCALE);
            }
            if (!isBlockingByPieceArray(newPieces)) {
                this.pieces = newPieces;
                this.x -= 1;
                return true;
            }
            // right
            for (Piece newPiece : newPieces) {
                newPiece.setX(newPiece.getX() + 2 * SCALE);
            }
            if (!isBlockingByPieceArray(newPieces)) {
                this.pieces = newPieces;
                this.x += 1;
                return true;
            }
            // up
            for (Piece newPiece : newPieces) {
                newPiece.setX(newPiece.getX() - 1 * SCALE);
                newPiece.setY(newPiece.getY() - 1 * SCALE);
            }
            if (!isBlockingByPieceArray(newPieces)) {
                this.pieces = newPieces;
                this.y -= 1;
                return true;
            }
            // down
            for (Piece newPiece : newPieces) {;
                newPiece.setY(newPiece.getY() + 2 * SCALE);
            }
            if (!isBlockingByPieceArray(newPieces)) {
                this.pieces = newPieces;
                this.y += 1;
                return true;
            }

            return false;
        }

        this.pieces = newPieces;
        return true;
    }

    private boolean isBlockingByPiece(Piece newPiece) {
        return legacyPieces.contains(newPiece) ||
                newPiece.getX() <= Field.MIN_X - 1 * SCALE ||
                newPiece.getX() >= Field.MAX_X ||
                newPiece.getY() >= Field.MAX_Y - 1 * SCALE;
    }

    private boolean isBlockingByPieceArray(Piece[] newPieces) {
        for (Piece newPiece : newPieces) {
            if (isBlockingByPiece(newPiece)) {
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics g) {
        for (Piece piece : pieces) {
            piece.paint(g);
        }
    }

}
