package missile;

public class jugador {

	public static int posx ,posy;
	public jugador() {
		posx=400;
		posy=300;
		
	}
	public void muevete(int valor){
		if (valor==1){
			posy=posy-10;
		}
		if (valor==2){
			posy=posy+10;
		}
		if (valor==3){
			posx=posx+10;
		}
		if (valor==4){
			posx=posx-10;
		}
		
	}

	

}
