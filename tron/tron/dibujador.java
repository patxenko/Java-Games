package tron;
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

public class dibujador extends JPanel {

	jugador jug;
	enemigo enem;
	public int posxJug,posyJug,posxEnem,posyEnem;
	int matriz[][],matrizEnem[][];
	public dibujador() {
		jug=new jugador();
		enem=new enemigo();
		addKeyListener(new TAdapter());
		setFocusable(true);
	}

	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_UP){
				jug.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				jug.teclaPulsada(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				jug.teclaPulsada(3);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				jug.teclaPulsada(4);
			}
			if (e.getKeyCode()==KeyEvent.VK_W){
				enem.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_D){
				enem.teclaPulsada(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_S){
				enem.teclaPulsada(3);
			}
			if (e.getKeyCode()==KeyEvent.VK_A){
				enem.teclaPulsada(4);
			}
			
		}
	}
public void paint(Graphics g){
	super.paint(g);
	//cuando el jugador colisiona con la linea del enemigo
    if (enem.matriz[jug.posx()][jug.posy()]==2){
    	enem.incrementox=0;
		enem.incrementoy=0;
    	jug.pierde(jug.posx(),jug.posy());
    	g.drawString("EL jugador verde pierde", 300, 300);
    }
    //cuando el enemigo colisiona con la linea del jugador
    if (jug.matriz[enem.posx()][enem.posy()]==1){
    	enem.pierde(enem.posx(),enem.posy());
    	jug.incrementox=0;
		jug.incrementoy=0;
    	g.drawString("EL jugador rojo pierde", 300, 300);
    }
	    
	    g.setColor(Color.green);
	    g.drawLine(jug.posx(),jug.posy(),jug.posx(),jug.posy());
	    for (int i=0;i<800;i++){
	    	for (int j=0;j<600;j++){
	    		if (jug.matriz[i][j]==1){
	    			g.drawLine(i, j, i, j);
	    		}
	    	}
	    }
	    g.setColor(Color.red);
	    g.drawLine(enem.posx(),enem.posy(),enem.posx(),enem.posy());
	    for (int i=0;i<800;i++){
	    	for (int j=0;j<600;j++){
	    		if (enem.matriz[i][j]==2){
	    			g.drawLine(i, j, i, j);
	    		}
	    	}
	    }
        repaint();
	}

}
