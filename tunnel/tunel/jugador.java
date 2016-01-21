package tunel;

public class jugador {

	public static int alto,ancho,posx,posy,fin;
	public jugador() {
		fin=0;
		alto=6;
		ancho=20;
		posx=50;
		posy=300;
	}
	
	public void muevete(int valor){
		if(fin==0){
		if (valor==1){
			posy=posy-4;
		}
		if (valor==2){
			posy=posy+4;
		}
		if (valor==3){
			posx=posx+4;
		}
		if (valor==4){
			posx=posx-4;
		}
		}
		
	}
	public void findejuego(){
		fin=1;
	}


}
