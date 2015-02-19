
package projecto;

import Cartas.*;
import java.io.Serializable;
import java.util.ArrayList;


public class Cheats implements Serializable{
    private Jogo jogo;
    private UserInterface ui;
    
    public Cheats(Jogo j){
        jogo = j;
        ui = new UserInterface(j);
    }
    
    //visualizar o conteudo das proximas 7 cartas do baralho
    //public void verCartasTopoBaralho(){
    public String verCartasTopoBaralho(){
        
        int aux = 7;
        ArrayList <Carta> mao_temp = new ArrayList<Carta>();
        String lista_cartas="";
        
        //se o baralho estiver vazio
        if(jogo.getBaralho().isEmpty())
            return "Baralho vazio";
        
        if(jogo.getBaralho().size()<7) //se o baralho tiver menos de 7 cartas
            aux = jogo.getBaralho().size();
        
        //ver 5 cartas no topo do baralho
        for(int i=0; i<aux; i++){
            //copiar cartas para um array temporario
            mao_temp.add(jogo.getBaralho().get((jogo.getBaralho().size()-1)-i));

            //imprimir cartas
            //System.out.println((i+1) + "-" + mao_temp.get(i).toString() );
            lista_cartas += (i+1) + "-" + mao_temp.get(i).toString() + "\n";
        }
        
        return lista_cartas;
    }
    
    //acrescentar uma determinada carta à mao do jogador
    /*public void addCartaMao(){
        int tipo;
        int subtipo; //chave, sol, lua
        int cor=0;
        
        //perguntar qual carta e a cor
        tipo = ui.Cheats_QualTipoCartaAdicionar(); //qual o tipo da carta?
        
        if(tipo!=3){ //se a carta nao for um pesadelo
            cor = ui.Cheats_QualCorCartaAdicionar(); //qual a cor da carta?
        }
        
        //criar carta
        if(tipo==1){
            //camara
            subtipo = ui.Cheats_QualSubTipoCartaAdicionar();
            jogo.getMao().add(new CLCamara(cor,subtipo)); //porta vermelha
            ui.AdicionadaCamaraCorSubtipo(cor, subtipo, 1);
        }else if(tipo==2){
            //porta
            jogo.getMao().add(new CPorta(cor));
            ui.AdicionadaPortaCor(cor, 1);
            //usar efeito da porta
            jogo.abrir_Porta();
        }else if(tipo==3){
            //pesadelo
            jogo.getMao().add(new CSPesadelo());
            ui.AdicionadoPesadelo(1);
            //usar efeito do pesadelo
            CSPesadelo pesadelo_temp = new CSPesadelo();
            pesadelo_temp.pesadelo(jogo);
            //jogo.pesadelo(); 
        }      
        
    }*/
    
    public void addTorreBaralho(int cor, int numero){
        if(jogo.getExpansao()==true){
            jogo.getBaralho().add( new CLTorre(cor, numero));
        }
    }
    
    public void addCartaMao(int tipo, int subtipo, int cor){ 
         //criar carta
         if(tipo==1){
             //camara
             jogo.getMao().add(new CLCamara(cor,subtipo));
         }else if(tipo==2){
             //porta
             jogo.getMao().add(new CPorta(cor));
             //efeito porta
         }else if(tipo==3){
             //pesadelo
             jogo.getMao().add(new CSPesadelo());
             //usar efeito do pesadelo
             CSPesadelo pesadelo_temp = new CSPesadelo();
             pesadelo_temp.pesadelo(jogo);
             
         }   
     }
    
    
     public void addCartaBaralho(int tipo, int subtipo, int cor){ 
         //criar carta
         if(tipo==1){
             //camara
             jogo.getBaralho().add(new CLCamara(cor,subtipo));
         }else if(tipo==2){
             //porta
             jogo.getBaralho().add(new CPorta(cor));
         }else if(tipo==3){
             //pesadelo
             jogo.getBaralho().add(new CSPesadelo());
         }   
     }
    
    //acrescentar uma determinada carta ao topo do baralho
    /*public void addCartaBaralho(){
        int tipo;
        int subtipo; //chave, sol, lua
        int cor=0;
        
        //perguntar qual carta e a cor
        tipo = ui.Cheats_QualTipoCartaAdicionar(); //qual o tipo da carta?
        
        if(tipo!=3){ //se a carta nao for um pesadelo
            cor = ui.Cheats_QualCorCartaAdicionar(); //qual a cor da carta?
        }
        
        //criar carta
        if(tipo==1){
            //camara
            subtipo = ui.Cheats_QualSubTipoCartaAdicionar();
            jogo.getBaralho().add(new CLCamara(cor,subtipo)); //porta vermelha
            ui.AdicionadaCamaraCorSubtipo(cor, subtipo, 2);
        }else if(tipo==2){
            //porta
            jogo.getBaralho().add(new CPorta(cor));
            ui.AdicionadaPortaCor(cor, 2);
        }else if(tipo==3){
            //pesadelo
            jogo.getBaralho().add(new CSPesadelo());
            ui.AdicionadoPesadelo(2);
        }      
        
    }
*/

     public void addCartaMesa(int tipo, int subtipo, int cor){ 
         //criar carta
         if(tipo==1){
             //camara
             jogo.getMesa().add(new CLCamara(cor,subtipo));
             jogo.buscar_Porta();
         }else if(tipo==2){
             //porta
             jogo.getPortas().add(new CPorta(cor));
         }
     }
     
    //acrescentar uma determinada carta à mesa de jogo 
   /* public void addCartaMesa(){
        int tipo;
        int subtipo; //chave, sol, lua
        int cor=0;
        
        //perguntar qual carta e a cor
        tipo = ui.Cheats_QualTipoCartaAdicionar(); //qual o tipo da carta?
        
        if(tipo!=3){ //se a carta nao for um pesadelo
            cor = ui.Cheats_QualCorCartaAdicionar(); //qual a cor da carta?
        }
        
        
        //criar carta
        if(tipo==1){
            
            
            //camara
            subtipo = ui.Cheats_QualSubTipoCartaAdicionar();
            
            
            if( jogo.getMesa().isEmpty()){
                jogo.getMesa().add(new CLCamara(cor,subtipo)); //adicionar porta à mesa
                ui.AdicionadaCamaraCorSubtipo(cor, subtipo, 3);
                jogo.buscar_Porta();
                return;
            }
            
     
            //filtrar carta
            if( (jogo.getMesa().get( jogo.getMesa().size() - 1).getCor() == cor) && (jogo.getMesa().get( jogo.getMesa().size() - 1).getTipo() != subtipo) ){
                jogo.getMesa().add(new CLCamara(cor,subtipo)); //adicionar porta à mesa
                ui.AdicionadaCamaraCorSubtipo(cor, subtipo, 3);
                jogo.buscar_Porta();
            }else{
                ui.NaoPodeJogarCartaCorDiferenteTipoIgual();
            }
        }else if(tipo==2){
            //porta
            jogo.getPortas().add(new CPorta(cor));
            ui.AdicionadaPortaCor(cor, 3);
        }else if(tipo==3){
            //pesadelo
            ui.AdicionadoPesadelo(3);
        }      
        
    }  */  
//=====FIM CHEATS =========
    
    
    
}
