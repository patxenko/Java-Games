package missile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

public class disparo implements ActionListener{

	Timer mitimer;
	public static int posx1,posy1,posx2,posy2,posx3,posy3,disparo,meta1,meta2,meta3,numDisparos,px,py,disparo1;
	public static int disparo2,disparo3,contDisparos,posy,redibujados,ancho,explosion,ex,ey;;
	ArrayList <Integer> posicionesx,posicionesy,metas;
	public disparo() {
		explosion=0;
		contDisparos=0;
		posicionesx=new ArrayList <Integer> ();
		posicionesy=new ArrayList <Integer> ();
		metas=new ArrayList <Integer> ();
		numDisparos=0;
		posx1=0;
		posy1=550;
		posx2=0;
		posy2=550;
		posx3=0;
		posy3=550;
		disparo1=0;
		disparo2=0;
		disparo3=0;
		mitimer=new Timer(5,this);
		mitimer.start();
	}
	
	//primera fase acercamiento
	public void acercamiento(int x, int y){

		if (numDisparos<3){
			posx1=x;
			meta1=y;
			posicionesx.add(posx1);
			metas.add(meta1);
			posicionesy.add(550);
			numDisparos++;
		}

	}
	public void actionPerformed(ActionEvent e) {
		for (int h=0;h<posicionesx.size();h++){
			posy=posicionesy.get(h);
			posy=posy-5;
			posicionesy.remove(h);
			posicionesy.add(h,posy);
			if (posy==metas.get(h)){
				explosion(posicionesx.get(h),posy);
				posicionesy.remove(h);
				posicionesx.remove(h);
				metas.remove(h);
				numDisparos--;
			}
		}
	}
	
	public void explosion(int a, int b){
		redibujados=10;
		ancho=100;
		explosion=1;
		//System.out.println("BOOM!");
		ex=a;
		ey=b;
	}

}
