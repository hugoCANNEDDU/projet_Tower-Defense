import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.io.*;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Herbe extends JButton implements MouseListener {
	
	private Image img;
    public int posX;
    public int posY;
    private Terrain terr;
    private static LinkedList<Tour> listeTour = new LinkedList<Tour>();
	
	public Herbe(int x,int y, Terrain t) {
		//this.setBackground(Color.green);
        posX=x;
        posY=y;
        terr = t;
		try {
			img = ImageIO.read(new File("Herbe.png"));

	    } catch (IOException e) {

	      e.printStackTrace();

	    }
		
		this.addMouseListener(this);

	}

	  public void mouseClicked(MouseEvent event) {
		  Tour to = new Tour(terr,1 , 1, 1, posX, posY);
		  if (terr.getJoueur().getArgent()>=to.getCout()){
			  terr.getJoueur().preleverArgent(to.getCout());
			  listeTour.add(to);
			  img = to.getImageTour();
		  }else{
			  System.out.println("pas assez de tune");
		  }
		  
	  }


	  public void mouseEntered(MouseEvent event) { 
		  //this.setBackground(Color.blue);
		  /*try {
				img = ImageIO.read(new File("green-grass.png"));

		    } catch (IOException e) {

		      e.printStackTrace();

		    }*/
        }

	  public void mouseExited(MouseEvent event) { 
		  //this.setBackground(Color.green);
		  /*try {
				img = ImageIO.read(new File("green-grass.png"));

		    } catch (IOException e) {

		      e.printStackTrace();

		    }*/
	  }

	  public void mousePressed(MouseEvent event) { }

	  public void mouseReleased(MouseEvent event) { } 
	  
	  public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
		  
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
          
	  }
	  
	  public int getPosX() {
		  return posX;
	  }
	  
	  public int getPosY() {
		  return posY;
	  }
	  
	  public Terrain getTerrain() {
		  return terr;
	  }
	  
	  public LinkedList<Tour> getListeTour(){
		  return listeTour;
	  }
		  
}
