package tunel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class dibujador extends JPanel{

	fondo f;
	jugador j;
	salido s;
	public dibujador() {
		s=new salido();
		j=new jugador();
		f=new fondo();
		addKeyListener(new TAdapter());
		setFocusable(true);

	}
	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_UP){
				j.muevete(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				j.muevete(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				j.muevete(3);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				j.muevete(4);
			}
			
		}
	}
	
	
	
	
	

	public void paint(Graphics g){
		super.paint(g);
		//fondo negro
		g.setColor(Color.black);
		g.fillRect(0, 0, 802, 632);
		//rectangulos blancos
		g.setColor(Color.white);
		for (int i=0;i<fondo.posicionesx.size();i++){
			g.fillRect(fondo.posicionesx.get(i),fondo.posicionesy.get(i),fondo.anchuras.get(i),fondo.alturas.get(i));
		}
		//dibujamos al jugador
		g.setColor(Color.red);
		g.fillRect(jugador.posx,jugador.posy,jugador.ancho,jugador.alto);
		
		//detectamos si se ha salido o no;
		s.colision();
		if (jugador.fin==1){
			g.drawString("FIN DE LA PARTIDA", 350, 200);
		}
		repaint();
	}

}
