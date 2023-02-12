package mvp;

import mvp.tetrimino.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;

public class Frame extends JFrame {
    Timer timer = new Timer(1500, new TimerListener());
    Field field = new Field();
    Container contentPane;

    public Frame(){
        setTitle("TETRIS - JAVA");
        setSize(Field.MAX_X,Field.MAX_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Mino activeMino = getRandomMino(field.legacyPieces);
        contentPane = getContentPane();
        contentPane.add(field);
        field.activeMino = activeMino;
        field.legacyPieces.add(new Piece(8, 10, Color.gray, true));
        field.legacyPieces.add(new Piece(9, 10, Color.gray, true));
        field.legacyPieces.add(new Piece(7, 10, Color.gray, true));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (field.activeMino == null) {
                    return;
                }
                switch (e.getKeyCode()){
                    case KeyEvent.VK_DOWN: //방향키(아래) 눌렀을때
                        if (field.activeMino == null) {
                            field.activeMino = getRandomMino(field.legacyPieces);
                        }

                        if (field.activeMino.moveDown() == false) {
                            field.activeMino = null;
                        }
                        contentPane.repaint();
                        break;
                    case KeyEvent.VK_UP: //방향키(위)눌렀을때
                        field.activeMino.rotation();
                        break;
                    case KeyEvent.VK_LEFT:// 방향키(왼)눌렀을때
                        field.activeMino.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:// 방향키(오른)눌렀을때
                        field.activeMino.moveRight();
                        break;
                    default:
                        break;
                }
                contentPane.repaint();
            }
        });
        timer.start();

        setVisible(true);

    }

    public Mino getRandomMino(HashSet<Piece> legacyPieces) {
        int i = new Random().nextInt(7);
        switch (i) {
            case 0:
                return new Imino(5, 3, field.legacyPieces);
            case 1:
                return new Jmino(5, 3, field.legacyPieces);
            case 2:
                return new Lmino(5, 3, field.legacyPieces);
            case 3:
                return new Omino(5, 3, field.legacyPieces);
            case 4:
                return new Smino(5, 3, field.legacyPieces);
            case 5:
                return new Zmino(5, 3, field.legacyPieces);
            case 6:
                return new Tmino(5, 3, field.legacyPieces);
            default:
                return null;
        }
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (field.activeMino == null) {
                field.activeMino = getRandomMino(field.legacyPieces);
            }

            if (field.activeMino.moveDown() == false) {
                field.activeMino = null;
            }
            contentPane.repaint();
        }

    }
}
