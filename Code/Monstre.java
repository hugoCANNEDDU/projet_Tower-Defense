import java.awt.*;
import javax.swing.*;

public class Monstre {
    
    private double x;
    private double y;
    private int caseX;
    private int caseY;
    private int direction;
    private double dimCaseHauteur;
    private double dimCaseLargeur;
    
    private int PV;
    private double vitesseH;
    private double vitesseL;
    
    public Monstre (int posX, int posY, double dimH, double dimL,int d, int pv, double v){
        caseX=posX;
        caseY=posY;
        dimCaseHauteur=dimH;
        dimCaseLargeur=dimL;
        direction=d;
        
        x=posX*dimCaseLargeur;
        y=posY*dimCaseHauteur;
        
        PV=pv;
        vitesseH=dimCaseHauteur/v;
        vitesseL=dimCaseLargeur/v;
        //System.out.println(vitesseH+"/"+vitesseL+"/"+dimCaseLargeur+""+dimCaseHauteur);
    }
    
    public void affichage(Graphics g){
        g.setColor(Color.RED);
        g.fillOval((int)x,(int)y,(int)dimCaseLargeur,(int)dimCaseHauteur);
        
        switch (direction) {
            case 2: caseX=(int)(x/dimCaseLargeur);
                    caseY=(int)(y/dimCaseHauteur);
                break;
            case 3: caseX=(int)((x+dimCaseLargeur-vitesseL)/dimCaseLargeur);
                    caseY=(int)(y/dimCaseHauteur);
                break;
            case 4: caseX=(int)(x/dimCaseLargeur);
                    caseY=(int)((y+dimCaseLargeur-vitesseH)/dimCaseHauteur);
                break;
            case 5: caseX=(int)(x/dimCaseLargeur);
                    caseY=(int)(y/dimCaseHauteur);
                break;
        }
    }
    
    /*2=droite
     *3=gauche
     *4=haut
     *5=bas*/
    
    public void deplacement(){
        switch (direction) {
            case 2 : x+=vitesseL;//(dimCaseLargeur/vitesse);
                break;
            case 3 : x-=vitesseL;//(dimCaseLargeur/vitesse);
                break;
            case 4 : y-=vitesseH;//(dimCaseHauteur/vitesse);
                break;
            case 5 : y+=vitesseH;//(dimCaseHauteur/vitesse);
                break;
        }
    }
    
    public void setDirection(int d){
        direction=d;
    }
    
    public boolean isDead(){
        boolean resultat=false;
        if(PV<=0){
            resultat=true;
        }
        return resultat;
    }
    
    public String toString(){
        return "je suis un monstre";
    }
    
    public void diminuePV(int nbPV){
		PV-=nbPV;
	}
    
    public int getCaseX(){return caseX;}
    public int getCaseY(){return caseY;}
    public int getPV(){return PV;}
    public void setPV(int p){PV=p;}
}

    
   
