package paintmuski;

import java.awt.Color;
import java.awt.Image;

public class Vec {
    int x1,y1,x2,y2;
    String opc;
    Color color;
    boolean re;
    int gro;
    Image img;
    String ext;
    public Vec(){
        
    }
    public Vec(int x1,int y1,int x2,int y2,String opc,Color color,boolean re,int gro,Image img,String ext){
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setOpc(opc);
        setColor(color);
        setRe(re);
        setGro(gro);
        setImg(img);
        setExt(ext);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
