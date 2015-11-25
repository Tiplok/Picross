import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1;
	protected boolean value;
	
	public BoxPanel(boolean val){
		super();
		this.value = val;
	}

	public void configure() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseAdapter() {
            private Color background;

            public void mousePressed(MouseEvent e) {
                background = getBackground();
                
                // If it is a right box
                if(value){
	                if(background != Color.GRAY){
		                setBackground(Color.GRAY);
		                repaint();
	                } else {
		                setBackground(Color.WHITE);
		                repaint();
	                }
                } else {
	                setBackground(Color.RED);
	                repaint();
                }
            }

            public void mouseReleased(MouseEvent e) {
                //setBackground(background);
            }
        });
	}
}
