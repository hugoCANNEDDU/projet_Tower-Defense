import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class CheminFin extends Chemin{
	
	private Joueur j1;
    private Image img;
	
	
	public CheminFin(Joueur j,int x,int y){
		super(x,y);
		j1 = j;
        
        try {
			img = ImageIO.read(new File("chemin_fin.png"));

	    } catch (IOException e) {

	      e.printStackTrace();

	    }
	}
	
	public void action(Monstre m){
		m.setPV(0);
		j1.enleverPV(1);
		System.out.println(j1.getNbPV());		
	}
    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
