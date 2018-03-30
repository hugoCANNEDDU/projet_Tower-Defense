import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
public class CheminDirectionnel extends Chemin{
	private int direction;
	
	public CheminDirectionnel(int dir,int x,int y){
		super(x,y);
		direction = dir;
	}
	
	public void action(Monstre m){
		m.setDirection(direction);
		for(Tour t : super.listeT){
			t.attaque(m);
		}
	}
	
}

	
