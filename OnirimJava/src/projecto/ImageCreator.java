
package projecto;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;


public class ImageCreator implements Serializable{
    
    private String path;
    
    
    public ImageCreator(String s) {
        path = s;
    }
    
    public ImageIcon createImageIcon( ){
        ClassLoader cl = this.getClass().getClassLoader();
        java.net.URL imgURL = cl.getResource(path);

        if ( imgURL != null){
            return new ImageIcon( imgURL );
        }else{
            System.err.println(" Ficheiro não encontrado em: " + path);
            return null;
        }
    }
    
    public Image createImage(){
        return  createImageIcon().getImage();
    }
    
}
