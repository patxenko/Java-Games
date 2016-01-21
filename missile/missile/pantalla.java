package missile;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;



public class pantalla extends JFrame {

	public pantalla() {
		//this.getContentPane().setBackground(Color.black);
		add(new dibujador());
		setTitle ("MISSILE COMMANDER");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		pantalla ventana=new pantalla();
		
	}

}

