import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Tour extends Herbe{
	//private Terrain terrain;
	private int portee;
	private int vitesseTir;
	private int degats;
	private int cout;
	private Image imgTour;
	private LinkedList<Point> attaquables;
	private int nbIteration = 0;
	private boolean attPossible;
	
	public Tour(Terrain t, int p, int v, int d, int x, int y){
		super(x, y, t);
		portee = p;
		vitesseTir = v;
		degats = d;
		cout=100;
		attPossible=true;
		for(Chemin c : getTerrain().getListeChemin()) {
			if(c.getPosX()<=getPosX()+p && c.getPosX()>=getPosX()-p && c.getPosY()<= getPosY()+p && c.getPosY()>=getPosY()-p ) {
				c.ajouterTour(this);
				System.out.println(c);
			}
		}
		
		try{
			imgTour= ImageIO.read(new File("tour.png"));
		} catch(Exception e) {
		}
	}
	
	public int getPortee(){
		return portee;
	}
	
	public int getVitesse(){
		return vitesseTir;
	}
	
	public int getDegats(){
		return degats;
	}
	
	public Image getImageTour(){
		return imgTour;
	}
		
	public void afficheTour() {
		try {
			imgTour = ImageIO.read(new File("tour.png"));

	    } catch (IOException e) {

	      e.printStackTrace();

	    }
	}
	
	public void checkAtt(){
		if(nbIteration>=10){
			attPossible=true;
			nbIteration=0;
		}
		nbIteration++;
	}
	
	public void attaque(Monstre m){
		if(attPossible){
			m.diminuePV(degats);
			attPossible=false;
		}
		
	}
	
	public int getCout(){
		return cout;
	}	
	
}
