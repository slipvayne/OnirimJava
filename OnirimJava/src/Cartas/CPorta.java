
package Cartas;

import java.io.Serializable;


public class CPorta extends Carta implements Serializable{
    
    
    //construtor
    public CPorta(int cor){
        super(cor);
    }
    
    public int getTipo(){
        return 4;
    };
    
    
    //usado apenas nas torres
    public boolean getSol_e(){
        return false;
    }
    public boolean getSol_d(){
        return false;
    }
    public boolean getLua_e(){
        return false;
    }
    public boolean getLua_d(){
        return false;
    }
    public int getNumeroTorre(){
        return -1;
    }
    
    
    
}
