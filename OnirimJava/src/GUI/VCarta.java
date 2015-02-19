
package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;


public class VCarta implements Serializable{
    
    private String NomeImg;
    private ImageIcon imagem;
    private int x_inicial;
    private int y_inicial;
    private int x_final;
    private int y_final;
    private boolean selected;
    
    public VCarta(String s){
        NomeImg = s;
        imagem = createImageIcon();
        
        x_inicial = 0;
        y_inicial = 0;
        x_final = 0;
        y_final = 0;
    }
    
    
    public void desenhar(Graphics g, Component c){
        imagem.paintIcon(c, g, x_final, y_final);
    }
    
    public boolean contains(int x, int y) {
        return (x > x_final && x < (x_final + getLarguraImg()) && y > y_final && y < (y_final + getAlturaImg()));
    }
    
    
    public void move(int x, int y) {
        x_final = x_inicial - x;
        y_final = y_inicial - y;
    }
    
    public void reset() {
        x_final = x_inicial;
        y_final = y_inicial;
        
        selected = false;
    }
    
    
    private ImageIcon createImageIcon(){
        ClassLoader cl = this.getClass().getClassLoader();
        java.net.URL imgURL = cl.getResource("images\\" + NomeImg + ".png");

        if (imgURL != null){
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Não encontrou o ficheiro: " + NomeImg + ".png");
            return null;
        }
    }
    
    public Image createImage(){
        return  createImageIcon().getImage();
    }
    
    
//==== GETS E SETS ====
    
   //gets
   public ImageIcon getImagem(){
        return imagem;
   } 
   public String getNomeImg(){
       return NomeImg;
   }
   public int getX_inicial(){
       return x_inicial;
   }
   public int getY_inicial(){
       return y_inicial;
   }
   public int getX_final(){
       return x_final;
   }
   public int getY_final(){
       return y_final;
   }
   public boolean getSelected(){
       return selected;
   }
   
   
   public int getLarguraImg() {
        return imagem.getIconWidth();
    }
    
    public int getAlturaImg() {
        return imagem.getIconHeight();
    }
    
    
    //sets
    public void setImagem(ImageIcon img){
        imagem = img;
    }
    public void setNomeImg(String s){
        NomeImg = s;
    }
    public void setX(int n){
        x_inicial = n;
        x_final = n;
    }
    public void setY(int n){
        y_inicial = n;
        y_final = n;
    }
    public void setSelected(boolean s){
        selected = s;
    }
    
    
//=== FIM GETS E SETS ====
    
}
