package colores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;


public class caida implements ActionListener{

	public static int posx,posy,red,green,blue,col,conti,x1,x2,x3,espera;
	public Timer tim;
	brocha brea;
	public static int a,b,c,d,az,ab,as,ad,fin,puedeCaer;
	public static ArrayList <Integer> posix,posiy,colr,colg,colazul,esperas,cae;
	public caida() {//definimos el primer cuadro
		brea=new brocha();
		posix=new ArrayList <Integer>();
		posiy=new ArrayList <Integer>();
		colr=new ArrayList <Integer>();
		colazul=new ArrayList <Integer>();
		colg=new ArrayList <Integer>();
		cae=new ArrayList <Integer>();
		esperas=new ArrayList <Integer>();
		posx=(int)(Math.random()*790+5);
        posy=-10;
        espera=(int)(Math.random()*1000+1);
        red=0;
        blue=0;
        green=0;
        col=(int)(Math.random()*3+1);
        if (col==1){
        	red=255;
        }
        if (col==2){
        	blue=255;
        }
        if (col==3){
        	green=255;
        }
        posix.add(0,posx);
        cae.add(0,0);
        posiy.add(0,posy);
        colr.add(0,red);
        colazul.add(0,blue);
        colg.add(0,green);
        esperas.add(0,espera);
        tim=new Timer(10,this);
        tim.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		for (int h=0;h<posiy.size();h++){
			if (cae.get(h)==1){
			posy=posiy.get(h);
			posy++;
			if (posy==600){
				posy=0;
			}
			posiy.remove(h);
			posiy.add(h,posy);
			}
		}
		
	}
	
	//esto genera otros dos cuadraditos por cada uno eliminado
	public static void genera(int eliminar){
		posix.remove(eliminar);
        posiy.remove(eliminar);
        colr.remove(eliminar);
        colg.remove(eliminar);
        colazul.remove(eliminar);
		for (int a=0;a<2;a++){
			espera=(int)(Math.random()*1000+1);
			fin=posix.size();
			posx=(int)(Math.random()*800+1);
	        posy=-10;
	        red=0;
	        blue=0;
	        green=0;
	        col=(int)(Math.random()*3+1);
	        if (col==1){
	        	red=255;
	        }
	        if (col==2){
	        	blue=255;
	        }
	        if (col==3){
	        	green=255;
	        }
	        if (a==0){
	        posix.add(eliminar,posx);
	        posiy.add(eliminar,posy);
	        colr.add(eliminar,red);
	        colazul.add(eliminar,blue);
	        colg.add(eliminar,green);
	        esperas.add(eliminar,espera);
	        cae.add(eliminar,0);
	        }
	        if (a==1){
	        	posix.add(fin,posx);
		        posiy.add(fin,posy);
		        colr.add(fin,red);
		        colazul.add(fin,blue);
		        colg.add(fin,green);
		        esperas.add(fin,espera);
		        cae.add(fin,0);
	        }
        }

	}
	
	
}