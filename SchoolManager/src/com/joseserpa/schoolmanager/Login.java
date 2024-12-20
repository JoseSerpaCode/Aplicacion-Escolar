package com.joseserpa.schoolmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author joses
*/

public class Login extends JFrame implements ActionListener {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton botonIniciarSesion, botonRegresar;

    public Login() {
        setLayout(null);
        setTitle("Iniciar Sesión");
        getContentPane().setBackground(new Color(0, 40, 50));
        setIconImage(Resources.LOGO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(Resources.LOGO_LENIS_LABEL);

        JLabel labelBienvenido = Resources.createLabel("BIENVENIDO!", 300, 10, 350, 70);
        JLabel labelUsuario = Resources.createLabel_Inicio_Sesion("Usuario:", 300, 90, 350, 30);
        JLabel labelContrasena = Resources.createLabel_Inicio_Sesion("Contraseña:", 300, 170, 350, 30);

        campoUsuario = new JTextField("");
        campoUsuario.setBounds(300, 125, 350, 30);
        campoUsuario.setFont(new Font("Arial", Font.BOLD, 15));

        campoContrasena = new JPasswordField("");
        campoContrasena.setBounds(300, 205, 350, 30);
        campoContrasena.setFont(new Font("Arial", Font.BOLD, 15));

        botonIniciarSesion = Resources.crearBoton("Ingresar", 300, 260, 150, 30, this);
        botonRegresar = Resources.crearBoton("Regresar", 500, 260, 150, 30, this);

        add(labelBienvenido);
        add(labelUsuario);
        add(labelContrasena);
        add(campoUsuario);
        add(campoContrasena);
        add(botonIniciarSesion);
        add(botonRegresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonIniciarSesion) {
            String textoUsuario = campoUsuario.getText().trim();
            String textoContrasena = new String(campoContrasena.getPassword()).trim();

            if (textoUsuario.equals("") || textoContrasena.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar los datos");
            } else {
                cambiarVentana(new Main());
            }
        }

        if (e.getSource() == botonRegresar) {
            cambiarVentana(new Profile());
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
            new Login();
        });
    }
}