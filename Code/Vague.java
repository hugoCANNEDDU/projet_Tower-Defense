import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vague extends JPanel implements ActionListener{
    
    private LinkedList<Monstre> listeMonstre;
    private Timer t;
    
    private Terrain terrain;
    
    private int caseX;
    private int caseY;
    private int direction;
    
    private int iteration;
    
    private static int nbVague=1;
    private int nbMonstre;
    
    public Vague (int X, int Y, int d,Terrain te){
        nbMonstre=0;
        caseX=X;
        caseY=Y;
        direction=d;
        terrain = te;
        listeMonstre = new LinkedList<Monstre>();
    }
    
    public void genererVague(){
        nbMonstre=4;
        
        //listeMonstre.add(new Monstre(caseX,caseY,terrain.getTailleCaseH(),terrain.getTailleCaseL(),direction,1,5));
        t=new Timer(1000, this);
        t.start();
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        listeMonstre.add(new Monstre(caseX,caseY,terrain.getTailleCaseH(),terrain.getTailleCaseL(),direction,1,4));
        if(listeMonstre.size()>nbMonstre){
            t.stop();
        }
    }
    
    public void checkMonstre(){
        for(int i=0; i<listeMonstre.size(); i++){
			Monstre m = listeMonstre.get(i);
            for(Chemin c : terrain.getListeChemin()){
                if(m.getCaseX()==c.getPosX() && m.getCaseY()==c.getPosY()){
                    c.action(m);
                }
            }
            m.deplacement();
            if(m.isDead()){
				listeMonstre.remove(i);
				terrain.getJoueur().ajouterArgent(10);
			}
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Monstre m : listeMonstre){
            m.affichage(g);
        }
    }
    
    public LinkedList<Monstre> getListeMonstre(){ return listeMonstre;}
}
