package com.joseserpa.schoolmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author joses
 */

public class Profile extends JFrame implements ActionListener {

    private JButton botonEstudiante, botonProfesor, botonRegresar;

    public Profile() {
        setLayout(null);
        setTitle("Perfil");
        getContentPane().setBackground(new Color(0, 40, 50));
        setIconImage(Resources.LOGO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonEstudiante = Resources.crearBoton("Estudiante", 110, 240, 150, 30, this);
        botonProfesor = Resources.crearBoton("Profesor", 445, 240, 150, 30, this);
        botonRegresar = Resources.crearBoton("Regresar", 280, 310, 150, 30, this);

        add(botonEstudiante);
        add(botonProfesor);
        add(botonRegresar);

        mostrarImagen(new ImageIcon("/images/Lapiz_icono_2_sinfondo.png"), 95, 50);
        mostrarImagen(new ImageIcon("/images/Docente2_sinfondo.png"), 430, 50);
    }

    private void mostrarImagen(ImageIcon imagen, int x, int y) {
        JLabel label = new JLabel(imagen);
        label.setBounds(x, y, 180, 180);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonEstudiante || e.getSource() == botonProfesor) {
            cambiarVentana(new Login());
        }

        if (e.getSource() == botonRegresar) {
            cambiarVentana(new Welcome());
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
            new Profile();
        });
    }
}
