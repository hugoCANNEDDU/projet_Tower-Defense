public class Joueur{
	private String pseudo;
	private int nbPV;
	private int argent;
	private boolean vivant;
	
	public Joueur(String name, int PV, int money){
		pseudo = name;
		nbPV=PV;
		argent = money;
		vivant = true;
		
	}
	
	public int getNbPV(){
		return nbPV;
	}
	
	public void enleverPV(int p){
		nbPV = nbPV - p;
		if(nbPV<=0){
			vivant = false;
		}
	}
	
	public int getArgent(){
		return argent;
	}
	
	public void ajouterArgent(int a){
		argent = argent + a;
	}
	
	public void preleverArgent(int a){
		argent = argent - a;
	}
	
	public String getPseudo(){
		return pseudo;
	}
	
	public String toString(){
		String s= pseudo +" | Nombre de PdV : "+nbPV+" | Argent = "+argent;
		return s;
	}
	
	
}
