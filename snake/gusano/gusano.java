package gusano;
import java.awt.Graphics;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
//esta clase se encarga de dibujar el gusano
import javax.swing.JPanel;

public class gusano extends JPanel implements ActionListener {
	private int largo,x,y;
	private int ancho,posicionx,posiciony,pixelx,pixely,interseccionx,intersecciony,valortomadox,valortomadoy;
	private int teclaPulsada,ypulsado,y2pulsado,xpulsado,x2pulsado,x3pulsado,x4pulsado,findejuego;
	ArrayList snake,valoresx,valoresy;
	private Timer mitimer;
	Rectangle pixelNuevo, comida;
    esfera s;
    int posx,posy;
	public gusano() {
		//introducimos las dimensiones del gusano
		s=new esfera();
		posx=s.getX();
		posy=s.getY();
	    findejuego=0;
		snake=new ArrayList();
		valoresx=new ArrayList();
		valoresy=new ArrayList();
		largo=40;
		ancho=1;
		x=400;
		y=200;
		posicionx=400;
		teclaPulsada=0;
		posiciony=200;
		pixelx=0;
	    pixely=0;
	    ypulsado=1;
	    xpulsado=1;
	    x3pulsado=1;
	    x4pulsado=0;
	    y2pulsado=0;
	    x2pulsado=0;
	    for (int i=0;i<largo;i++){
			valoresx.add(i,x-i);
		}
	    for (int i=0;i<largo;i++){
			valoresy.add(i,y);
		}
		for (int i=0;i<largo;i++){
			snake.add(i,"1");
		}
		addKeyListener(new TAdapter());
		setFocusable(true);
		mitimer=new Timer(5,this);
		mitimer.start();
		
	}
	
	
	 public void paint(Graphics g){
		    super.paint(g);
		    //vemos a ver si el primer pixel intersecciona en algun punto con la serpiente.
		    interseccionx=(int)valoresx.get(0);
		    intersecciony=(int)valoresy.get(0);
		    for (int j=1;j<largo;j++){
		    	valortomadox=(int)valoresx.get(j);
		    	valortomadoy=(int)valoresy.get(j);
		    	if (valortomadox==interseccionx && valortomadoy==intersecciony){
		    		findejuego=1;
		    	}
		    }
		    if (findejuego==1){
		    	g.drawString("GAME OVER MOTHERFUCKER", 300, 200);
		    }
		    
		    else{ 
		    pixelx=(int)valoresx.get(0);
		    pixely=(int)valoresy.get(0);
		    pixelNuevo=new Rectangle(pixelx,pixely,1,1);
		    comida=new Rectangle(posx,posy,10,10);
		    if (pixelNuevo.intersects(comida)){
		    	aumenta();
		    	s.creacionEsfera();
		    	posx=s.getX();
				posy=s.getY();
		    }
		    for (int i=0;i<snake.size();i++){
		    	    posicionx=(int)valoresx.get(i);
		    	    posiciony=(int)valoresy.get(i);
		    	    g.setColor(Color.red);
			    	g.drawLine(posicionx,posiciony, posicionx,posiciony);
			}
		    g.setColor(Color.green);
		    g.fillOval(posx,posy,10,10);
		    repaint();
		    }
		    
		}
	
   

	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_UP){
				teclaPulsada=1;
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				teclaPulsada=2;
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				teclaPulsada=3;
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				teclaPulsada=4;
			}
		}
	}
	 public void actionPerformed(ActionEvent e) {  //ocurre en funcion del temporizador
		 //si queremos ir hacia arriba el ultimo pixel debera sustituir el primero y subir 
		 //uno y el resto toman la posicion del anterior
		 
		 if (teclaPulsada==1){  
			ypulsado=1;
			valoresx.add(0,(int)valoresx.get(0)); //se mantienen
			//el margen de subida es y=0
			if ((int)valoresy.get(0)-1==0){
				valoresy.add(0,400);
			}
			else{
				valoresy.add(0,(int)valoresy.get(0)-1); //sube uno cada iteracion de reloj
			}
			
			}
		 
		 //si queremos ir hacia abajo el ultimo pixel sustituye al primero y baja uno
		 //el resto se mantienen iwal
         if (teclaPulsada==2){
        	ypulsado=1;
        	valoresx.add(0,(int)valoresx.get(0)); //se mantienen
        	if ((int)valoresy.get(0)+1==400){
				valoresy.add(0,0);
			}
        	else{
 			valoresy.add(0,(int)valoresy.get(0)+1); //baja uno cada iteracion de reloj
        	}
 			
			
         }
		 
			if (teclaPulsada==3){  //hacia la derecha
			x3pulsado=1;	
			if ((int)valoresx.get(0)+1==800){
				valoresx.add(0,0);
			}
			else{
				valoresx.add(0,(int)valoresx.get(0)+1); //se suma la x en 1
			}
	 		valoresy.add(0,(int)valoresy.get(0));	//las ys se van manteniendo
				
			}
			
		    if (teclaPulsada==4){ //hacia la izquierda
				
				x4pulsado=1; 
				if ((int)valoresx.get(0)-1==0){
					valoresx.add(0,800);
				}
				else{
				valoresx.add(0,(int)valoresx.get(0)-1); //se resta la x en 1
				}
		 		valoresy.add(0,(int)valoresy.get(0)); //las ys se van sucediendo
				
			}
		 
	 }
	 public ArrayList getSnake(){  
		 return snake;
	 }
	 public ArrayList getValoresx(){ 
		 return valoresx;
	 }
	 public ArrayList getValoresy(){  
		 return valoresy;
	 }
	 public void aumenta(){
		 largo=largo+10;
		 for (int i=largo-10-1;i<largo;i++){
				valoresx.add(i,valoresx.get(i));
			}
		    for (int i=largo-10-1;i<largo;i++){
				valoresy.add(i,valoresy.get(i));
			}
			for (int i=largo-10-1;i<largo;i++){
				snake.add(i,"1");
			}
	 }

}