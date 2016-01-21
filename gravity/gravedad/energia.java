package gravedad;

public class energia {

	
	public int altura,x,y,incremento;
	public int anchura,relleno,velocidad;
	public energia() {
		altura=20;
		anchura=100;
		x=10;
		y=390-altura;
		incremento=0;
		relleno=0;
		velocidad=0;
		
	}
	public int altura(){
		return altura;
	}
	public int anchura(){
		return anchura;
	}
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	public void teclaPulsada(int ent){
		if (ent==1){
			
			relleno=relleno+1; //hacia arriba
			if (relleno==anchura){
				relleno=anchura-1;
			}
		}
		if (ent==2){
			relleno=relleno-1; //hacia abajo
			if (relleno<=0){
				relleno=0;
			}
		}
	}
	
	public int relleno(){
		return relleno;
	}
	public void iniRelleno(){
		relleno=0;
	}

	
	

}