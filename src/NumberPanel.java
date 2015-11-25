import javax.swing.JLabel;
import javax.swing.JPanel;


public class NumberPanel extends JPanel {
	private static final long serialVersionUID = 1;
	protected int value;
	
	public NumberPanel(int val){
		super();
		this.value = val;
	}

	public void configure() {
		if(value != -1){
			this.add(new JLabel(""+value));
		}
	}
}
