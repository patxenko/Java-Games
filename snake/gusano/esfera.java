package gusano;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class esfera extends JPanel {
      
	private int posx;
	private int posy;
	private double x,y;
	
	
	public esfera() {
		x=Math.random()*780+20;
		y=Math.random()*380+20;
		posx=(int)x;
		posy=(int)y;
	}
	
	public int getX(){
		return posx;
	}
	public int getY() {
		return posy;
	}
	public void creacionEsfera(){
		x=Math.random()*770+20;
		y=Math.random()*370+20;
		posx=(int)x;
		posy=(int)y;
	}

	

}
