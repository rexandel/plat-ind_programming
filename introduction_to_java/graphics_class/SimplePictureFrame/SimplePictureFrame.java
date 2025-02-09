import java.awt.*;
import java.awt.event.*;

class SimplePictureFrame extends Frame {
    SimplePictureFrame(String s) {
        super(s);
        setBounds(0, 0, 500, 500);
        setVisible(true);
		setResizable(false);
    }
	
    public void paint(Graphics g) {
        Dimension dimensionOfWindow = getSize();
		
		int heightOfWindow = dimensionOfWindow.height;
		int widthOfWindow = dimensionOfWindow.width;
		
		int mainCircleStartXDot = widthOfWindow / 4;
		int mainCircleStartYDot = heightOfWindow / 4;
		
		int firstCircleStartXDot = widthOfWindow / 3;
		int firstCircleStartYDot = heightOfWindow / 3 + 30;
		
		int secondCircleStartXDot = widthOfWindow / 3 + heightOfWindow / 5 + 15;
		int secondCircleStartYDot = heightOfWindow / 3 + 30;
		
		g.drawOval(mainCircleStartXDot, mainCircleStartYDot, widthOfWindow / 2, heightOfWindow / 2);
		g.drawOval(firstCircleStartXDot, firstCircleStartYDot, widthOfWindow / 10, heightOfWindow / 10);
		g.drawOval(secondCircleStartXDot, secondCircleStartYDot, widthOfWindow / 10, heightOfWindow / 10);
		
		int arcStartXDot = widthOfWindow / 3;
		int arcStartYDot = heightOfWindow / 2 + heightOfWindow / 10;
		
		g.drawArc(arcStartXDot, arcStartYDot, widthOfWindow / 5, heightOfWindow / 5, 45, 45); 
		
        setBackground(Color.black);
        setForeground(Color.yellow);
    }
	
    public static void main(String[] args) {
        SimplePictureFrame simplePictureFrame = new SimplePictureFrame("Drawing picture");
		
        simplePictureFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}
