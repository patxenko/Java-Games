package minipong;
import java.awt.Rectangle;

public class jugador1 {
	
	Rectangle rectangulo;
	int posx,posy,anchura,altura;
    int direccion;
    
	public  jugador1() {
		direccion=0;
		posx=0;
		posy=200;
		anchura=20;
		altura=80;;
		rectangulo = new Rectangle(posx,posy,anchura,altura);
		
	}
	public int getposx(){
		return posx;
	}
	public int getposy(){
		return posy;
	}
	public int anchura(){
		return anchura;
	}
	public int altura(){
		return altura;
	}
	
	void teclaPulsada(int ent){
		if (ent==1){
			direccion=-1; //hacia arriba
		}
		if (ent==2){
			direccion=1; //hacia abajo
		}
	}
	public void muevete(){
		if (posy>=0 && posy+altura<=400){
			posy=posy+10*direccion;
			direccion=0;
		}
		if (posy<0){
			posy=0;
		}
		if (posy+altura>400){
			posy=400-altura;
		}
	}
}
