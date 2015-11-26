import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1;
	
	public Window(){
		// Create the frame
		super("Picross");
	}

	public void displayGUI() {
		Window window = new Window();

		// Create the board, avoid to exceed 30
		final Board board = new Board(5);
		
		board.configure();
		window.configure(board);
	}

	private void configure(Board board) {
		// What happens when the frame closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Put the board in the frame
		this.getContentPane().add(board, BorderLayout.CENTER);

		// Size the frame
		this.setPreferredSize(new Dimension(800, 700));
		this.pack();

		// Show it
		this.setVisible(true);
	}
}
