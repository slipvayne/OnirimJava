
package Estados;

import Cartas.Carta;
import java.io.Serializable;
import java.util.Collections;
import projecto.Jogo;
import projecto.UserInterface;


public class EFase3 implements Estados, Serializable{
    
    private Jogo jogo;
    private UserInterface ui;
    
    
    public EFase3(Jogo j){
        jogo = j;
        ui = new UserInterface(j);
    }    
    
    public void profecia(Carta c){}
    
    public void baralhar(){
        //baralhar cartas do baralho
        Collections.shuffle(jogo.getBaralho());
    }
    
    public void descartar_carta(Carta c){
        System.out.println("Nao pode descartar cartas na fase 3");
    }
    public void comprar_carta(){
        System.out.println("Nao pode comprar cartas na fase 3");
    }
    public void jogar_carta(Carta c){
        System.out.println("Nao pode jogar cartas na fase 3");
    }

    public void limpar_limbo(){
        //se existirem cartas no limbo
        if(jogo.getLimbo().isEmpty() == false){
            //mover todas as cartas do limbo para o baralho
            for(int i=0; i<jogo.getLimbo().size(); i++){
                jogo.getBaralho().add( jogo.getLimbo().get(i)); //colocar carta do limbo no baralho                     
            }
            jogo.getLimbo().clear(); //remover cartas do limbo
            baralhar();              //baralhar baralho
        }
        
        //voltar para a Fase 1
        jogo.setEstadoActual( jogo.getEFase1() );
        
    }
    
    public int verificar_estado_jogo(){
        //verificar derrota
          //o jogador nao pode perder nesta fase
        
        //verificar vitoria
         //o jogador nao pode ganhar nesta fase
        
        System.out.println("Nao pode ganhar nem perder nesta fase");
        return 0;
    }
    
    
    
}
