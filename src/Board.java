import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board extends JPanel {
	private static final long serialVersionUID = 1;
	int size;
	int totalTrue;
	int currentFound;
	boolean stateGame;
	
	public Board(int size){
		super();
		this.size = size;
		this.totalTrue = 0;
		this.currentFound = 0;
		this.stateGame = true;
	}

	public void configure() {
		BoxPanel boxPanel;
		NumberPanel numberPanel;
		boolean[][] table = new boolean[size+1][size+1];
		Random rand = new Random();
		boolean value;
		
		// Allocation of the true/false value in each cell of table
		for(int i = 1; i < size+1; i++){
			for(int j = 1; j < size+1; j++){
				value = rand.nextBoolean();
				if(value){
					totalTrue++;
				}
				table[i][j] = value;
			}
		}
		
		this.setLayout(new GridLayout(size+1, size+1));
		
		// Browse the board
		for(int i = 0; i < size+1; i++){
			for(int j = 0; j < size+1; j++){
				// If we are in the first column or first row of the board
				if(i == 0 || j == 0){
					int total;
					numberPanel = new NumberPanel();

					// We don't consider the most top-left box
					if(i == 0 ^ j == 0){
						total = 0;
						
						// If we are in the game board in the X axis
						if(i >= 1 && i < size+1){
							
							// X asis path
							for(int k = 1; k < size+1; k++){
								
								// If we encounter a right box
								if(table[i][k]){
									// If the previous box was right (ignore first box), we increment
									if(k != 1 && table[i][k-1]){
										total++;
									} else {
										total = 1;
									}
								} else {
									if(total != 0){
										numberPanel.add(new JLabel(""+total));
									}
									total = 0;
								}
							}
							if(total != 0){
								numberPanel.add(new JLabel(""+total));
							}
							

						// If we are in the game board in the Y axis
						} else if(j >= 1 && j < size+1){

							// Y asis path
							for(int k = 1; k < size+1; k++){
								

								// If we encounter a good box
								if(table[k][j]){
									// If the previous box was right (ignore first box), we increment
									if(k != 1 && table[k-1][j]){
										total++;
									} else {
										total = 1;
									}
								} else {
									if(total != 0){
										numberPanel.add(new JLabel(""+total));
									}
									total = 0;
								}
							}
							if(total != 0){
								numberPanel.add(new JLabel(""+total));
							}
						}
					}
					this.add(numberPanel);
					
				// Else we are in the real game board
				} else {
					boxPanel = new BoxPanel(table[i][j], this);
					boxPanel.configure();
					this.add(boxPanel);
				}
			}
		}
	}

}
