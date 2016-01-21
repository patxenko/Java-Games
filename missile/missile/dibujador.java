package missile;

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

    disparo d;
	jugador j;
	asteroides as;
	Rectangle xplosion,asteroid;
	
	public dibujador() {
		as=new asteroides();
		d=new disparo();
        j=new jugador();
        xplosion=new Rectangle();
        asteroid=new Rectangle();
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
			if (e.getKeyCode()==KeyEvent.VK_SPACE){
				d.acercamiento(jugador.posx,jugador.posy);
			}
			
		}
	}
	
	
	
	
	

	public void paint(Graphics g){
		super.paint(g);
		//fondo de pantalla con suelo negro y cielo azul
		g.setColor(Color.black);
		g.fillRect(0,550,800,50);
		Color mycolor;
		mycolor=new Color(176,196,222);
		g.setColor(mycolor);
		g.fillRect(0,0,800,550);
		//dibujo del jugador cuadrado verde
		g.setColor(Color.green);
		g.fillRect(jugador.posx,jugador.posy,10,10);
		//dibujamos la primera fase del disparo el acercamiento
		g.setColor(Color.yellow);
		for (int a=0;a<d.posicionesx.size();a++){
			g.drawLine(d.posicionesx.get(a), 550, d.posicionesx.get(a), d.posicionesy.get(a));
		}
		//dibujamos la segunda fase del disparo es decir la explosion
		if (disparo.explosion==1 && disparo.redibujados>0){
			g.fillOval(disparo.ex-50, disparo.ey-50, disparo.ancho, disparo.ancho);
			disparo.redibujados--;
			//este es el ractangle para detectar colision
			xplosion=new Rectangle(disparo.ex-50, disparo.ey-50, disparo.ancho, disparo.ancho);
		}
		if (disparo.explosion==1 && disparo.redibujados<=0){
			xplosion=new Rectangle(disparo.ex-50, disparo.ey-50, 0, 0);
		}
		//dibujamos los asteroides
		g.setColor(Color.red);
		for (int f=0;f<asteroides.posisx.size();f++){
			g.fillOval(asteroides.posisx.get(f), asteroides.posisy.get(f), 50, 50);
		}
		//creamos el rectangle para detectar colisiones de asteroid
		for (int y=0;y<asteroides.posisx.size();y++){
			asteroid=new Rectangle(asteroides.posisx.get(y), asteroides.posisy.get(y), 50, 50);
			if (xplosion.intersects(asteroid)){
				as.generaNuevoMuerte(y);
			}
		}
		//finalmenta como ayuda dibujamos el nivel
		g.setColor(Color.black);
		g.drawString("Nivel: "+asteroides.nivel,740,20);
		repaint();
	}

}

