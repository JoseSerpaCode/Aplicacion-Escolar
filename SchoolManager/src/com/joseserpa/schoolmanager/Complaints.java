package com.joseserpa.schoolmanager;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * @author joses
*/

public class Complaints extends JFrame implements ActionListener {

    private JTextArea textarea1;
    private JScrollPane scrollpane1;
    private JButton botonRegresar, botonEnviar;
    private JLabel labelQueja;

    String texto = "";

    public Complaints() {
        setLayout(null);
        setTitle("Quejas y Reclamaciones");
        getContentPane().setBackground(new Color(0, 40, 50));
        setIconImage(Resources.LOGO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textarea1 = new JTextArea("");
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 20, 400, 300);
        add(scrollpane1);

        labelQueja = new JLabel("<html>Aqui puedes<br>escribir tus<br>quejas y/o Reclamaciones</html>");
        labelQueja.setBounds(430, 5, 210, 210);
        labelQueja.setFont(new Font("Arial", 2, 30));
        labelQueja.setForeground(Color.WHITE);


        botonEnviar = Resources.crearBoton("Enviar", 430, 230, 150, 30, this);
        botonRegresar = Resources.crearBoton("Regresar", 430, 290, 150, 30, this);

        add(labelQueja);
        add(botonEnviar);
        add(botonRegresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegresar) {
            cambiarVentana(new Main());
        } else if (e.getSource() == botonEnviar) {
            JOptionPane.showMessageDialog(Complaints.this, "Enviado Correctamente");
            textarea1.setText("");
        }
    }

    private void cambiarVentana(JFrame nuevaVentana) {
        nuevaVentana.setBounds(0, 0, 720, 400);
        nuevaVentana.setVisible(true);
        nuevaVentana.setResizable(false);
        nuevaVentana.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new Complaints();
        });
    }
}