
package Cartas;

import java.io.Serializable;


public abstract class Carta implements Serializable{
    
    private int cor; //1-vermelho; 2-azul; 3-verde; 4-castanho; 5-pesadelo
    //tipo das camaras -> 1-sol, 2-lua, 3-chave, (4-porta)
    
    
    //construtor
    public Carta(int c){
        cor = c;
    }
    
    
    //GETS
    public int getCor(){
        return cor;
    }
    
     //torres
    abstract public boolean getSol_e();
    abstract public boolean getSol_d();
    abstract public boolean getLua_e();
    abstract public boolean getLua_d();
    abstract public int getNumeroTorre();
    
    
    //SETS
    public void setCor(int c){
        cor = c;
    }
    
    
    abstract public int getTipo();
    
    

    @Override
    public String toString() {
        String texto_cor = "";
        String texto_tipo = "";
        if(this.getCor()==1)
            texto_cor = "vermelha";
        else if(this.getCor()==2)
            texto_cor = "azul";
        else if(this.getCor()==3)
            texto_cor = "verde";
        else if(this.getCor()==4)
            texto_cor = "castanha";
        else if(this.getCor()==5)
            texto_cor = "pesadelo";
        
        if(this.getTipo()==1)
            texto_tipo = "sol";
        else if(this.getTipo()==2)
            texto_tipo = "lua";
        else if(this.getTipo()==3)
            texto_tipo = "chave";
        else if(this.getTipo()==4)
            texto_tipo = "porta";
        else if(this.getTipo()==7)
            texto_tipo = "torre";
        
        
        if(this.getCor()!=5)
            return "Carta{ " + "cor=" + texto_cor + " tipo=" + texto_tipo + " }";
        else //é um pesadelo
            return "Carta{ " + "pesadelo }";
    }
            
}
