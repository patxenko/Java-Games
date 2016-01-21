package colores;

public class colisiones {

	
	public int conti,x1,x2,x3,x4,x5,x6,x7,x8,x9;
	brocha b;
	caida cew;
	public colisiones() {
		b=new brocha();
		cew=new caida();
	}

	
	
	public void coloca(){
		
		//aqui detectamos colisiones;
		x6=brocha.pixels.size();
		x5=caida.posix.size();
		for (int j=0;j<x6;j++){
			for (int g=0;g<x5;g++){
			    conti=0;
			    x7=brocha.pixels.get(j);
			    x8=caida.posix.get(g)+5;
			    x9=caida.posiy.get(g);
				if ( x7==x8 && x9==295)
				{
					x1=brocha.rojo.get(j);
					x2=caida.colr.get(g);
					x3=brocha.verde.get(j);
				    x4=caida.colg.get(g);
					if (x1==x2){
						conti++;
					}
					if (x3==x4){
						conti++;
					}
					if (conti==2){
					    caida.genera(g);
					}
				}
				
			}
		   
	   }
	}
}


