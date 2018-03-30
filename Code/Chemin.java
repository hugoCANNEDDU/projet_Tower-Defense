import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Chemin extends JPanel /*extends Case*/{
	private int direction;
	private Image img;
	
    private int posX;
    private int posY;
	protected LinkedList<Tour> listeT;
	
	public Chemin(int x, int y){
		direction = 0;
        posX=x;
        posY=y;
        listeT = new LinkedList<Tour>();
        
		try {
			img = ImageIO.read(new File("chemin.png"));

	    } catch (IOException e) {

	      e.printStackTrace();

	    }
	}
	
	public int getDirection(){
		return direction;
	}
    
    public void action(Monstre m){
    	for(Tour t : listeT){
			t.attaque(m);
		}
    }
	
	public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public int getPosX(){return posX;}
	
    public int getPosY(){return posY;}
    
    public void ajouterTour(Tour t) {listeT.add(t);}
    
    public String toString() {
    	return "je suis le chemin ("+posX+","+posY+")";
    }
	
	
}
