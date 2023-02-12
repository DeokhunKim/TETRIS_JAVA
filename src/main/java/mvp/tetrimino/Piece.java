package mvp.tetrimino;
import lombok.Data;

import java.awt.*;
import java.util.Objects;

import static mvp.Field.SCALE;

@Data
public class Piece extends Component {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean isLegacy = true;

    public Piece(int x, int y, Color color, boolean isLegacy) {
        this.x = x * SCALE;
        this.y = y * SCALE;
        this.width = 1 * SCALE;
        this.height = 1 * SCALE;
        this.color = color;
        this.isLegacy = isLegacy;
    }

    public Piece(int x, int y, Color color) {
        this.x = x * SCALE;
        this.y = y * SCALE;
        this.width = 1 * SCALE;
        this.height = 1 * SCALE;
        this.color = color;
        this.isLegacy = false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        if (isLegacy) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return x == piece.x  && y == piece.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
