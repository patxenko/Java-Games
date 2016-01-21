package gusano;
import javax.swing.JFrame;

public class pantalla extends JFrame{

	public pantalla() {
		add(new gusano());
		setTitle ("SNAKE");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		pantalla a=new pantalla();
		a.add(new esfera());
	}

}
