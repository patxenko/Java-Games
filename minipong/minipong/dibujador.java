package minipong;
import java.awt.Image;
import java.awt.Color;
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

public class dibujador extends JPanel {
	
	jugador1 jug1;
	jugador2 jug2;
	Timer timer;
	pelota pelotilla;
	Rectangle pelota,jugador1,jugador2;  //definimos los rectangulos para usar el metodo de chocar
	

	public dibujador() {
		jug1=new jugador1();
		jug2=new jugador2();
		pelotilla=new pelota();
		addKeyListener(new TAdapter());
		setFocusable(true);
		
	}
	
	public void paint(Graphics g){
		
	    super.paint(g);
	    pelota=new Rectangle(pelotilla.getX(),pelotilla.getY(),pelotilla.anchura(),pelotilla.altura());
	    jugador1=new Rectangle(jug1.getposx(),jug1.getposy(),jug1.anchura(),jug1.altura());
	    if (pelota.intersects(jugador1)){
	    	pelotilla.colision=1;
	    }
	    
	    jugador2=new Rectangle(jug2.getposx(),jug2.getposy(),jug2.anchura(),jug2.altura());
	    if (pelota.intersects(jugador2)){
	    	pelotilla.colision=2;
	    }
	    
	    
	    jug1.muevete();
	    jug2.muevete();
	    g.drawString("puntos="+pelotilla.puntos1(),20,15);
	    g.drawString("puntos="+pelotilla.puntos2(),700,15);
	    g.setColor(Color.blue);
	    g.fillRect(jug1.getposx(),jug1.getposy(),jug1.anchura(),jug1.altura()); 
	    g.fillRect(jug2.getposx(),jug2.getposy(),jug2.anchura(),jug2.altura());
	    g.setColor(Color.red);
	    g.fillOval(pelotilla.getX(),pelotilla.getY(), pelotilla.anchura(), pelotilla.altura());
	    repaint();
	}
	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_A){
				jug1.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_Z){
				jug1.teclaPulsada(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_UP){
				jug2.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				jug2.teclaPulsada(2);
			}
		}
	}

	
}