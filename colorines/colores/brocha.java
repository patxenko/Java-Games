package colores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

public class brocha implements ActionListener{

	cuadro cuadr;
	public static int radio1,radio2,radio3,centrox1,centroy1,centrox2,centrox3,centroy2,centroy3,pixelx,pixely;
	public static int lon1,lon2,lon3,dif,r,g,b;
	public int si,contador,pintar;
	Timer mitimer;
	public static ArrayList <Integer> pixels,rojo,verde,azul;
	public brocha() {
		r=0;
		g=0;
		b=0;
		cuadr=new cuadro();
		contador=0;
		pintar=0;
		si=0;
		pixels=new ArrayList <Integer>();
		rojo=new ArrayList <Integer>();
		verde=new ArrayList <Integer>();
		azul=new ArrayList <Integer>();
        radio1=5;
        radio2=10;
        radio3=20;
        centrox1=400;
        centroy1=300;
        pixely=300+5;
        pixelx=0;
        centrox2=centrox1-5;
        centroy2=centroy1-5;
        centrox3=centrox2-10;
        centroy3=centroy2-10;
        lon1=10;
        lon2=20;
        lon3=40;
        mitimer=new Timer(5,this);
        mitimer.start();
        }
	
	public void mover(int num){
		if (num==1){ //derecha
			si=1;

		}
		if (num==2){
			si=2;

		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (si==1){
			centrox1++;
			centroy1=300;
	        centrox2=centrox1-5;
	        centroy2=centroy1-5;
	        centrox3=centrox2-10;
	        centroy3=centroy2-10;
		}
		if (si==2){
			centrox1--;
			centroy1=300;
	        centrox2=centrox1-5;
	        centroy2=centroy1-5;
	        centrox3=centrox2-10;
	        centroy3=centroy2-10;
		}
		if (centrox1<=0){
			centrox1=800;
		}
		if (centrox1>800){
			centrox1=1;
		}
		if (pintar==1){
			r=cuadro.rojo;
			g=cuadro.verde;
			b=cuadro.azul;
			pixelx=centrox1+5;
			if (contador<=100){
				rojo.add(contador,r);
				verde.add(contador,g);
				azul.add(contador,b);
				pixels.add(contador,pixelx);
			}
            if (contador>100){
            	pixels.remove(100);
            	pixels.add(0,pixelx);
            	rojo.remove(100);
            	verde.remove(100);
            	azul.remove(100);
            	rojo.add(0,r);
				verde.add(0,g);
				azul.add(0,b);
            }
			contador++;
		}
	}
	
	public void pintar(){
		pintar=1;
	}
	public void nopintar(){
		pintar=0;
	}



}
