package bacterias;


public class jugador {
;
	public static int posx,posy,tamaño,incrementox,incrementoy;
	int matriz[][];
	public jugador() {
		posx=50;
		incrementox=0;
		incrementoy=0;
		tamaño=50;
		posy=250;;
	}

	public void muevete(int incrementoy,int incrementox){
		if (incrementoy==1){
			posy=posy+((100-tamaño)*10/(95)+2);
		}
		if (incrementoy==-1){
			posy=posy-((100-tamaño)*10/(95)+2);
		}
		if (incrementox==-1){
			posx=posx-((100-tamaño)*10/(95)+2);
		}
		if (incrementox==1){
			posx=posx+((100-tamaño)*10/(95)+2);
		}
		if (posx<=0){
			posx=799;
		}
		if (posx>=800){
			posx=0;
		}
		if (posy<=0){
			posy=600;
		}
		if (posy>=632){
			posy=0;
		}
		
		
	}
	public static int posx(){
		return posx;
	}
	public static int posy(){
		return posy;
	}
	public static int tam(){
		return tamaño;
	}
	public static void aumenta(int aumento){
		tamaño=tamaño+aumento;
		if (tamaño>=100){ //para que se pueda seguir moviendo debido al codigo del movimiento respecto al tamaño...
			tamaño=97;
		}
	}

}