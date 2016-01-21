package colores;

public class cuadro {

	
	public static int posx,posy,rojo,verde,azul,longitud,contador;
	public cuadro() {
		contador=0;
		posx=10;
		posy=10;
		rojo=255;
		verde=0;
		azul=0;
		longitud=100;	
	}
	
	public static void cambiaColor(){
		contador++;
		if (contador==0){
			rojo=255;
			verde=0;
			azul=0;	
		}
		if (contador==1){
			rojo=0;
			verde=255;
			azul=0;
		}
		if (contador==2){
			rojo=0;
			verde=0;
			azul=255;
		}
		if (contador==3){
			contador=0;
			rojo=255;
			verde=0;
			azul=0;
		}
		
	}
	

	

}
