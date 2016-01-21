package missile;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class asteroides implements ActionListener{

	public static int posix,posiy,tamaño,vida,nivel;
	public static ArrayList <Integer> posisx,posisy,vidas;
	Timer ntimer;
	
	public asteroides() {
		nivel=1;
		posisx=new ArrayList <Integer>();
		posisy=new ArrayList <Integer>();
		vidas=new ArrayList <Integer>();
		posix=(int)(Math.random()*750+25);
		posiy=(int)(Math.random()*150+50)*(-1);
		vida=5;
		posisx.add(0,posix);
		posisy.add(0,posiy);
		vidas.add(0,vida);
		ntimer=new Timer(20,this);
		ntimer.start();
		
	}
	public void actionPerformed(ActionEvent e){
		for (int g=0;g<posisx.size();g++)
		{
		posiy=posisy.get(g);
		posiy=posiy+2;
		posisy.set(g,posiy);
		//posisy.remove(g);
		//posisy.add(g,posiy);
		if (posiy>=500){
			vida=vidas.get(g);
			generaNuevoSuelo(g,vida);
		}
		}
		
	}
	
	public void generaNuevoSuelo(int valor,int vi){
		posix=(int)(Math.random()*750+25);
		posiy=(int)(Math.random()*150+50)*(-1);;
		//vidas.remove(valor);
		//vidas.add(valor,vi);
		vidas.set(valor,vi);
		//posisx.remove(valor);
		//posisx.add(valor,posix);
		posisx.set(valor,posix);
		//posisy.remove(valor);
		//posisy.add(valor,posiy);
		posisy.set(valor,posiy);
	}
	
	public void generaNuevoMuerte(int num){
		posix=(int)(Math.random()*750+25);
		posiy=(int)(Math.random()*150+50)*(-1);
		vida=vidas.get(num);
		vida--;
		if (vida==0){
			//el asteroide ya no se genera;
			posisx.remove(num);
			posisy.remove(num);
			vidas.remove(num);
			if (posisx.size()==0){
				nivel++;
				pasoDeNivel(nivel);
			}
		}
		if (vida>0){
		vidas.remove(num);
		vidas.add(num,vida);
		posisx.remove(num);
		posisx.add(num,posix);
		posisy.remove(num);
		posisy.add(num,posiy);
		}
	}
	
	public void pasoDeNivel(int niv){
		for (int u=0;u<niv;u++){
			posix=(int)(Math.random()*750+25);
			posiy=(int)(Math.random()*150+50)*(-1);
			vida=5;
			posisx.add(u,posix);
			posisy.add(u,posiy);
			vidas.add(u,vida);
		}
	}



}
