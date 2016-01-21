package gravedad;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;



public class principal extends JFrame {

	public principal() {
		add(new dibujador());
		this.getContentPane().setBackground(Color.black);
		setTitle ("Juego Planets");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		principal ventana=new principal();
		
	}

}