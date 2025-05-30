import java.awt.*;
import java.awt.event.*;

class SquareFrame extends Frame {
    SquareFrame(String s) {
        super(s);
        setBounds(0, 0, 500, 500);
        setVisible(true);
		setResizable(false);
    }
	
    public void paint(Graphics g) {
        Dimension dimensionOfWindow = getSize();
		
		int heightOfWindow = dimensionOfWindow.height;
		int widthOfWindow = dimensionOfWindow.width;
		
		int startXDot = widthOfWindow / 4;
		int startYDot = heightOfWindow / 4;
		
		g.drawRect(startXDot, startYDot, widthOfWindow / 2, heightOfWindow / 2);
		
        setBackground(Color.blue);
        setForeground(Color.red);
    }
	
    public static void main(String[] args) {
        SquareFrame squareFrame = new SquareFrame("Drawing square");
		
        squareFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}
