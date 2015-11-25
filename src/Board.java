import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;


public class Board extends JPanel {
	private static final long serialVersionUID = 1;
	
	public Board(){
		super();
	}

	public void configure() {
		BoxPanel boxPanel;
		NumberPanel numberPanel;
		boolean[][] table = new boolean[5][5];
		Random rand = new Random();
		
		for(int i = 1; i < 5; i++){
			for(int j = 1; j < 5; j++){
				table[i][j] = rand.nextBoolean();
			}
		}
		
		this.setLayout(new GridLayout(5, 5));
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(i == 0 || j == 0){
					int total;
					if(i == 0 ^ j == 0){
						total = 0;
						if(i >= 1 && i < 5){
							for(int k = 1; k < 5; k++){
								if(table[i][k]){
									total += 1;
								}
							}
						} else if(j >= 1 && j < 5){
	
							for(int k = 1; k < 5; k++){
								if(table[k][j]){
									total += 1;
								}
							}
						}
					} else {
						total = -1;
					}
					numberPanel = new NumberPanel(total);
					numberPanel.configure();
					this.add(numberPanel);
				} else {
					boxPanel = new BoxPanel(table[i][j]);
					boxPanel.configure();
					this.add(boxPanel);
				}
			}
		}
	}

}
