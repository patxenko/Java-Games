package minipong;
import javax.swing.JFrame;


public class Principal extends JFrame {

	public Principal() {
		add(new dibujador());
		setTitle ("MINI-PONG");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		Principal ventana=new Principal();
		
	}

}
