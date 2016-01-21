package gravedad;

import java.awt.Rectangle;

public class nave{
	Rectangle rectangulo;
	energia energy;
	int posx,posy,anchura,altura,relle;
    int direccion,disparo;
	public nave() {
		energy=new energia();
			direccion=0;
			disparo=0;
			posx=10;
			posy=200;
			anchura=50;
			altura=10;;
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
				posy=posy+5*direccion;
				direccion=0;
			}
			if (posy<0){
				posy=0;
			}
			if (posy+altura>=400){
				posy=400-altura;
			}
		}
		
	    

}