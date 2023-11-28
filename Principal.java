import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener {

    private JMenuBar menubar;
    private JMenu Perfil, Opciones, Notas, Agenda, Tamaño, Color_Fondo;
    private JMenuItem perfilItem, notasitem, agendaitem, Tamaño1, Tamaño2, Tamaño3, Color1, Color2, salir;
    private JLabel IEAL, imagenLabel;
    private JButton botonNovedades, botonRedesSociales, botonQuejas;
    private Dimension tamanoOriginalBotones;
    private Color colorFondoVentana = new Color(0, 40, 50);
    private JPanel panelBotones;

    public Principal() {

        setLayout(new BorderLayout());
        setTitle("IE ANTONIO LENIS");
        getContentPane().setBackground(new Color(0, 40, 50));
        setIconImage(RecursosCompartidos.LOGO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar = new JMenuBar();
        menubar.setBackground(new Color(0, 22, 30));
        setJMenuBar(menubar);

	Perfil = RecursosCompartidos.menu(" Perfil ", menubar);
        Opciones = RecursosCompartidos.menu(" Opciones ", menubar);
        Notas = RecursosCompartidos.menu(" Notas ", menubar);
        Agenda = RecursosCompartidos.menu(" Agenda ", menubar);

            perfilItem = new JMenuItem("Ver perfil");
            perfilItem.addActionListener(this);
            Perfil.add(perfilItem);

            notasitem = new JMenuItem("Ver notas");
            notasitem.addActionListener(this);
            Notas.add(notasitem);

            agendaitem = new JMenuItem("Ver agenda");
            agendaitem.addActionListener(this);
            Agenda.add(agendaitem);

            Tamaño = new JMenu("Tamaño ");
            Opciones.add(Tamaño);

            Color_Fondo = new JMenu("Color fondo ");
            Opciones.add(Color_Fondo);

            salir = new JMenuItem("Salir");
            salir.addActionListener(this);
            Opciones.add(salir);

            Tamaño1 = new JMenuItem("1080x620");
            Tamaño1.addActionListener(this);
            Tamaño.add(Tamaño1);

            Tamaño2 = new JMenuItem("786x480");
            Tamaño2.addActionListener(this);
            Tamaño.add(Tamaño2);

            Tamaño3 = new JMenuItem("720x400");
            Tamaño3.addActionListener(this);
            Tamaño.add(Tamaño3);

            Color1 = new JMenuItem("Original");
            Color1.addActionListener(this);
            Color_Fondo.add(Color1);

            Color2 = new JMenuItem("Blanco");
            Color2.addActionListener(this);
            Color_Fondo.add(Color2);

            IEAL = new JLabel("Institución Educativa Antonio Lenis  ");
            IEAL.setForeground(Color.WHITE);
            IEAL.setFont(new Font("Arial", Font.BOLD, 15));
            menubar.add(Box.createHorizontalGlue());
            menubar.add(IEAL);

        botonNovedades = RecursosCompartidos.crearBoton("Novedades", this);
        botonRedesSociales = RecursosCompartidos.crearBoton("Redes Sociales", this);
        botonQuejas = RecursosCompartidos.crearBoton("Quejas/Reclamaciones", this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        panelBotones.add(botonNovedades);
        panelBotones.add(Box.createRigidArea(new Dimension(100, 20)));
        panelBotones.add(botonRedesSociales);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        panelBotones.add(botonQuejas);
        panelBotones.setBackground(colorFondoVentana);
        add(panelBotones, BorderLayout.LINE_START);

        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.NORTH);
        imagenLabel.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 28));
        add(imagenLabel, BorderLayout.LINE_END);

        Timer timer = new Timer(3000, this);
        timer.start();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mostrarSiguienteImagen();
                ajustarTamanioBotones();
            }
        });
    }

    private void ajustarTamanioBotones() {
        int anchoVentana = getWidth();
        int altoVentana = getHeight();

        if (anchoVentana == 1080 && altoVentana == 620) {
            asignarTamanioBotones(300, 150);
        } else if (anchoVentana == 786 && altoVentana == 480) {
            asignarTamanioBotones(260, 110);
        } else if (anchoVentana == 720 && altoVentana == 400) {
            asignarTamanioBotones(250, 90);
        }
    }

    private void asignarTamanioBotones(int ancho, int alto) {
        ajustarTamanioBoton(botonNovedades, ancho, alto);
        ajustarTamanioBoton(botonRedesSociales, ancho, alto);
        ajustarTamanioBoton(botonQuejas, ancho, alto);
    }

    private void ajustarTamanioBoton(JButton boton, int ancho, int alto) {
        if (boton != null) {
            Dimension nuevoTamano = new Dimension(ancho, alto);
            boton.setSize(nuevoTamano);
            boton.setPreferredSize(nuevoTamano);
            boton.setMinimumSize(nuevoTamano);
            boton.setMaximumSize(nuevoTamano);
            boton.revalidate();
            boton.repaint();
        }
    }

    private void mostrarSiguienteImagen() {
        ImageIcon siguienteImagen = RecursosCompartidos.obtenerSiguienteImagen();
        if (siguienteImagen != null) {
            imagenLabel.setIcon(siguienteImagen);
            ajustarTamanioImagen(siguienteImagen);
        }
    }

    private void ajustarTamanioImagen(ImageIcon siguienteImagen) {
        if (siguienteImagen != null) {
            int anchoVentana = getWidth();
            int altoVentana = getHeight();
            Image imagenOriginal = siguienteImagen.getImage();
            double factorEscalado = 1.0;

            if (anchoVentana == 786 && altoVentana == 480) {
                factorEscalado = 1.2;
            }

            if (anchoVentana == 1080 && altoVentana == 620) {
                factorEscalado = 1.6;
            }

            int anchoImagenEscalada = (int) (imagenOriginal.getWidth(null) * factorEscalado);
            int altoImagenEscalada = (int) (imagenOriginal.getHeight(null) * factorEscalado);

            Image imagenEscalada = imagenOriginal.getScaledInstance(
                    anchoImagenEscalada,
                    altoImagenEscalada,
                    Image.SCALE_SMOOTH);

            ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);
            imagenLabel.setIcon(imagenEscaladaIcon);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == perfilItem) {
            JOptionPane.showMessageDialog(Principal.this, "Realizado por JOSÉ SERPA MEDINA y DAYANA PÉREZ 2023");
        }

        if (e.getSource() == notasitem) {
            JOptionPane.showMessageDialog(Principal.this, "Ya tienes el año ganado, ¿que más vas a mirar?");
        }

        if (e.getSource() == agendaitem) {
            JOptionPane.showMessageDialog(Principal.this, "Compa el año se acabó, ya no hay agenda");
        }

        if (e.getSource() == Tamaño1) {
            setSize(1080, 620);
        } else if (e.getSource() == Tamaño2) {
            setSize(786, 480);
        } else if (e.getSource() == Tamaño3) {
            setSize(720, 400);
        } else if (e.getSource() == Color1) {
            colorFondoVentana = new Color(0, 40, 50);
        } else if (e.getSource() == Color2) {
            colorFondoVentana = new Color(255, 255, 255);
        } else if (e.getSource() == salir) {
            cambiarVentana(new Bienvenida());
        } else if (e.getSource() == botonQuejas) {
            cambiarVentana(new Quejas());
        } else if (e.getSource() == botonRedesSociales) {
            JOptionPane.showMessageDialog(Principal.this, "Las redes sociales están como Nequi, Caídas");
        } else if (e.getSource() == botonNovedades) {
            JOptionPane.showMessageDialog(Principal.this, "No hay Novedades actualmente");
        }

        getContentPane().setBackground(colorFondoVentana);
        panelBotones.setBackground(colorFondoVentana);

        if (e.getSource() instanceof Timer) {
            mostrarSiguienteImagen();
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
            new Principal();
            new Quejas();
        });
    }
}