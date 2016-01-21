package bacterias;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
public class dibujador extends JPanel implements ActionListener {
	private Timer mitimer;
	jugador jug;
	bacterias bacte;
	closisionJB col;
	int posxjug,posyjug,tamañojug,incrementoxjug,incrementoyjug,colorin;
	ArrayList <Integer> posxB,posyB,tamB;
	public dibujador() {
		jug=new jugador();
		bacte=new bacterias();
		col=new closisionJB();
		posxjug=jugador.posx();
		posyjug=jugador.posy();
		tamañojug=jugador.tam();
		incrementoxjug=0;
		incrementoyjug=0;
		mitimer=new Timer(50,this);
		mitimer.start();
		addKeyListener(new TAdapter());
		setFocusable(true);
	}

	public void paint(Graphics g){
		super.paint(g);
		//ponemos en negro el fondo de la pantalla
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 630);
		//llamamos al metodo colision
		closisionJB.colJB();
		//closisionJB.colJB();
		if (closisionJB.finalizado==1){
			g.setColor(Color.white);
			g.drawString("GAME OVER: HAS SIDO COMIDO POR UNA BACTERIA ROJA MAMON",200,300);
		}
		else{
		//DIBUJADO DEL JUGADOR;
		g.setColor(Color.blue);
		g.fillOval(jugador.posx(),jugador.posy(),jugador.tam(),jugador.tam());
		//DIBUJADO DE LAS BACTERIAS
		bacte.colisiona();
		for (int j=0;j<20;j++){
			colorin=bacte.color.get(j);
			if (colorin==1){
			g.setColor(Color.red);
			}
			if (colorin==2){
			g.setColor(Color.blue);
			}
			if (colorin==3){
			g.setColor(Color.white);
			}
		    
			g.fillOval((int)bacte.posicionesx.get(j),(int)bacte.posicionesy.get(j),(int)bacte.tamaños.get(j),(int)bacte.tamaños.get(j));
			}
		repaint();
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		jug.muevete(incrementoyjug,incrementoxjug);
	}
	
	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_UP){
				incrementoyjug=-1;
				incrementoxjug=0;
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				incrementoyjug=+1;
				incrementoxjug=0;
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				incrementoxjug=1;
				incrementoyjug=0;
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				incrementoxjug=-1;
				incrementoyjug=0;
			}
			
		}
	}

}