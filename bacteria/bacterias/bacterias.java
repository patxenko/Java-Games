package bacterias;

import java.awt.Rectangle;
import javax.swing.Timer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bacterias implements ActionListener {

	private Timer mitimer;
	public int co,diferenciax,diferenciay,puntox,puntoy,diri,xfinal,yfinal,fin,tam;
	public int tamañin1,tamañin2,tamañoT;
	public static int posyfinal,posxfinal,dir,col,tamaño,posy,posx;
	int matriz[][];
	public static ArrayList<Integer> posicionesx,posicionesy,tamaños,colores,posicionxfinal,posicionyfinal,direccion,llega,color;
	public ArrayList<Rectangle> Rectbacterias;
	public Rectangle rb,rb2;
	public bacterias() {
		posicionesx=new ArrayList<Integer>();
		Rectbacterias=new ArrayList<Rectangle>();
		color=new ArrayList<Integer>();
		posicionesy=new ArrayList<Integer>();
		tamaños=new ArrayList<Integer>();
		posicionxfinal=new ArrayList<Integer>();
		direccion=new ArrayList<Integer>();
		posicionyfinal=new ArrayList<Integer>();
		llega=new ArrayList<Integer>();
		colores=new ArrayList();	
		mitimer=new Timer(30,this);
		mitimer.start();
		puntox=0;
		puntoy=0;
		for (int i=0;i<20;i++){
			//direccion guarda si se mueve dcha izda arriba o abajo.
			dir=(int)(Math.random()*4+1);
			direccion.add(i,dir);
			//estas son las coordenadas del punto destino
			posxfinal=(int)(Math.random()*800);
			posicionxfinal.add(i,posxfinal);
			posyfinal=(int)(Math.random()*600);
			posicionyfinal.add(i,posyfinal);
			//estas son las posiciones del de inicio
			posx=(int)(Math.random()*500+50);
			posicionesx.add(i,posx);
			posy=(int)(Math.random()*400+1);
			posicionesy.add(i,posy);
			//aqui guardamos los tamaños
			tamaño=(int)(Math.random()*50+1);
			tamaños.add(i,tamaño);
			//aqui guardamos si ha llegado al destino o no
			llega.add(i,0);
			//aqui guardamos el color
			col=(int)(Math.random()*3+1);
			color.add(i,col);
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		for (int g=0;g<20;g++){
			tam=(int)tamaños.get(g);
			fin=(int)llega.get(g);
			diri=(int)direccion.get(g);
			puntox=(int)posicionesx.get(g);
			puntoy=(int)posicionesy.get(g);
			xfinal=(int)posicionxfinal.get(g);
			yfinal=(int)posicionyfinal.get(g);
			
			//aqui determinamos los bordes de la pantalla
			if (puntox<=-10){
				puntox=950;
				posicionesx.remove(g);
				posicionesx.add(g,puntox);
			}
			if (puntox>=1000){
				puntox=0;
				posicionesx.remove(g);
				posicionesx.add(g,puntox);
			}
			if (puntoy<=-20){
				puntoy=900;
				posicionesy.remove(g);
				posicionesy.add(g,puntoy);
			}
			if (puntoy>=950){
				puntoy=0;
				posicionesy.remove(g);
				posicionesy.add(g,puntoy);
			}
			//aqui determinamos el movimiento de las bacterias
			if (diri==1){ //se mueve hacia arriba
				puntoy--;
				posicionesy.remove(g);
				posicionesy.add(g,puntoy);
			}
			if (diri==2){ //se mueve hacia abajo
				puntoy++;
				posicionesy.remove(g);
				posicionesy.add(g,puntoy);	
			}
			if (diri==3){//se mueve hacia la derecha
				puntox++;
				posicionesx.remove(g);
				posicionesx.add(g,puntox);
			}
			if (diri==4){//se mueve hacia la izquierda
				puntox--;
				posicionesx.remove(g);
				posicionesx.add(g,puntox);
			}
			//aqui si ha llegado al destino y el cambio de movimiento
			if ((diri==1 && puntoy==yfinal) || diri==2 && puntoy==yfinal){
				dir=diri+2;;
				direccion.remove(g);
				direccion.add(g,dir);
				fin++;
				llega.remove(g);
				llega.add(g,fin);
			}
			if ((diri==3 && puntox==xfinal) || diri==4 && puntox==xfinal){
				dir=diri-2;
				direccion.remove(g);
				direccion.add(g,dir);
				fin++;
				llega.remove(g);
				llega.add(g,fin);
			}
			//aqui determinamos las nuevas coordenadas del destino
			if (fin==2){
				nuevas(g);
			}
		}
	}
	
	public void nuevas(int num){
		posxfinal=(int)(Math.random()*800);
		posicionxfinal.remove(num);
		posicionxfinal.add(num,posxfinal);
		posyfinal=(int)(Math.random()*600);
		posicionyfinal.remove(num);
		posicionyfinal.add(num,posyfinal);
	}
	

	//public void paint(Graphics g){
		//super.paint(g);
		
		//colisiona();
		//for (int j=0;j<20;j++){
		//co=color.get(j);
		//if (co==1){
		//	g.setColor(Color.red);
		//}
		//if (co==2){
		//	g.setColor(Color.blue);
		//}
		//if (co==3){
		//	g.setColor(Color.black);
		//}
	    
		//g.fillOval((int)posicionesx.get(j),(int)posicionesy.get(j),(int)tamaños.get(j),(int)tamaños.get(j));
		//}
		//repaint();
	//}
	
	//aqui calculamos si hay colision entre bacterias
	public void colisiona(){
		//generamos los rectangulos
		for (int j=0;j<20;j++){
			rb=new Rectangle(posicionesx.get(j),posicionesy.get(j),tamaños.get(j),tamaños.get(j));
			Rectbacterias.add(j,rb);
			//vemos si colisiona con otro distinto
			for (int i=0;i<20;i++){
				if (i!=j){
					rb2=new Rectangle(posicionesx.get(i),posicionesy.get(i),tamaños.get(i),tamaños.get(i));
					if (rb.intersects(rb2)){
						come(j,i);
					}
				}
				else{
					
				}
				
			}
		}
	}
	
	//aqui se realiza la comida, y la generacion de la nueva bacteria comida.
	public void come(int numeroA,int numeroB){
		//numeroA a colisionado con numeroB
		if (tamaños.get(numeroA)>tamaños.get(numeroB)){
			//aumenta el tamaño la primera
			tamañin1=(tamaños.get(numeroB))/4;
			tamañin2=tamaños.get(numeroA);
			tamañoT=tamañin1+tamañin2;
			if (tamañoT>=100){ //tamaño maximo de 100
			tamaños.remove(numeroA);
			tamaños.add(numeroA,100);
			}
			if (tamañoT<100){
				tamaños.remove(numeroA);
				tamaños.add(numeroA,tamañoT);	
			}
			generaNueva(numeroB);
			
		}
		//NO HACE FALTA HACER EN EL CASO CONTRARIO, YA QUE EL BULCE QUE DETECTA COLISIONES LO DETECTARA
	}
	
	//dvolvemos los valores de las bacterias para la clase closisionJB
	public static ArrayList<Integer> xb(){
		return posicionesx;
	}
	public static ArrayList<Integer> yb(){
		return posicionesy;
	}
	public static ArrayList<Integer> tb(){
		return tamaños;
	}
	public static ArrayList<Integer> cb(){
		return colores;
	}
	public static void generaNueva(int numerico){
		//SE VUELVE A GENERAR LA BACTERIA COMIDA
		dir=(int)(Math.random()*4+1);
		direccion.remove(numerico);
		direccion.add(numerico,dir);
		//estas son las coordenadas del punto destino
		posxfinal=(int)(Math.random()*800);
		posicionxfinal.remove(numerico);
		posicionxfinal.add(numerico,posxfinal);
		posyfinal=(int)(Math.random()*600);
		posicionyfinal.remove(numerico);
		posicionyfinal.add(numerico,posyfinal);
		//estas son las posiciones del de inicio
		posx=(int)(Math.random()*500+50);
		posicionesx.remove(numerico);
		posicionesx.add(numerico,posx);
		posy=(int)(Math.random()*400+1);
		posicionesy.remove(numerico);
		posicionesy.add(numerico,posy);
		//aqui guardamos los tamaños
		tamaño=(int)(Math.random()*50+1);
		tamaños.remove(numerico);
		tamaños.add(numerico,tamaño);
		//aqui guardamos si ha llegado al destino o no
		llega.remove(numerico);
		llega.add(numerico,0);
		//aqui guardamos el color
		col=(int)(Math.random()*3+1);
		color.remove(numerico); 
		color.add(numerico,col);
	}
	
	public static ArrayList posxbac(){
		return posicionesx;
	}
	public static ArrayList posybac(){
		return posicionesy;
	}
	public static ArrayList tambac(){
		return tamaños;
	}

}