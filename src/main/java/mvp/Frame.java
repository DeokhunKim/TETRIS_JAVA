package mvp;

import mvp.tetrimino.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
    public Frame(){
        setTitle("첫번째 프레임");
        setSize(Field.MAX_X,Field.MAX_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Mino activeMino = new Zmino(5, 3);
        Container contentPane = getContentPane();
        Field field = new Field();
        contentPane.add(field);
        field.activeMino = activeMino;
        field.legacyPieces.add(new Piece(8, 7, Color.gray));
        field.legacyPieces.add(new Piece(9, 7, Color.gray));
        field.legacyPieces.add(new Piece(7, 7, Color.gray));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_DOWN: //방향키(아래) 눌렀을때
                        activeMino.moveDown();
                        break;
                    case KeyEvent.VK_UP: //방향키(위)눌렀을때
                        activeMino.rotation();
                        break;
                    case KeyEvent.VK_LEFT:// 방향키(왼)눌렀을때
                        activeMino.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:// 방향키(오른)눌렀을때
                        activeMino.moveRight();
                        break;
                    default:
                        break;
                }
                contentPane.repaint();
            }
        });

        setVisible(true);

    }
}
