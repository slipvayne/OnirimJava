
package projecto;

import GUI.Modelo;
import GUI.VistaJogo;


public class Projecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Jogo j = new Jogo(false); //criar jogo normal
        
        //j.jogar(); //iniciar jogo com UI de texto
        
        Modelo m = new Modelo(j);
        new VistaJogo(m);
          
    }
}
