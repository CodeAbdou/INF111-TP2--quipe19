package vue.compte;
import modele.Banque;
import baseDonnees.modeles.Utilisateur;
import vue.GestionnaireVue;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;


public class CadreCompte extends JFrame {

    private GestionnaireVue gVue;
    private JTable tabTransactions;
    private JLabel labelNom, labelCompte, labelSolde;

    public CadreCompte(GestionnaireVue gVue) {
        this.gVue = gVue;

        setTitle("Compte bancaire");;
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color vertPale = new Color(121, 176, 136);
        Color vertFonce = new Color(42, 71, 50);

        //panneau principale
        JPanel panneauPrincipale = new JPanel(new BorderLayout());


        //Colonne de gauche
        JPanel colonneGauche = new JPanel(new GridLayout(3,1));
        colonneGauche.setBackground(vertFonce);

        //logo
        JPanel panneauLogo = new JPanel();
        panneauLogo.setBackground(vertFonce);
        JLabel logo = new JLabel(new ImageIcon("dollar.png"));
        panneauLogo.add(logo);

        //Boutons
        JPanel panneauBouton = new JPanel(new GridLayout(2,1,10,10));
        panneauBouton.setBackground(vertFonce);
        JButton btnTransaction = new JButton("Nouvelle transaction");
        JButton btnDeconnexion = new JButton("Se Deconnecter");
        panneauBouton.add(btnTransaction);
        panneauBouton.add(btnDeconnexion);


        //panneau vide
        JPanel panneauVide = new JPanel(new BorderLayout());
        panneauVide.setBackground(vertFonce);
        colonneGauche.add(panneauLogo);
        colonneGauche.add(panneauBouton);
        colonneGauche.add(panneauVide);

        //colonne droite
        JPanel colonneDroite = new JPanel(new BorderLayout());

        //infos utilisateurs
        JPanel panneauInfos = new JPanel();
        panneauInfos.setBackground(vertPale);
        panneauInfos.setLayout(new BoxLayout(panneauInfos, BoxLayout.Y_AXIS));

        labelNom = new JLabel("Nom: ");
        labelCompte = new JLabel("Numero de Compte: ");
        labelSolde = new JLabel("Solde: ");
        labelNom.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelCompte.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelSolde.setAlignmentX(Component.LEFT_ALIGNMENT);


        panneauInfos.add(Box.createVerticalStrut(10));
        panneauInfos.add(labelNom);
        panneauInfos.add(Box.createVerticalStrut(5));
        panneauInfos.add(labelCompte);
        panneauInfos.add(Box.createVerticalStrut(5));
        panneauInfos.add(labelSolde);
        panneauInfos.add(Box.createVerticalStrut(5));

        //tableau des transactions
        String[] titres = {"Source", "Destination", "Montant", "Status"};
        tabTransactions = new JTable(new DefaultTableModel(titres, 0));
        JScrollPane scrollPane = new JScrollPane(tabTransactions);

        colonneDroite.add(scrollPane, BorderLayout.CENTER);
        colonneDroite.add(panneauInfos, BorderLayout.NORTH);

        panneauPrincipale.add(colonneDroite,BorderLayout.CENTER);
        panneauPrincipale.add(colonneGauche,BorderLayout.WEST);

        setContentPane(panneauPrincipale);

        btnDeconnexion.addActionListener((ActionEvent e) -> {
            Banque.getInstance().deconnecterUtilisateur();
            gVue.activerModeConnexion();
        });

        btnTransaction.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Fenetre de transaction a venir");
        });



    }





}
