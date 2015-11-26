import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1;
	protected boolean value;
	protected Board board;
	
	public BoxPanel(boolean val, Board board){
		super();
		this.value = val;
		this.board = board;
	}

	public void configure() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseAdapter() {
            private Color background;

            public void mousePressed(MouseEvent e) {
                background = getBackground();
                if(board.stateGame){
	                // If it is a right box
	                if(value){
		                if(background != Color.GRAY){
			                setBackground(Color.GRAY);
			                repaint();
			                checkEnd();
		                }
	                } else {
		                setBackground(Color.RED);
		                repaint();
		                defeat();
	                }
                }
            }

			public void mouseReleased(MouseEvent e) {
            }
        });
	}

	protected void defeat() {
		System.out.println("DEFEAT !");
		board.stateGame = false;
	}

	protected void checkEnd() {
		board.currentFound++;
		if(board.totalTrue == board.currentFound){
			System.out.println("VICTORY !");
			board.stateGame = false;
		}
	}
}
