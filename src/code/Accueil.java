package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Accueil extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String binaire;
	private String choix;
	private JButton btnValider = new JButton("Valider");
	
	public Accueil(){
		JFrame f1 = new JFrame("Accueil");
		creerComposants(f1);
		f1.setSize(420, 200);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	
	private void creerComposants(JFrame f1){
		JPanel panneau1 = new JPanel();
		JLabel texte1 = new JLabel("Saisissez la chaine binaire :");
		JTextField champ1 =  new JTextField();
		champ1.setPreferredSize(new Dimension(210, 20));
		panneau1.add(texte1);
		panneau1.add(champ1);
		panneau1.setPreferredSize(new Dimension(0, 30));
		f1.add(panneau1, BorderLayout.NORTH);
		
		Container cont = getContentPane();
		ButtonGroup group = new ButtonGroup();
		JPanel panneau3 = new JPanel();
		panneau3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED) , "Choix"));
		panneau3.setLayout(new GridLayout(3,1));
		JRadioButton verifier = new JRadioButton("Verifier");
		verifier.setActionCommand("verifier");
		group.add(verifier); 
		panneau3.add(verifier);
		JRadioButton calculer = new JRadioButton("Calculer");
		calculer.setActionCommand("calculer");
		group.add(calculer); 
		panneau3.add(calculer);
		verifier.setSelected(true);
		cont.add(panneau3, BorderLayout.CENTER);
		f1.add(panneau3);
		 	
		btnValider.addActionListener((event) -> btnValiderListener(event, champ1, group));
		JPanel panneau4 = new JPanel();
		panneau4.add(btnValider);
		f1.add(panneau4, BorderLayout.SOUTH);
	}
	
	private boolean isBinaire() {
		boolean result = true;
		char el;
		if(binaire.equals(""))
			return false;
		for(int i = 0; i < binaire.length(); i++) {
			el = binaire.charAt(i);
			if(!(Character.toString(el).equals("0") || Character.toString(el).equals("1"))){
				return false; 
			}
		}
		return result;
	}
	
	private boolean isLongueurBinaireCorect() {
		boolean result = true;
		int i = 1, res = 0;
		while(true){
			res = (((int) Math.pow(2, i)) - 1) - i;
			if(binaire.length() != res) {
				if(binaire.length() < res){
					result = false;
					break;
				}
			}else {
				result = true;
				break;
			}
			i++;
		}
		return result;
	}
	
	private static int getLongueur(String binaire) {
		int result = 0;
		int i = 1, res = 0;
		while(true){
			res = (((int) Math.pow(2, i)) - 1) - i;
			if(binaire.length() == res) {
				result = i;
				break;
			}
			i++;
		}
		return result;
	}
	
	private void btnValiderListener(ActionEvent e, JTextField champ1,  ButtonGroup group){
		boolean go = true;
		binaire = champ1.getText();
        choix = group.getSelection().getActionCommand();        
		if(go){
			gestion();
		}else {
			System.out.println("pas bien renseigne");
		}
	}
	
	public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	private void gestion() {
		System.out.println("Gest choix "+choix);
		if("verifier".equals(choix)) {
			creerComposantsVerifier(binaire);
		}else if("calculer".equals(choix)) {
			creerComposantsCalculer(binaire);
		}
	}
	
	private static void creerComposantsVerifier(String b){
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame f2 = new JFrame("Verification");
                verifier(f2, b);                
                f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f2.pack();
        		f2.setLocationRelativeTo(null);
                f2.setVisible(true);
                f2.setResizable(false);
            }
        });
	}
	
	private static void verifier(JFrame f, String binaire) {
		System.out.println("Verif");

	}
	
	private static void creerComposantsCalculer(String b){
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
            	JFrame f2 = new JFrame("Calcul");
            	calculer(f2, b);
                f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f2.pack();
        		f2.setLocationRelativeTo(null);
                f2.setVisible(true);
                f2.setResizable(false);
            }
        });
	}
	
	private static void calculer(JFrame f, String binaire) {
		System.out.println("Calcul");
		// -------------------------------Nord-----------------------------
		// Stocke les coeficients du polynome
		String coefPoly = "";
		// Stocke le binaire obtenu apres transcription du polynome
		String codePoly = "";
		String codeCRC;
		String motComplet = binaire;
		
		JPanel nord = new JPanel();
		JLabel texteBin = new JLabel("Le code binaire : "+binaire);
		nord.add(texteBin);
		f.add(nord, BorderLayout.NORTH);
		
		
		// -------------------------------Centre-----------------------------
		// recuperation du longueur a ajouter
		int longueurAAjoute = getLongueur(binaire);
		
		//ajout de zero dans les places libres
		motComplet += "00";
		int z = 0;
		while(z < longueurAAjoute) {
			int pos = (int) ((Math.pow(2, z) - 1) -z);
			 
		}
		
		
		
		
		

	}
	
}
