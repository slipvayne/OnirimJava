
package Estados;

import Cartas.CSPesadelo;
import Cartas.Carta;
import java.io.Serializable;
import projecto.Jogo;
import projecto.UserInterface;


public class EFase2 implements Estados, Serializable{
    
    private Jogo jogo;
    private UserInterface ui;
    
    
    public EFase2(Jogo j){
        jogo = j;
        ui = new UserInterface(j);
    }
    
    public void profecia(Carta c){}
    
    public void baralhar(){
        System.out.println("Nao pode baralhar na fase 2");
    }
    public void descartar_carta(Carta c){
        System.out.println("Nao pode descartar cartas na fase 2");
    }
    
    public void comprar_carta(){
        
        //comprar cartas ate ter 5 na mao
        //while(jogo.getMao().size() < 5){
        while(jogo.getMao().size() < 5 && jogo.getBaralho().isEmpty()==false){
         
            //se nao existirem mais cartas no baralho, PERDEU O JOGO
            if(jogo.getBaralho().isEmpty()){
                //PERDEU O JOGO
                ui.NaoHaCartasNoBaralho();
                
                //estado = EstadoFinal
                jogo.setEstadoActual( jogo.getEFinal());
                
                return;
            }
            
            ui.aComprarCartas();
            
                       
            
            //comprar carta
            jogo.getMao().add( jogo.getBaralho().get(jogo.getBaralho().size()-1) ); //colocar carta na mao
            jogo.getBaralho().remove(jogo.getBaralho().size()-1); //remover carta do baralho
            
            
            //verificar o tipo da carta
              //se a carta for um labirinto, simplesmente adiciona a carta à mão
           
            
            //se for uma porta
            if(jogo.getMao().get( jogo.getMao().size() - 1).getTipo() == 4){
               jogo.abrir_Porta(); //NOVO ESTADO?
            }
              
            
            //se for um sonho (pesadelo)
            if(jogo.getMao().get( jogo.getMao().size() - 1).getCor() == 5){ //cor 5 -> pesadelo
                //jogo.pesadelo();
                //criar uma carta pesadelo temporária para invocar o efeito do pesadelo
                CSPesadelo pesadelo_temp = new CSPesadelo();
                pesadelo_temp.pesadelo(jogo);
                
                //graças ao pesadelo fica com 5 cartas válidas
                // e avança para a fase 3
                
                
                jogo.setEstadoActual( jogo.getEFase3() );
                
                
                //return;
                
            }
                        
            
        } //fim while
        
        //avançar para a fase 3
        jogo.setEstadoActual( jogo.getEFase3() );
        
        //se tiver menos de 5 cartas na mão e se o baralho estiver vazio
          //perdeu
        //if(jogo.getMao().size() < 5 || jogo.getBaralho().isEmpty()){
        if(jogo.getMao().size() < 5 && jogo.getBaralho().isEmpty()){
            jogo.setEstadoActual( jogo.getEFinal());            
        }
        
    }
    
    public void jogar_carta(Carta c){
        System.out.println("Nao pode jogar cartas na fase 2");
    }
    
    
    public void limpar_limbo(){
        System.out.println("Nao pode mexer no limbo na fase 2");
    }
    
   public int verificar_estado_jogo(){
        //verificar derrota
          //o jogador perde se já nao existirem cartas no baralho
        if(jogo.getBaralho().isEmpty())
            return -1;
        
        //verificar vitoria
          //o jogador ganha quando todas as 8 portas tiverem sido abertas
        if(jogo.getPortas().size() == 8)
            return 1;
        
        return 0;
    }
    
    
}
