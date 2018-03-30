import java.awt.Dimension;
import java.awt.*;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea; 
import java.util.Timer;
import java.util.LinkedList;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.event.*;

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private Terrain t1;
	
	private JButton b0;
	
	public FenetrePrincipale(){
		
		super("Tower Defense");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(Frame.MAXIMIZED_BOTH); //Plein écran
		setUndecorated(true);
        
        t1 = new Terrain(this, this.getWidth()*2/3,this.getHeight()-10);
        
        JPanel cadrePrincipal = new JPanel(new BorderLayout());
        
        JPanel cmd = new JPanel(new BorderLayout());
        cmd.setPreferredSize(new Dimension(this.getWidth()/4,this.getHeight()));
        
        JPanel Boutique = new JPanel();
        Boutique.setPreferredSize(new Dimension(this.getWidth()/4,this.getHeight()/8));
        
        JPanel HaTour = new JPanel();
        HaTour.setPreferredSize(new Dimension(this.getWidth()/4,this.getHeight()/2));
        
        
        JPanel cmd2 = new JPanel(new BorderLayout());
        JPanel infos = new JPanel();
        infos.setLayout(new BoxLayout(infos, BoxLayout.PAGE_AXIS));
        
        infos.setPreferredSize(new Dimension(this.getWidth()/3, this.getHeight()*2/7));
        
        
        l1 = new JLabel("BOUTIQUE :");
        
        l2 = new JLabel("Pieces d'or : ");
        l3 = new JLabel( "Informations niveau : ");
        l4 = new JLabel("Vie restante : ");
        l5 = new JLabel("Numero vague : ");
        l6 = new JLabel("Progression vague : ");
        
        Font font1 = new Font("Liberation Serif",Font.PLAIN,30);
        l2.setFont(font1);
        l3.setFont(font1);
        l4.setFont(font1);
        l5.setFont(font1);
        l6.setFont(font1);
        l6.setFont(font1);
        
        
        b0 = new JButton("START WAVE");
        JButton b1 = new JButton("T1");
        JButton b2 = new JButton("T2");
        JButton b3 = new JButton("T3");
        JButton b4 = new JButton("T4");
        JButton b5 = new JButton("T5");
        JButton b6 = new JButton("T6");
        
        b0.setPreferredSize(new Dimension(this.getWidth()/5,this.getHeight()/20));
        b1.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        b2.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        b3.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        b4.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        b5.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        b6.setPreferredSize(new Dimension(this.getWidth()/9,this.getWidth()/9));
        
        HaTour.add(b1);
        HaTour.add(b2);
        HaTour.add(b3);
        HaTour.add(b4);
        HaTour.add(b5);
        HaTour.add(b6);
        
        
        Boutique.add(l1);
        
        cmd.add(HaTour, BorderLayout.CENTER);
        cmd.add(Boutique, BorderLayout.NORTH);

        b0.addActionListener(this);
        Font font2 = new Font("Liberation Serif",Font.PLAIN,50);
        l1.setFont(font2);


        infos.add(l2);
        infos.add(l3);
        infos.add(l4);
        infos.add(l5);
        infos.add(l6);
        
        
        cmd2.add(infos);
        cmd2.add(b0, BorderLayout.SOUTH);
        cmd.add(cmd2, BorderLayout.SOUTH);
        cadrePrincipal.add(cmd, BorderLayout.WEST);
        cadrePrincipal.add(t1);

        
        this.setContentPane(cadrePrincipal);
        this.setVisible(true);
        
        /*long dureeLvl = 60000;                                                 //progression nv
		long t0 = System.currentTimeMillis();
		long rapport;
		while(System.currentTimeMillis()< (dureeLvl + t0)){
			
			
			l1.setText((System.currentTimeMillis()-t0)*100/dureeLvl + " %");
		}
		l1.setText("100 %");*/
    }
    
    public JLabel getLabel(){
		return l1;
	}
    
    public static void main(String[] args){
		
		FenetrePrincipale f = new FenetrePrincipale();
		
	}
	
	public JLabel getL1(){
		return l1;
	}
	
	public void setL1(String s){
		l1.setText(s);
	}
       
	public void actualiseAffichage(){
		l4.setText("Vie restante : "+t1.getJoueur().getNbPV());
		l2.setText("Pieces d'or : "+t1.getJoueur().getArgent());
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b0){
			t1.getVague().genererVague();
		}
	}
}
	
	
