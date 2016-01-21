package gravedad;
import java.util.ArrayList;

public class planetas extends estrella {
//al extender de la clase estrella las variables de estrella se pueden coger directamente...
	public int valorx,valory,xestrella,yestrella,tamaño,valorx2,valory2,tamaño2,level,grad,radsL,rojo,azul,verde,co1,co2,co3;
    public double radio,difx,dify;
    estrella estre;
    public ArrayList<Integer> posicionesx,posicionesy,tamaños,radios,grados,radianesL,colorR,colorG,colorB,bordR,bordG,bordB;
	public planetas() {
		estre=new estrella();
		posicionesx=new ArrayList();
		posicionesy=new ArrayList();
		tamaños=new ArrayList();
		radios=new ArrayList();
		grados=new ArrayList();
		radianesL=new ArrayList();
		colorR=new ArrayList();
		colorG=new ArrayList();
		colorB=new ArrayList();
		bordR=new ArrayList();
		bordG=new ArrayList();
		bordB=new ArrayList();
		level=dibujador.nivel;
	}

	
	public ArrayList posicionesx(){
		return posicionesx;
	}
	public ArrayList posicionesy(){
		return posicionesy;
	}
	public ArrayList tamaños(){
		return tamaños;
	}
	public ArrayList radios(){
		return radios;
	}
	public ArrayList azul(){
		return colorB;
	}
	public ArrayList rojo(){
		return colorR;
	}
	public ArrayList verde(){
		return colorG;
	}
	public ArrayList bordR(){
		return bordR;
	}
	public ArrayList bordB(){
		return bordB;
	}
	public ArrayList bordG(){
		return bordG;
	}
	
	public void generaPlaneta(int nivel){
		for (int g=0;g<nivel;g++)
		{
		valorx=(int)(Math.random()*800+10);
		posicionesx.add(g,valorx);
		valory=(int)(Math.random()*400+10);
		posicionesy.add(g,valory);
        tamaño=(int)(Math.random()*60+10);
		tamaños.add(g,tamaño);
		rojo=(int)(Math.random()*254+1);
		colorR.add(g,rojo);
		azul=(int)(Math.random()*254+1);
		colorB.add(g,azul);
		verde=(int)(Math.random()*254+1);
		colorG.add(g,verde);
		co1=(int)(Math.random()*254+1);
		bordR.add(g,co1);
		co2=(int)(Math.random()*254+1);
		bordB.add(g,co2);
		co3=(int)(Math.random()*254+1);
		bordG.add(g,co3);
		//grad=(int)(Math.random()*360);
		//grados.add(g,grad);
		if (valorx>=estre.posx()+(estre.diam()/2)){
			difx=valorx-(estre.posx()+(estre.diam()/2));
		}
		if (valorx<estre.posx()+(estre.diam()/2)){
			difx=(estre.posx()+(estre.diam()/2))-valorx;
		}
		if (valory>=estre.posy()+(estre.diam()/2)){
			dify=valory-(estre.posy()+(estre.diam()/2));
		}
		if (valory<estre.posy()+(estre.diam()/2)){
			dify=(estre.posy()+(estre.diam()/2))-valory;
		}
		radio=(int)(Math.sqrt((difx*difx)+(dify*dify)));
		radios.add(g,(int)radio);
		}
		
	}
}