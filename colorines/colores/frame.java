package colores;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;



public class frame extends JFrame {

	public frame() {
		//this.getContentPane().setBackground(Color.black);
		add(new dibujador());
		setTitle ("Juego Planets");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		frame ventana=new frame();
		
	}

}
