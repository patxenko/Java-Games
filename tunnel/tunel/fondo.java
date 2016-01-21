package tunel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

public class fondo extends JPanel implements ActionListener {

	public static ArrayList <Integer> anchuras,alturas,posicionesx,posicionesy;
	int altura,anchura,posx,posy,altura2,anchura2,posx2,posy2,anchuratotal,i,loqsea,a,anchurilla,fin,numerillo;
	public int suma,cont,ale;
	private Timer mitimer;
	public fondo() {
		cont=0;
		suma=400;
		numerillo=0;
		anchuras=new ArrayList <Integer>();
		alturas=new ArrayList <Integer>();
		posicionesx=new ArrayList <Integer>();
		posicionesy=new ArrayList <Integer>();

		posicionesx.add(0,0);
		posicionesy.add(0,300);
		anchuras.add(0,400);
		alturas.add(0,50);
		
		mitimer=new Timer(20,this);
		mitimer.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		for (int j=0;j<anchuras.size();j++){
			posx=posicionesx.get(j);
			anchura=anchuras.get(j);
			if (anchura+posx<=0){
				posicionesx.remove(j);
				posicionesy.remove(j);
				alturas.remove(j);
				anchuras.remove(j);
				numerillo--;
			}
            if (anchura+posx>0){
				posx--;
				posicionesx.remove(j);
				posicionesx.add(j,posx);
			}
			
		}
		if (numerillo<5){
			fin=posicionesx.size();
			posx2=posicionesx.get(fin-1)+anchuras.get(fin-1);
			ale=(int)(Math.random()*2+1);
			if (ale==1){
				posy2=posicionesy.get(fin-1)+10;
			}
			if (ale==2){
				posy2=posicionesy.get(fin-1)-20;
			}
			anchura2=(int)(Math.random()*300+100);
			altura2=(int)(Math.random()*50+50);
			cont++;
			posicionesx.add(fin,posx2);
			anchuras.add(fin,anchura2);
			posicionesy.add(fin,posy2);
			alturas.add(fin,altura2);
			numerillo++;
		}
	}
	

	

}
