package gusano;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class enemigo implements ActionListener {

	public int posx,posy,incrementoy,incrementox,numPos;
	public Timer mitimer;
	int matriz[][];
	public enemigo() {
		matriz=new int[800][600];
		mitimer=new Timer(10,this);
		incrementox=0;
		incrementoy=0;
		posx=750;
		posy=400;
		numPos=0;
		mitimer.start();
	}
	public int posx(){
		return posx;
	}
	public int numPos(){
		return numPos;
	}
	
	public int posy(){
		return posy;
	}
	public int[][] matriz(){
		return matriz;
	}
	
	public void teclaPulsada(int e){
		if (e==1){
			incrementoy=-1;
			incrementox=0;
		}
		if (e==2){
			incrementoy=1;
			incrementox=0;
		}
		if (e==3){
			incrementox=1;
			incrementoy=0;
		}
		if (e==4){
			incrementox=-1;
			incrementoy=0;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (incrementoy==-1){
			numPos++;
			posy=posy+incrementoy;
		}
		if (incrementoy==1){
			numPos++;
			posy=posy+incrementoy;
		}
		if (incrementox==1){
			numPos++;
			posx=posx+incrementox;
		}
		if (incrementox==-1){
			numPos++;
			posx=posx+incrementox;	
		}
		//definimos que el jugador no se salga de los bordes
		if (posy>=600){
			posy=600;
		}
		if (posy<=0){
			posy=0;
		}
		if (posx>=800){
			posx=800;
		}
		if (posx<=0){
			posx=0;
		}
		//sustituimos las posiciones de la matriz por unos
		matriz[posx][posy]=2;
		
	}


}
