package bacterias;
import java.util.ArrayList;
import java.awt.Rectangle;
//ESTA CLASE SE ENCARGA DE LAS COLISIONES ENTRE EL JUGADOR Y LAS BACTERIAS

public class closisionJB {

	static jugador jugad;
	static bacterias b;
	static int finalizado;
	static int posicionxJ,posicionyJ,tamañoJ,tamañobacteria,aum;
	public static Rectangle rj,rb;
	static ArrayList <Integer> posxB,posyB,tamB,colB;
	public closisionJB() {
		jugad=new jugador();
		b=new bacterias();
		finalizado=0;
		posxB=new ArrayList<Integer>();
		posyB=new ArrayList<Integer>();
		tamB=new ArrayList<Integer>();
		colB=new ArrayList<Integer>();
		posxB=bacterias.xb();
		posyB=bacterias.yb();
		tamB=bacterias.tb();
		colB=bacterias.cb();
		posicionxJ=jugador.posx();
		posicionyJ=jugador.posy();
		tamañoJ=jugador.tam();
	}
	
	public static void colJB(){
		rj=new Rectangle(jugador.posx(),jugador.posy(),jugador.tam(),jugador.tam());
		for (int i=0;i<20;i++){
			rb=new Rectangle(bacterias.posicionesx.get(i),bacterias.posicionesy.get(i),bacterias.tamaños.get(i),bacterias.tamaños.get(i));
			if (rj.intersects(rb)){
				//1 es rojo y 2 azul
				if (bacterias.color.get(i)==1){ //la bacteria es roja y se come al jugador
					finalizado=1;
					System.out.println("GAME OVER");
				}
				if (bacterias.color.get(i)==2){ //la bacteria es azul y el jugador se la come
					//llama al metodo de aumentar jugador y de generar nueva bacteria
					tamañobacteria=bacterias.tamaños.get(i);
					aum=tamañobacteria/4;
					jugador.aumenta(aum);
					bacterias.generaNueva(i);
				}
			}
		}
	}


}