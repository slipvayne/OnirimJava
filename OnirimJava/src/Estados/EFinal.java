/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Cartas.Carta;
import java.io.Serializable;
import projecto.Jogo;

/**
 *
 * @author Diogo Emanuel
 */
public class EFinal implements Estados, Serializable{
    
    private Jogo j;
    
    public EFinal(Jogo jogo){
        j = jogo;
    }
    
    public void baralhar(){}
    public void descartar_carta(Carta c){}
    public void comprar_carta(){}
    public void jogar_carta(Carta c){}
    public void limpar_limbo(){}
    
    public void profecia(Carta c){}
    
    public int verificar_estado_jogo(){
        return -1;
    }
    
    
}
