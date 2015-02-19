
package Estados;

import Cartas.Carta;
import java.io.Serializable;
import projecto.Jogo;


public class EProfeciaTorres implements Estados, Serializable{
    
    private Jogo j;
    
    public EProfeciaTorres(Jogo jogo){
        j = jogo;
    }
    
    public void baralhar(){};
    //public void descartar_carta(Carta c){}
    public void comprar_carta(){}
    public void jogar_carta(Carta c){}
    public void limpar_limbo(){}

    public int verificar_estado_jogo(){
        return -1;
    }
    
    //apenas chaves devem usar esta funcao
    //public void profecia(Jogo j){
    public void profecia(Carta c){}
    
    
    public void descartar_carta(Carta c){
        
        
        /*if(j.getProfecia().size()== 5)
        {
            //se for uma porta, esta deve ir para o limbo e não para as eliminadas
            if(c.getTipo()==4){
                j.getLimbo().add(c);
                j.getProfecia().remove(c);
            }else{
                j.getEliminadas().add(c);
                j.getProfecia().remove(c);
            }
        }else
        {*/
            j.getBaralho().add(c);
            j.getProfecia().remove(c);
        //}
        
        if(j.getProfecia().isEmpty())           //se nao houverem mais cartas na profecia
            j.setEstadoActual(j.getEFase2());   //passar para a fase 2
        
    }
    
    
}