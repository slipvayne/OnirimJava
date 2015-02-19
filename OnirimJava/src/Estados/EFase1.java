
package Estados;

import Cartas.CLCamara;
import Cartas.Carta;
import java.io.Serializable;
import projecto.Jogo;
import projecto.UserInterface;

public class EFase1 implements Estados, Serializable{
    
    
    private Jogo jogo;
    private UserInterface ui;
    
    public EFase1(Jogo j){
        jogo = j;
        ui = new UserInterface(j);
    }
    
    
    public void profecia(Carta c){}

    public void baralhar(){ 
        System.out.println("Nao pode baralhar na fase 1");
    }
    
    
    public void descartar_carta(Carta c){
        //int op; //index da carta escolhida para descartar pelo utilizador
        
        //perguntar qual carta vai descartar
        //op = ui.QualCartaDescartarDaMao() - 1; //-1 para acertar com o array
        
        //EXPANSAO
        //se a carta for uma torre -> profeciaTorre()
        if(c.getTipo() == 7){
            int tam = jogo.getBaralho().size();
            if(tam > 5)
                tam = 5;
            
            tam = c.getNumeroTorre();
            
            jogo.getProfecia().clear();
            //adicionar cartas à profecia da torre
            for(int i=0; i<tam; i++){
                //jogo.getProfeciaTorres().add(jogo.getBaralho().get( jogo.getBaralho().size() - 1 - i));
                jogo.getProfecia().add(jogo.getBaralho().get( jogo.getBaralho().size() - 1 - i));
            }
            //remover cartas do baralho
            for(int i=0; i<tam; i++){
                jogo.getBaralho().remove( jogo.getBaralho().size() -1);
            }
            //descartar carta
            for(int i=0; i<jogo.getMao().size(); i++){
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) && (jogo.getMao().get(i).getNumeroTorre() == c.getNumeroTorre())){
                    jogo.getEliminadas().add(jogo.getMao().get(i)); //copiar carta para as eliminadas         
                    jogo.getMao().remove(i);                        //remover carta da mao
                    //mudar para o estado da profeciaTorre
                    jogo.setEstadoActual( jogo.getEProfeciaTorres() );
                    //chamar a profecia
                    //jogo.profecia();
                    return;
                }
            }
        }
        
        
        //se a carta for uma chave -> profecia();
        //if(jogo.getMao().get(op).getTipo() == 3){
        if(c.getTipo() == 3){
            //jogo.profecia();
            //carta temporaria, apenas para usar a profecia
            //CLCamara profecia_temp = new CLCamara(0,0);
            //profecia_temp.profecia(jogo);
            
            int tam = jogo.getBaralho().size();
            if(tam > 5)
                tam = 5;
            
            jogo.getProfecia().clear();
            //adicionar cartas à profecia
            for(int i=0;i<tam;i++){
                jogo.getProfecia().add(jogo.getBaralho().get( jogo.getBaralho().size() - 1 - i )); //adicionar carta de topo à profecia             
            }
            //remover cartas do baralho
            for(int i=0;i<tam;i++){
                jogo.getBaralho().remove( jogo.getBaralho().size()-1 ); //remover a carta do topo
            }
                      
            //descartar carta
            for(int i=0; i<jogo.getMao().size(); i++){
                //if( (jogo.getMao().get(i).getCor() == jogo.getMao().get(op).getCor()) && (jogo.getMao().get(i).getTipo() == jogo.getMao().get(op).getTipo()) ){     
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) ){ 
                    jogo.getEliminadas().add(jogo.getMao().get(i)); //copiar carta para as eliminadas         
                    jogo.getMao().remove(i);                        //remover carta da mao
                    //mudar para o estado da profecia
                    jogo.setEstadoActual( jogo.getEProfecia() );
                    //chamar a profecia
                    //jogo.profecia();
                    return;
                }
            }
        }
        
        //descartar carta
        for(int i=0; i<jogo.getMao().size(); i++){
            //if( (jogo.getMao().get(i).getCor() == jogo.getMao().get(op).getCor()) && (jogo.getMao().get(i).getTipo() == jogo.getMao().get(op).getTipo()) ){     
            if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) ){ 
                jogo.getEliminadas().add(jogo.getMao().get(i)); //copiar carta para as eliminadas         
                jogo.getMao().remove(i);                        //remover carta da mao
                
                //meter praqui a verificar se é profecia e mudar o estado para profeica
                
                //avançar para a fase 2
                jogo.setEstadoActual( jogo.getEFase2() );
                
                return;
            }
        }
        
        
    }
    
    
    public void comprar_carta(){
        System.out.println("Nao pode comprar cartas na fase 1");
    }
    
    
    public void jogar_carta(Carta c){
        //int op; //index da carta escolhida para jogar pelo utilizador
        
          
        
        
        
        
        //===EXPANSÃO===
        //se for uma TORRE
      if(c.getTipo() == 7){
        if(jogo.getTorres().isEmpty()){
            //pode jogar, nao ha cartas de torre na mesa
            for(int i=0; i<jogo.getMao().size(); i++){                           
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) && (jogo.getMao().get(i).getNumeroTorre() == c.getNumeroTorre())){
                    jogo.getTorres().add(jogo.getMao().get(i)); //copiar a carta para a mesa         
                    jogo.getMao().remove(i);                  //apagar a carta da mao
                    //return true;            //a carta foi jogada com sucesso
                    //avançar para a Fase2
                    jogo.setEstadoActual( jogo.getEFase2() );
                    return;
                }
            } 
        }
        
        //jogar para a direita
        if(jogo.getTorres().get(jogo.getTorres().size()-1).getLua_d()==true && c.getLua_e() == true)
            return;
        else if(jogo.getTorres().get(jogo.getTorres().size()-1).getSol_d()==true && c.getSol_e() == true)
            return;
        else { //pode jogar
            for(int i=0; i<jogo.getMao().size(); i++){
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) && (jogo.getMao().get(i).getNumeroTorre() == c.getNumeroTorre())){
                    jogo.getTorres().add(jogo.getMao().get(i)); //copiar a carta para as torres na mesa         
                    jogo.getMao().remove(i);                  //apagar a carta da mao
                    jogo.bloquearTorres();          //se for a 4ª torre de cor diferente, bloqueia as torres
                    //return true;            //a carta foi jogada com sucesso
                    //avançar para a Fase2
                    jogo.setEstadoActual( jogo.getEFase2() );
                    return;
                }
            }
        }
        
        /*
        //jogar para a esquerda
        if(jogo.getTorres().get(0).getLua_e()==true && c.getLua_d() == true)
            return;
        else if(jogo.getTorres().get(0).getSol_e()==true && c.getSol_d() == true)
            return;
        else { //pode jogar
            for(int i=0; i<jogo.getMao().size(); i++){
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo()) && (jogo.getMao().get(i).getNumeroTorre() == c.getNumeroTorre())){
                    jogo.getTorres().add(0, jogo.getMao().get(i)); //copiar a carta para as torres na mesa         
                    jogo.getMao().remove(i);                  //apagar a carta da mao
                    jogo.bloquearTorres();          //se for a 4ª torre de cor diferente, bloqueia as torres
                    //return true;            //a carta foi jogada com sucesso
                    //avançar para a Fase2
                    jogo.setEstadoActual( jogo.getEFase2() );
                    return;
                }
            }
        }
        */
        
      }
        //=====FIM EXPANSÃO ====
        
        
        //perguntar qual carta vai jogar
        //op = ui.QualCartaJogar() - 1; //-1 para acertar com o array
        
        
        if(jogo.getMesa().isEmpty()){
            //pode jogar, nao ha cartas na mesa
            for(int i=0; i<jogo.getMao().size(); i++){
                //if( (jogo.getMao().get(i).getCor() == jogo.getMao().get(op).getCor()) && (jogo.getMao().get(i).getTipo() == jogo.getMao().get(op).getTipo()) ){                            
                if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo())){
                    jogo.getMesa().add(jogo.getMao().get(i)); //copiar a carta para a mesa         
                    jogo.getMao().remove(i);                  //apagar a carta da mao
                    //return true;            //a carta foi jogada com sucesso
                    //avançar para a Fase2
                    jogo.setEstadoActual( jogo.getEFase2() );
                    return;
                }
            } 
        }
        
        
            //if( jogo.getMesa().get(jogo.getMesa().size()-1).getTipo() != jogo.getMao().get(op).getTipo() ){
            if( jogo.getMesa().get(jogo.getMesa().size()-1).getTipo() != c.getTipo() ){ 
                for(int i=0; i<jogo.getMao().size(); i++){
                    //if( (jogo.getMao().get(i).getCor() == jogo.getMao().get(op).getCor()) && (jogo.getMao().get(i).getTipo() == jogo.getMao().get(op).getTipo()) ){          
                    if( (jogo.getMao().get(i).getCor() == c.getCor()) && (jogo.getMao().get(i).getTipo() == c.getTipo())){
                        jogo.getMesa().add(jogo.getMao().get(i)); //copiar a carta para a mesa          
                        jogo.getMao().remove(i);                  //apagar a carta da mao
                        jogo.buscar_Porta();                      //se ja for a 3a carta, vai buscar um porta
                        //return true;                              //a carta foi jogada com sucesso
                        //avançar para a Fase2
                        jogo.setEstadoActual( jogo.getEFase2() );
                        return;
                    
                    }
                }
            }
            
                
        
            //SE TODAS AS PORTAS FORAM ABERTAS, VENCEU
            //if(jogo.getPortas().size() == 8)
            //    jogo.setEstadoActual( jogo.getEFinal() );
            
            //avançar para a Fase2
            //jogo.setEstadoActual( jogo.getEFase2() );
        //return false; //não pode jogar
    }

    
    public void limpar_limbo(){
        System.out.println("Nao pode mexer no limbo na fase 1");
    }
    
    
    public int verificar_estado_jogo(){
        //o jogador nao pode perder nesta fase
        
        //verificar vitoria
          //o jogador ganha quando todas as 8 portas tiverem sido abertas
        if(jogo.getPortas().size() == 8)
            return 1;
        
        return 0;
    }
    
}