package bacterias;

import javax.swing.JFrame;
import java.awt.Color;



public class pantalla extends JFrame {
	public pantalla() {
		add(new dibujador());
		setTitle ("Juego Bacterias");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(802,632);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		pantalla ventana;
		ventana=new pantalla();
		
		
		
	}

}