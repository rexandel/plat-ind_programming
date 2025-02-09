import java.awt.*;
import java.awt.event.*;

class HelloWorldFrame extends Frame {
    HelloWorldFrame(String s) {
        super(s);
    }
	
    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
        g.drawString("Hello, XXI century World!", 20, 100);
    }
	
    public static void main(String[] args) {
        HelloWorldFrame f = new HelloWorldFrame("Hello, XXI century World!");
        f.setSize(400, 150);
        f.setVisible(true);
		
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}
