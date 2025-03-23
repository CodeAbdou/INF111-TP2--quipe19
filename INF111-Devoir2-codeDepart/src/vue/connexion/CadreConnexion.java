package vue.connexion;

import modele.Banque;
import vue.GestionnaireVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadreConnexion extends JFrame {

    private JTextField champNom;
    private JTextField champMdp;
    private JLabel labelErreur;
    private GestionnaireVue gestionnaireVue;

    public CadreConnexion(GestionnaireVue gestionnaireVue) {

        this.gestionnaireVue = gestionnaireVue;

        setTitle("Connexion");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        getContentPane().setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNom = new JLabel("Nom utilisateur");
        labelNom.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelNom, gbc);

        champNom = new JTextField(15);
        gbc.gridx = 1;
        add(champNom, gbc);

        JLabel labelMdp = new JLabel("Mot de passe");
        labelMdp.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelMdp, gbc);

        champMdp = new JTextField(15);
        gbc.gridx = 1;
        add(champMdp, gbc);

        JButton bouttonConnexion = new JButton("Soumettre");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(bouttonConnexion, gbc);

        bouttonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = champNom.getText();
                String mdp = champMdp.getText();

                if(Banque.getInstance().verifier(nom, mdp)) {
                    Banque.getInstance().setUtilisateurActif(nom);
                    gestionnaireVue.activerModeCompte();
                    champNom.setText("");
                    champMdp.setText("");
                    labelErreur.setVisible(false);
                } else {
                    labelErreur.setVisible(true);
                }
            }
        });
    }

}
