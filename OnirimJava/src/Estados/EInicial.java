
package Estados;

import Cartas.Carta;
import java.io.Serializable;
import java.util.Collections;
import projecto.Jogo;
import projecto.UserInterface;


public class EInicial implements Estados, Serializable{
    
    private Jogo jogo;
    private UserInterface ui;
    
    
    public EInicial(Jogo j){
        jogo = j;
        ui = new UserInterface(j);
    }
    
    public void profecia(Carta c){}
    
    public void baralhar(){
        //baralhar cartas do baralho
        Collections.shuffle(jogo.getBaralho());
    }
    
    public void descartar_carta(Carta c){
        System.out.println("Nao pode descartar cartas na fase inicial");
    }
    
    public void comprar_carta(){
        
        baralhar();
        
        //enquanto nao tiver 5 cartas na mao e existirem cartas no baralho
        while(jogo.getMao().size() < 5 && jogo.getBaralho().isEmpty()==false){

            
            if(jogo.getBaralho().isEmpty())
                System.out.println("O baralho está vazio!\n");
            
            //adicionar carta à mão do topo do baralho
            jogo.getMao().add( jogo.getBaralho().get( jogo.getBaralho().size() - 1) );
            
            //remover carta do baralho
            jogo.getBaralho().remove( jogo.getBaralho().size() - 1 );
            
            //se a carta comprada for um sonho OU uma porta
            if( (jogo.getMao().get( jogo.getMao().size() -1 ).getCor() == 5) || (jogo.getMao().get( jogo.getMao().size() -1 ).getTipo() == 4) ){
                                
                //enviar carta para o limbo
                jogo.getLimbo().add( jogo.getMao().get( jogo.getMao().size() -1) );
                //remover carta da mao
                jogo.getMao().remove( jogo.getMao().get( jogo.getMao().size() -1) );
            }
            
        } //fim while
        
        
        //se tiver menos de 5 cartas na mão e se o baralho estiver vazio
          //perdeu
        if(jogo.getMao().size() < 5 && jogo.getBaralho().isEmpty()){
            jogo.setEstadoActual( jogo.getEFinal());   
            return;
        }
        
        
        limpar_limbo();
        //jogo.setEstadoActual = EstadoAJogar FASE 1
        jogo.setEstadoActual(jogo.getEFase1());
        
        

        
    }
    
    public void jogar_carta(Carta c){
        System.out.println("Nao pode jogar cartas na fase inicial");
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
    }
    
    public int verificar_estado_jogo(){
        System.out.println("É impossivel ter ganho na fase inicial, deve estar a fazer batota!");
        return 0;
    }

}
