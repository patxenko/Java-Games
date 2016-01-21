package tunel;

public class salido {

	fondo fond;
	jugador jug;
	public int anchoR,anchoJ,altoR,altoJ,xR,xJ,yR,yJ,altosi,anchosi,xsi,ysi;
	public salido() {
		fond=new fondo();
		jug=new jugador();
	}
	
	public void colision(){
		//para cada rectangulo
		for (int h=0;h<fondo.posicionesx.size();h++){
			anchoJ=jugador.ancho;
			altoJ=jugador.alto;
			yJ=jugador.posy;
			xJ=jugador.posx;
			anchoR=fondo.anchuras.get(h);
			altoR=fondo.alturas.get(h);
			xR=fondo.posicionesx.get(h);
			yR=fondo.posicionesy.get(h);
			
			if ((xR+anchoR>xJ) && (xJ>xR)){ //estamos dentro del rectangulo
				yR=fondo.posicionesy.get(h);
				if (yJ<yR){
					//System.out.println("colision");
					jug.findejuego();
				}
				if (yJ+altoJ>yR+altoR){
					//System.out.println("colision");
					jug.findejuego();
				}
				int r=h+1;
				altosi=fondo.alturas.get(r);
				xsi=fondo.posicionesx.get(r);
				ysi=fondo.posicionesy.get(r);
				if (xJ+anchoJ>=xsi){
					//System.out.println("cambio");
					if (yJ<ysi){
						//System.out.println("colision");
						jug.findejuego();
					}
					if (yJ+altoJ>ysi+altosi){
						//System.out.println("colision");
						jug.findejuego();
					}
				}
		    }
	}
	}
}

	


