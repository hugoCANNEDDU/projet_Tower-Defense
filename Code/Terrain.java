import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Terrain extends JPanel implements ActionListener{
	
	private int nbLignes;
	private int nbColonnes;
	private int[][]tableau = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 5, 0, 0},
							{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
							{1, 1, 5, 0, 1, 0, 0, 0, 5, 1, 3, 0, 0},
							{0, 0 ,1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
							{0, 0, 1, 0, 1, 0, 0, 0, 2, 1, 5, 0, 0},
							{0, 0, 2, 1, 4, 0, 0, 0, 0, 0, 1, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 5, 1, 1, 3, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 6},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    
    private ArrayList<Chemin> listeChemin;
    
    private Vague v;
    private JLayeredPane couchePanel;
    private JPanel conteneur;
    
    private int largeur;
    private int hauteur;
    private double tailleCaseH;
    private double tailleCaseL;
    
    private Timer t;
    private FenetrePrincipale f;
    private Joueur j1;

	
	public Terrain(FenetrePrincipale fen,  int l, int h) {
		f = fen;
		j1 = new Joueur("Jean-Michel", 30, 500);
		nbLignes =  tableau[0].length;
		nbColonnes = tableau.length;
        
        largeur=l;
        hauteur=h;
        
        tailleCaseH=hauteur/nbColonnes;
        tailleCaseL=largeur/nbLignes;
        
        listeChemin = new ArrayList<Chemin>();
        
        couchePanel=new JLayeredPane();
		conteneur = new JPanel(new GridLayout(tableau.length, tableau[0].length));
        
        v=new Vague(0,3,2,this);
        v.genererVague();
		
		for(int i = 0 ; i < tableau.length ; i++) {
			for(int j = 0 ; j < tableau[0].length ; j++) {
				if(tableau[i][j] == 0) {
					Herbe p = new Herbe(j,i,this);
					conteneur.add(p);
				}
					
				if(tableau[i][j] == 1) {
					Chemin c = new Chemin(j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}	
				
				if(tableau[i][j] == 2) {
					CheminDirectionnel c = new CheminDirectionnel(2,j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}
				
				if(tableau[i][j] == 3) {
					CheminDirectionnel c = new CheminDirectionnel(3,j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}
				
				if(tableau[i][j] == 4) {
					CheminDirectionnel c = new CheminDirectionnel(4,j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}
				
				if(tableau[i][j] == 5) {
					CheminDirectionnel c = new CheminDirectionnel(5,j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}
				
				if(tableau[i][j] == 6) {
					CheminFin c = new CheminFin(j1,j,i);
					conteneur.add(c);
                    listeChemin.add(c);
				}
			}	
		}
        couchePanel.setPreferredSize(new Dimension(largeur,hauteur));
        
        conteneur.setBounds(0,0,largeur,hauteur);
        couchePanel.add(conteneur, new Integer(1));
        
        v.setBounds(0,0,largeur,hauteur);
        v.setOpaque(false);
        couchePanel.add(v, new Integer(2));
        
        
        this.add(couchePanel);
        
        t = new Timer(100,this);
        t.start();
        
        //System.out.println(this.getHeight()+" / "+this.getWidth());
	
	}
	
	public double getTailleCaseH() {
		return tailleCaseH;
	}
    
    public double getTailleCaseL(){
        return tailleCaseL;
    }
    
    public Vague getVague(){return v;}
    
    public ArrayList<Chemin> getListeChemin(){return listeChemin;}
    
    public void actionPerformed(ActionEvent e){
        v.checkMonstre();
        this.repaint();
        f.actualiseAffichage();
        Herbe h = new Herbe(-1,-1,this);
        for(Tour t : h.getListeTour()){
			t.checkAtt();
		}
    }
    
    public Joueur getJoueur(){
		return j1;
	}
}
