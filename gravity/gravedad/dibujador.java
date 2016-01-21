package gravedad;

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
import java.lang.Math; 
import java.util.ArrayList;


public class dibujador extends JPanel implements ActionListener{

	nave navecilla;
	planetas planets;
	public int disparo,verde,rojo,azul,b1,b2,b3;
	private Timer mitimer;
	public static int xnave,nivel,dif,grados,a,b,c,li,gradios;
	double radianes,coseno,seno,rad,valorx,valory,xestrella,yestrella,difx,dify,radio,tamaño;
	estrella star;
	Timer timer;
	Rectangle pelota,jugador1,jugador2;  //definimos los rectangulos para usar el metodo de chocar
	energia energy;
	Rectangle nave,estrella,planeti;
    ArrayList <Integer> posicionsx, posicionsy,tamañs, rads,gradillos,lololo,blu,red,gre,borde1,borde2,borde3;
    ArrayList <Object> planetasMov;
	public dibujador() {
		planets=new planetas();
		mitimer=new Timer(30,this);
		disparo=0;
		nivel=0;
		planetasMov=new ArrayList();
		lololo=new ArrayList();
		blu=new ArrayList();
		red=new ArrayList();
		gre=new ArrayList();
		borde1=new ArrayList();
		borde2=new ArrayList();
		borde3=new ArrayList();
		posicionsx=new ArrayList();
		posicionsy=new ArrayList();
		tamañs=new ArrayList();
		rads=new ArrayList();
		gradillos=new ArrayList();
		posicionsx=planets.posicionesx();
		posicionsy=planets.posicionesy();
		tamañs=planets.tamaños();
		rads=planets.radios();
		red=planets.rojo();
		gre=planets.verde();
		blu=planets.azul();
		borde1=planets.bordR();
		borde2=planets.bordG();
		borde3=planets.bordB();
		star=new estrella();
		xestrella=star.posx();
		yestrella=star.posy();
		energy=new energia();
		navecilla=new nave();
		addKeyListener(new TAdapter());
		setFocusable(true);
		//inicializar timer
		xnave=navecilla.getposx();
		mitimer.start();
	}
	
	public ArrayList gradillos(){
		for(int a=0;a<nivel;a++){
		gradios=(int)(Math.random()*360);
		gradillos.add(a,gradios);
		}
		return gradillos;
	}
	
	
	
	
	public void paint(Graphics g){
		
	    super.paint(g);
	    if (xnave>=800){
			nivel++;
			xnave=10;
	    	energy.iniRelleno();
	    	disparo=0;
	    	planets.generaPlaneta(nivel);
	    	mitimer=new Timer(30,this);
	    	gradillos();
		}
	    
	    navecilla.muevete();
	    //clase rectangle para detectar colisiones.
	    nave=new Rectangle(xnave,navecilla.getposy(),navecilla.anchura(),navecilla.altura());
	    estrella=new Rectangle((int)star.posx(),(int)star.posy(), (int)star.diam(),(int) star.diam());
	    if (nave.intersects(estrella)){
	    	xnave=10;
	    	energy.iniRelleno();
	    	disparo=0;
	    	
	    }
	    
	    g.setColor(Color.red);
	    g.fillRect(xnave,navecilla.getposy(),navecilla.anchura(),navecilla.altura()); 
	    g.setColor(Color.orange);
	    g.drawRect(energy.x(),energy.y(),energy.anchura(),energy.altura());
	    g.fillRect(energy.x(),energy.y(), energy.relleno(), energy.altura());
	    g.setColor(Color.blue);
	    //posx y posy definen el punto de arriba a la izquierda del circulo.
	    g.fillOval((int)star.posx(),(int)star.posy(), (int)star.diam(),(int) star.diam());
	    
	    
	    Color mycolor;
	    Color borde;
	    //dibujamos los planetas
        //a=(int)posicionsx.get(0);
        //b=(int)posicionsy.get(0);
        //c=(int)tamañs.get(0);
	    if (nivel>0){
	    	for (int x=0;x<nivel;x++){
	    		planeti=new Rectangle((int)posicionsx.get(x),(int)posicionsy.get(x),(int)tamañs.get(x),(int)tamañs.get(x));
	    		if (nave.intersects(planeti)){
	    	    	xnave=10;
	    	    	energy.iniRelleno();
	    	    	disparo=0;
	    	    }
	    		verde=gre.get(x);
	    		rojo=red.get(x);
	    		azul=blu.get(x);
	    		b1=borde1.get(x);
	    		b2=borde2.get(x);
	    		b3=borde3.get(x);
	    	    borde=new Color(b1,b2,b3);
	    		g.setColor(borde);
	    		g.drawOval((int)posicionsx.get(x),(int)posicionsy.get(x),(int)tamañs.get(x),(int)tamañs.get(x));
	    		mycolor=new Color(rojo,verde,azul);
	    		g.setColor(mycolor);
	    		g.fillOval((int)posicionsx.get(x),(int)posicionsy.get(x),(int)tamañs.get(x),(int)tamañs.get(x));
	    	}
	    }
	    repaint();
	}
	
	
	
	
	public int relle(){
		return energy.relleno();
	}
	
	private class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode()==KeyEvent.VK_UP){
				navecilla.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				navecilla.teclaPulsada(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				energy.teclaPulsada(1);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				energy.teclaPulsada(2);
			}
			if (e.getKeyCode()==KeyEvent.VK_SPACE){
				disparo=1;
			}
		}
	}
	//aqui definimos el movimiento de la nave
			public void actionPerformed(ActionEvent e) {
				if (nivel>0){
					for (int f=0;f<nivel;f++){
						grados=gradillos.get(f);
						radianes=(grados*Math.PI)/180;
					    coseno=Math.cos(radianes);
					    seno=Math.sin(radianes);
					    if (f%2!=0){
					    valorx=(star.posx()+star.diam()/2)+rads.get(f)*coseno;
					    valory=(star.posy()+star.diam()/2)+rads.get(f)*seno;
					    }
					    if (f%2==0){
					    	//valorx=(star.posx()-star.diam()/2)-rads.get(f)*coseno;
						    //valory=(star.posy()-star.diam()/2)-rads.get(f)*seno;
					    	valorx=(star.posx()+star.diam()/4)+rads.get(f)*seno;
						    valory=(star.posy()+star.diam()/4)+rads.get(f)*coseno;
					    }
					    posicionsx.remove(f);
					    posicionsy.remove(f);
					    posicionsx.add(f,(int)valorx);
					    posicionsy.add(f,(int)valory);
					    grados++;
					    gradillos.remove(f);
					    gradillos.add(f,grados);
					}
					
				}
					
				
				
				
				if (disparo==1){
					xnave=xnave+(energy.relleno/5);
				}
				
			}
			
		


	
}