
package Cartas;

import java.io.Serializable;


public class CLCamara extends CLabirinto implements Serializable{
    int tipo; //1-sol, 2-lua, 3-chave
    
    
    //construtor
    public CLCamara(int cor, int t){
        super(cor);
        tipo = t;
    }
    
    //GETS
    public int getTipo(){
        return tipo;
    }
    
    
    
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
