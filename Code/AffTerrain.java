import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AffTerrain extends JFrame{
	
	private Terrain t;
    private JLayeredPane test;
		
	public AffTerrain() {
		super("Terrain");
		
		this.setSize(new Dimension(1200,1200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Terrain(800,800);
        
        
        this.getContentPane().add(t);
        
		this.setVisible(true);
	}
    
    public static void main (String[] args){
        AffTerrain t=new AffTerrain();
    }
}

