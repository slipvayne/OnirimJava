
package GUI;

import Cartas.Carta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import projecto.Jogo;


public class Modelo extends Observable implements Serializable{
    
    private Jogo jogo;
    
    public Modelo(Jogo j){
        jogo = j;
        
    }
    
    
    //jogar carta
    public void jogar(Carta c){
        
        jogo.jogar_carta(c); //FASE 1
        
        jogo.comprar_carta(); //FASE 2
        
        jogo.limpar_limbo(); //FASE 3
        
        
        setChanged();
        notifyObservers();  
    }
    
    //descartar carta
    public void descartar(Carta c){
        
        jogo.descartar_carta(c); //FASE 1
        
        jogo.comprar_carta(); //FASE 2
        
        jogo.limpar_limbo(); //FASE 3  
        
        
        setChanged();
        notifyObservers();  
    }
    
 
    
//====== SETS ======
    public void setJogo(Jogo j){
        jogo = j;
    }
    
    
    
//=====FIM SETS ====
    
    
//====== GETS ======
    public Jogo getJogo(){
        return jogo;
    }
    public ArrayList<Carta> getBaralho(){
        return jogo.getBaralho();
    }
    public ArrayList<Carta> getLimbo(){
        return jogo.getLimbo();
    }
    public ArrayList<Carta> getEliminadas(){
        return jogo.getEliminadas();
    }
    public ArrayList<Carta> getMesa(){
        return jogo.getMesa();
    }
    public ArrayList<Carta> getMao(){
        return jogo.getMao();
    }
    public ArrayList<Carta> getPortas(){
        return jogo.getPortas();
    }
    public ArrayList<Carta> getProfecia(){
        return jogo.getProfecia();
    }
    public ArrayList<Carta> getTorres(){
        return jogo.getTorres();
    }
    
 //=== FIM GETS ===
    
}
