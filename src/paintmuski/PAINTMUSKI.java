package paintmuski;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PAINTMUSKI extends JFrame implements ActionListener {

    //Variables
    JMenuBar mb;
    JMenu m1, m2, mm;
    JMenuItem mn, ma, mg, salir, copy, cut, paste, ayuda, info, gjpg, gpng, ggif, gjpeg;
    JPanel panel1, panel2;
    JButton circulo, rectangulo, pentagono, triangulo, linea, estrella, colfon, colfig, rombo, relleno, borrador, regre, abstracto;
    Color cfon, cfig, color;
    String fig = "LineToLine";
    Dibujos panel = new Dibujos();
    boolean re;
    JSlider sl;
    JLabel gro;
    int valor;
    int c = 0;
    int a = 0;
    boolean regresar, nuevo, da;
    Vector<Vec> v = new Vector<Vec>();
    JLabel la = new JLabel();
    Image img;

    //Constructor
    public PAINTMUSKI() {
        ventana();
        barra();
        panel1();
        panel2();
        panel.setFig(fig);
        panel.setBackground(Color.WHITE);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    //Frame
    public void ventana() {
        setTitle("PAINT MUSKI");
        setIconImage(new ImageIcon(getClass().getResource("/imagen/icono.png")).getImage());
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        setBounds(0, 0, dim.width, dim.height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout());
    }

    //Barra
    public void barra() {
        mb = new JMenuBar();
        setJMenuBar(mb);
        mb.setBackground(new Color(1, 152, 117));
        mb.setBorder(BorderFactory.createTitledBorder("HERRAMIENTAS"));
        m1 = new JMenu("Archivo");
        m1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mb.add(m1);
        mn = new JMenuItem("Nuevo");
        mn.addActionListener(this);
        m1.add(mn);
        ma = new JMenuItem("Abrir");
        ma.addActionListener(this);
        m1.add(ma);
        mg = new JMenu("Guardar");
        mg.addActionListener(this);
        m1.add(mg);
        gjpg = new JMenuItem("Guardar jpg");
        gjpg.addActionListener(this);
        mg.add(gjpg);
        gpng = new JMenuItem("Guardar png");
        gpng.addActionListener(this);
        mg.add(gpng);
        ggif = new JMenuItem("Guardar gif");
        ggif.addActionListener(this);
        mg.add(ggif);
        gjpeg = new JMenuItem("Guardar jpeg");
        gjpeg.addActionListener(this);
        mg.add(gjpeg);
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        m1.add(salir);
        m2 = new JMenu("Edicion");
        m2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mb.add(m2);
        copy = new JMenuItem("Copiar");
        m2.add(copy);
        cut = new JMenuItem("Cortar");
        m2.add(cut);
        paste = new JMenuItem("Pegar");
        m2.add(paste);
        mm = new JMenu("Más");
        mm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mb.add(mm);
        ayuda = new JMenuItem("Ayuda");
        ayuda.addActionListener(this);
        mm.add(ayuda);
        info = new JMenuItem("Info");
        info.addActionListener(this);
        mm.add(info);
    }

    //Panel 1
    public void panel1() {
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder("HERRAMIENTAS DE DIBUJO"));
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(new Color(1, 152, 117));
        gro = new JLabel("Grosor");
        sl = new JSlider();
        sl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl.setMaximum(1);
        sl.setMaximum(30);
        sl.setBackground(Color.red);
        regre = new JButton();
        regre.addActionListener(this);
        regre.setIcon(new ImageIcon(this.getClass().getResource("/imagen/line.png")));
        regre.setBackground(Color.white);
        panel1.add(regre);
        linea = new JButton();
        linea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        linea.addActionListener(this);
        linea.setIcon(new ImageIcon(this.getClass().getResource("/imagen/lineac.png")));
        linea.setBackground(Color.white);
        panel1.add(linea);
        triangulo = new JButton();
        triangulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        triangulo.addActionListener(this);
        triangulo.setIcon(new ImageIcon(this.getClass().getResource("/imagen/triangle.png")));
        triangulo.setBackground(Color.white);
        panel1.add(triangulo);
        rectangulo = new JButton();
        rectangulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rectangulo.addActionListener(this);
        rectangulo.setIcon(new ImageIcon(this.getClass().getResource("/imagen/rect.png")));
        rectangulo.setBackground(Color.white);
        panel1.add(rectangulo);
        rombo = new JButton();
        rombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rombo.addActionListener(this);
        rombo.setIcon(new ImageIcon(this.getClass().getResource("/imagen/rombo.png")));
        rombo.setBackground(Color.white);
        panel1.add(rombo);
        pentagono = new JButton();
        pentagono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pentagono.addActionListener(this);
        pentagono.setIcon(new ImageIcon(this.getClass().getResource("/imagen/pent.png")));
        pentagono.setBackground(Color.white);
        panel1.add(pentagono);
        circulo = new JButton();
        circulo.addActionListener(this);
        circulo.setIcon(new ImageIcon(this.getClass().getResource("/imagen/circle.png")));
        circulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        circulo.setBackground(Color.white);
        panel1.add(circulo);
        estrella = new JButton();
        estrella.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        estrella.addActionListener(this);
        estrella.setIcon(new ImageIcon(this.getClass().getResource("/imagen/star.png")));
        estrella.setBackground(Color.white);
        panel1.add(estrella);
        panel1.add(gro);
        panel1.add(sl);
        colfig = new JButton("Color figura");
        colfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        colfig.setIcon(new ImageIcon(this.getClass().getResource("/imagen/colfig.png")));
        colfig.addActionListener(this);
        colfig.setBackground(Color.white);
        panel1.add(colfig);
        colfon = new JButton("Color fondo");
        colfon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        colfon.setIcon(new ImageIcon(this.getClass().getResource("/imagen/colfon.png")));
        colfon.addActionListener(this);
        colfon.setBackground(Color.white);
        panel1.add(colfon);
        relleno = new JButton();
        relleno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        relleno.setIcon(new ImageIcon(this.getClass().getResource("/imagen/fill.png")));
        relleno.addActionListener(this);
        relleno.setBackground(Color.white);
        panel1.add(relleno);

        abstracto = new JButton();
        abstracto.setIcon(new ImageIcon(this.getClass().getResource("/imagen/da.png")));
        abstracto.setBackground(Color.white);
        abstracto.addActionListener(this);
        panel1.add(abstracto);
        sl.setPreferredSize(new Dimension(150, 30));
        sl.setBackground(Color.white);
        sl.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                valor = sl.getValue();
                panel.setGro(valor);
            }

        });

        add(panel1, BorderLayout.NORTH);

    }

    //Panel2
    public void panel2() {
        panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        panel2.setBackground(Color.WHITE);
        panel.setBounds(0, 65, 1360, 768);
        this.add(panel, BorderLayout.CENTER);

        add(panel2, BorderLayout.CENTER);
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    static public void captureScreen(String fileName, int a, int b, String tipo) throws Exception {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(0, 150, a, b - 190);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "jpg", new File(fileName));

    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mn) {
            nuevo = true;
            panel.setBackground(Color.WHITE);
            panel.setNuevo(nuevo);
        }
        if (e.getSource() == ma) {
            File archivo;
            int res;
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG Y PNG", "jpg", "png", "gif","jpeg");
            JFileChooser buscar = new JFileChooser();
            buscar.setFileFilter(filtro);
            res = buscar.showOpenDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                String fil = buscar.getSelectedFile().getPath();
                ImageIcon icon = new ImageIcon(fil);
                img = icon.getImage();
                String ext = getFileExtension(buscar.getSelectedFile());
                panel.setExt(ext);
                fig = "Imagen";
            }
        }

        if (e.getSource() == gjpg) {
            try {
                JFileChooser archivo = new JFileChooser();
                FileNameExtensionFilter jpg = new FileNameExtensionFilter("jpg", "png", "gif", "jpeg");
                archivo.setFileFilter(jpg);
                int r = archivo.showSaveDialog(this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    Thread.currentThread().sleep(500);
                    String FILENAME = archivo.getSelectedFile() + ".jpg";
                    PAINTMUSKI.captureScreen(FILENAME, panel.getWidth(), panel.getHeight(), "jpg");
                    File f = archivo.getSelectedFile();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == gjpeg) {
            try {
                JFileChooser archivo = new JFileChooser();
                FileNameExtensionFilter jpg = new FileNameExtensionFilter("jpg", "png", "gif", "jpeg");
                archivo.setFileFilter(jpg);
                int r = archivo.showSaveDialog(this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    Thread.currentThread().sleep(500);
                    String FILENAME = archivo.getSelectedFile() + ".jpeg";
                    PAINTMUSKI.captureScreen(FILENAME, panel.getWidth(), panel.getHeight(), "jpg");
                    File f = archivo.getSelectedFile();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == gpng) {
            try {
                JFileChooser archivo = new JFileChooser();
                FileNameExtensionFilter jpg = new FileNameExtensionFilter("jpg", "png", "gif", "jpeg");
                archivo.setFileFilter(jpg);
                int r = archivo.showSaveDialog(this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    Thread.currentThread().sleep(500);
                    String FILENAME = archivo.getSelectedFile() + ".png";
                    PAINTMUSKI.captureScreen(FILENAME, panel.getWidth(), panel.getHeight(), "jpg");
                    File f = archivo.getSelectedFile();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == ggif) {
            try {
                JFileChooser archivo = new JFileChooser();
                FileNameExtensionFilter jpg = new FileNameExtensionFilter("jpg", "png", "gif", "jpeg");
                archivo.setFileFilter(jpg);
                int r = archivo.showSaveDialog(this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    Thread.currentThread().sleep(500);
                    String FILENAME = archivo.getSelectedFile() + ".gif";
                    PAINTMUSKI.captureScreen(FILENAME, panel.getWidth(), panel.getHeight(), "jpg");
                    File f = archivo.getSelectedFile();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == ayuda) {
            JOptionPane.showMessageDialog(rootPane, "Contacte a ´ibarra.perez.16062@itsmante.edu.mx´ para ayuda", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == info) {
            JOptionPane.showMessageDialog(rootPane, "Creado por André Ibarra Pérez", "Creador", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == salir) {
            System.exit(0);
        }

        if (e.getSource() == colfon) {
            JColorChooser Selectorcolor = new JColorChooser();
            cfon = Selectorcolor.showDialog(null, "Seleccione un color de fondo", panel2.getBackground());
            panel.setBackground(cfon);
            colfon.setBackground(cfon);
        }

        if (e.getSource() == colfig) {
            JColorChooser Selectorcolor = new JColorChooser();
            cfon = Selectorcolor.showDialog(null, "Seleccione un color de fondo", panel2.getBackground());
            color = cfon;
            colfig.setBackground(color);
        }

        if (e.getSource() == relleno) {
            if (c == 0) {
                re = true;
                c = 1;
                relleno.setText("Si");
            } else {
                re = false;
                c = 0;
                relleno.setText("No");
            }
        }

        if (e.getSource() == borrador) {
            fig = "Borrador";
            
        }

        if (e.getSource() == circulo) {
            fig = "Circulo";
            System.out.println(circulo.getSize());
            System.out.println(circulo.getBounds());
        }

        if (e.getSource() == rectangulo) {
            fig = "Rectangulo";
        }

        if (e.getSource() == pentagono) {
            fig = "Pentagono";
        }

        if (e.getSource() == triangulo) {
            fig = "Triangulo";
        }

        if (e.getSource() == linea) {
            fig = "Linea";
        }

        if (e.getSource() == estrella) {
            fig = "Estrella";
        }

        if (e.getSource() == rombo) {
            fig = "Rombo";
        }

        if (e.getSource() == regre) {
            fig = "LineToLine";
        }

        if (e.getSource() == abstracto) {
            if (a == 0) {
                da = true;
                a = 1;
                abstracto.setText("Si");
            } else {
                da = false;
                a = 0;
                abstracto.setText("No");
            }

        }
        panel.setFig(fig);
        panel.setColor(color);
        panel.setRe(re);
        panel.setDa(da);
        panel.setImg(img);
    }

    public void Rectangulo() {
        panel2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }
        });
        panel2.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {

            }
        }
        );
    }

    //Main
    public static void main(String[] args) {
        PAINTMUSKI mos = new PAINTMUSKI();
        mos.setVisible(true);

    }
}
