
package Cartas;

import Estados.EInicial;
import java.io.Serializable;
import projecto.Jogo;
import projecto.UserInterface;


public class CSPesadelo extends CSonho implements Serializable{
    
    
    //construtor
    public CSPesadelo(){
        super(5); //5 -> cor = pesadelo
    }
    
    public int getTipo(){
        return -1;
    }
    
    
    public void pesadelo(Jogo j){
        UserInterface ui = new UserInterface(j);
        
        //para ir buscar a função de comprar cartas do inicio do jogo
        EInicial aux = new EInicial(j);
        
        ui.ComprouPesadelo(); //comprou um pesadelo
        
        //descartar a mao
        for(int i=0; i<j.getMao().size(); i++){
            j.getEliminadas().add( j.getMao().get(i)); //colocar carta nas eliminadas
        }
        j.getMao().clear();//apagar cartas da mao
        
        //comprar as cartas como no inicio do jogo
        aux.comprar_carta();
        
        //EXPANSAO
         //eliminar uma torre se ainda n tiver a combinação
        if(j.getExpansao() == true){
            if(j.getTorres_ok() == false && !j.getTorres().isEmpty()){
                //so elimina uma torre se ainda n tiver a combinacao
                j.getEliminadas().add( j.getTorres().get(j.getTorres().size()-1) ); //adiciona a carta às eliminadas
                j.getTorres().remove( j.getTorres().size()-1 ); //elimina a ultima torre
            }  
        }
        
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