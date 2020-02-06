package paintmuski;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Dibujos extends Canvas implements MouseListener, MouseMotionListener {

    Point inicio, fin;
    Vector<Vec> v = new Vector<Vec>();
    String fig;
    Color color;
    int cont = 0;
    boolean regresar, nuevo;
    boolean re;
    int gro;
    int contador = 0;
    int i = 0;
    boolean da;
    Image img;
    String ext;
    int conta = 0;

    public Dibujos() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        if (nuevo == true) {
            v.clear();
            nuevo = false;
            repaint();
        }
        for (i = 0; i < v.size(); i++) {
            int x1 = v.get(i).getX1();
            int x2 = v.get(i).getX2();
            int y1 = v.get(i).getY1();
            int y2 = v.get(i).getY2();
            boolean r = v.get(i).isRe();
            int grosor = v.get(i).getGro();
            Image im = v.get(i).getImg();
            String ex = v.get(i).getExt();
            Color col = v.get(i).getColor();
            String opcion = v.get(i).getOpc();
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D g3 = (Graphics2D) g;
            g2.setColor(col);
            g2.setStroke(new BasicStroke(grosor));
            if (opcion.equals("Linea")) {
                g2.drawLine(x1, y1, x2, y2);
            }
            if (opcion.equals("Circulo")) {
                g2.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
                if (r == true) {
                    g2.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
                }
            }
            if (opcion.equals("Rectangulo")) {
                g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
                if (r == true) {
                    g2.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
                }
            }
            if (opcion.equals("Triangulo")) {
                int P1[] = {(x1), (x2), ((x2 + x1) / 2)};
                int P2[] = {(y2), (y2), (y1)};
                g2.drawPolygon(P1, P2, 3);
                if (r == true) {
                    g2.fillPolygon(P1, P2, 3);
                }
            }
            if (opcion.equals("Estrella")) {
                int px3 = x2 + y2 - y1;
                int py3 = y2;
                int px4 = x2;
                int py4 = y2 + (2 * (x2 - x1));
                int px5 = (px3 + x2) / 2;
                int py5 = py4 + y2 - y1;
                int px6 = x1;
                int py6 = (py4 + py5) / 2;
                int px7 = x1 - (px5 - x1);
                int py7 = py5;
                int px8 = x1 - (x2 - x1);
                int py8 = py4;
                int px9 = px8 + py8 - py7;
                int py9 = py3;
                int px10 = px8;
                int py10 = y2;
                int arr1[] = {x1, x2, px3, px4, px5, px6, px7, px8, px9, px10};
                int arr2[] = {y1, y2, py3, py4, py5, py6, py7, py8, py9, py10};
                g2.drawPolygon(arr1, arr2, 10);

                if (r == true) {
                    g2.fillPolygon(arr1, arr2, 10);
                }
            }
            if (opcion.equals("Pentagono")) {
                int d = x2 - x1;
                int arr1[] = {x2 - (d / 2), x2, x1, x1 - d, x1 - d + (d / 2)};
                int arr2[] = {y2, (y1 + y2) / 2, y1, (y1 + y2) / 2, y2};
                g2.drawPolygon(arr1, arr2, 5);
                if (r == true) {
                    g2.fillPolygon(arr1, arr2, 5);
                }
            }
            if (opcion.equals("Rombo")) {
                int d = x2 - x1;
                int arr1[] = {x2 - d, x2, x1, x1 - d, x1 - d + d};
                int arr2[] = {y2, (y1 + y2) / 2, y1, (y1 + y2) / 2, y2};
                g2.drawPolygon(arr1, arr2, 5);
                if (r == true) {
                    g2.fillPolygon(arr1, arr2, 5);
                }
            }
            if (opcion.equals("LineToLine")) {
                g2.drawLine(x1, y1, x2, y2);
            }
            if (opcion.equals("Imagen")) {
                g2.drawImage(im, x1, y1, x2, y2, null);
                if (ex.equals("gif")) {
                    repaint();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        inicio = new Point(e.getX(), e.getY());
        inicio.x = e.getX();
        inicio.y = e.getY();
        if (fig.equals("Linea") || fig.equals("Borrador")) {
            inicio = new Point(e.getX(), e.getY());
            inicio.x = e.getX();
            inicio.y = e.getY();
        }
        if (fig.equals("LineToLine")) {
            inicio = new Point(e.getX(), e.getY());
            inicio.x = e.getX();
            inicio.y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if (fin != null) {
            v.add(new Vec(inicio.x, inicio.y, fin.x, fin.y, fig, color, re, gro, img, ext));
            inicio = null;
            fin = null;
        } else if (fig.equals("Linea") || fig.equals("Borrador")) {
            inicio = null;
            fin = null;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        fin = new Point(e.getX(), e.getY());
        fin.x = e.getX();
        fin.y = e.getY();
        if (da == true) {
            v.add(new Vec(inicio.x, inicio.y, fin.x, fin.y, fig, color, re, gro, img, ext));
        } else {
            try {
                v.add(new Vec(inicio.x, inicio.y, fin.x, fin.y, fig, color, re, gro, img, ext));
                int ult = v.size() - 2;
                v.remove(ult);
            } catch (Exception ex) {
            }
        }
        repaint();
        if (fig.equals("Linea") || fig.equals("Borrador")) {
            fin = new Point(e.getX(), e.getY());
            fin.x = e.getX();
            fin.y = e.getY();
            inicio.x = fin.x;
            inicio.y = fin.y;
            v.add(new Vec(inicio.x, inicio.y, fin.x, fin.y, fig, color, re, gro, img, ext));
        }
        if (fig.equals("LineToLine")) {
            fin.x = e.getX();
            fin.y = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    public String getFig() {
        return fig;
    }

    public void setFig(String fig) {
        this.fig = fig;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRegresar() {
        return regresar;
    }

    public void setRegresar(boolean regresar) {
        this.regresar = regresar;
    }

    public boolean isRe() {
        return re;
    }

    public void setRe(boolean re) {
        this.re = re;
    }

    public int getGro() {
        return gro;
    }

    public void setGro(int gro) {
        this.gro = gro;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isDa() {
        return da;
    }

    public void setDa(boolean da) {
        this.da = da;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

}
