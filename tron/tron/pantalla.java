package tron;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;



public class pantalla extends JFrame {

	public pantalla() {
		//this.getContentPane().setBackground(Color.black);
		add(new dibujador());
		setTitle ("Juego Planets");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(802,632);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		pantalla ventana=new pantalla();
		
	}

}
