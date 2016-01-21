package minipong;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Color;

public class pelota extends JPanel implements ActionListener {
	
    private int x,y;
    private Timer mitimer;
    private int contadorx,contadory,anchura,altura;
    public int colision;
    dibujador dibu;
    int puntos1,puntos2;
    public void actionPerformed(ActionEvent e) {
    	
        if (contadorx==0){
        	x++;
        }
        if (contadorx==1){
        	x--;
        }
        if (contadory==0){
        	y++;
        }
        if (contadory==1){
        	y--;
        }
        if (colision==1){
        	contadorx=0;
        	colision=0;
        }
        if (colision==2){
        	contadorx=1;
        	colision=0;
        }
        if (y==0){
        	contadory=0;
        }
        if (y==400-altura){
        	contadory=1;
        }
        if (x==0){
        	puntos2++;
        	x=400;
        	y=200;	
        }
        if (x==800-anchura){
            x=400;
            y=200;
            puntos1++;
        }
       
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int anchura() {
        return anchura;
    }
    public int altura() {
        return altura;
    }
   
	//constructor con variable de entrada la ruta de la imagen seleccionada//
	public pelota() {
		x=0;y=0;contadorx=0;contadory=0;
		anchura=20;
		altura=20;
		mitimer=new Timer(2,this);
		mitimer.start();
		colision=0;
		puntos1=0;
		puntos2=0;
	}
	public int puntos1(){
		return puntos1;
	}
	public int puntos2(){
		return puntos2;
	}
	

	
	

}