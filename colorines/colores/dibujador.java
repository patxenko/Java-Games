package colores;
//librerias
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

	caida ca;
	cuadro cuad;
	brocha bro;
	colisiones coli;
	public static int spera;
	
	public dibujador() {
		coli=new colisiones();
		ca=new caida();
		cuad=new cuadro();
		bro=new brocha();
		addKeyListener(new TAdapter());
		setFocusable(true);
	}
	
		

	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_CONTROL){
				cuadro.cambiaColor();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				bro.mover(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				bro.mover(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_SPACE){
				bro.pintar();
			}
			
		}
		public void keyReleased(KeyEvent d){
			if (d.getKeyCode()==KeyEvent.VK_SPACE){
				bro.nopintar();
			}
		}
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		coli.coloca();
		//dibujado del cuadro
		Color mycolor;
		mycolor=new Color(cuadro.rojo,cuadro.verde,cuadro.azul);
		g.setColor(mycolor);
		g.fillRect(cuadro.posx, cuadro.posy, cuadro.longitud, cuadro.longitud);
		
		//dibujado de la brocha
		mycolor=new Color(100,100,100);
		g.setColor(mycolor);
		g.drawOval(brocha.centrox1, brocha.centroy1, brocha.lon1, brocha.lon1);
		g.drawOval(brocha.centrox2, brocha.centroy2, brocha.lon2, brocha.lon2);
		g.drawOval(brocha.centrox3, brocha.centroy3, brocha.lon3, brocha.lon3);
		coli.coloca();
		//pintura de brocha
		for (int i=0;i<brocha.pixels.size(); i++){
			mycolor=new Color(brocha.rojo.get(i),brocha.verde.get(i),brocha.azul.get(i) );
			g.setColor(mycolor);
			g.fillOval(brocha.pixels.get(i), brocha.pixely, 2, 2);
		}
		coli.coloca();
		//cudrados que caen
		for (int d=0;d<caida.posiy.size();d++){
			spera=caida.esperas.get(d);
			if (spera<=0){
				caida.cae.remove(d);
				caida.cae.add(d,1);
			mycolor=new Color(caida.colr.get(d),caida.colg.get(d),caida.colazul.get(d));
			g.setColor(mycolor);
			g.fillRect(caida.posix.get(d), caida.posiy.get(d), 10, 10);
			}
			else{
				spera--;
				caida.esperas.remove(d);
				caida.esperas.add(d,spera);
			}
		}
		
		coli.coloca();
		repaint();
	}
}
