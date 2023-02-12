package mvp.tetrimino;
import lombok.Data;

import java.awt.*;

import static mvp.Field.SCALE;

@Data
public class Piece extends Component {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Piece(int x, int y, Color color) {
        this.x = x * SCALE;
        this.y = y * SCALE;
        this.width = 1 * SCALE;
        this.height = 1 * SCALE;
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawRect(x, y, width, height);

    }

    @Override
    public String toString() {
        return "Piece{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }


}
