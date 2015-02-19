
package Estados;

import Cartas.Carta;
import java.io.Serializable;
import projecto.Jogo;


public class EProfecia implements Estados, Serializable{
    
    private Jogo j;
    
    public EProfecia(Jogo jogo){
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
        /*UserInterface ui = new UserInterface(j);
        
        int aux=5;        
        Scanner in = new Scanner(System.in);
        int op=0;
        ArrayList <Carta> mao_temp = new ArrayList<Carta>();
        
        
        ui.activou_profecia();
        
        //se o baralho estiver vazio
        if(j.getBaralho().isEmpty())
            return;
        
        if(j.getBaralho().size()<5) //se o baralho tiver menos de 5 cartas
            aux = j.getBaralho().size();
        
        //ver 5 cartas no topo do baralho
        for(int i=0; i<aux; i++){
            //copiar cartas para uma "mao temporaria"
            mao_temp.add(j.getBaralho().get((j.getBaralho().size()-1)-i));
            
            //remover estas cartas do baralho
            j.getBaralho().remove((j.getBaralho().size()-1)-i);
            
            
            //imprimir cartas
            System.out.println((i+1) + "-" + mao_temp.get(i).toString() );
            
        }
        
        //so sai do ciclo quando for descartada uma carta válida
        while(true){
            //perguntar qual carta vai descartar
            op = ui.QualCartaDescartarProfecia(mao_temp);
        
            //descartar a carta escolhida pelo user (menos portas)
            if(mao_temp.get(op-1).getTipo() != 4){
                j.getEliminadas().add( mao_temp.get(op-1) );  //adicionar carta descartada às eliminadas
                mao_temp.remove(op-1); //remover carta da mao temporaria
                break; //sair do ciclo
            }else{
                System.out.println("Nao pode descartar portas! Escolha outra carta.\n");
            }
        
        }
        //coloca-las no baralho outra vez pela ordem que o user quer (topo)
        System.out.println("-Escolha a ordem para colocar as cartas de novo no baralho.\n");
        do{
            op = ui.ProxCartaAMeterNoBaralho(mao_temp);
            
            j.getBaralho().add(mao_temp.get(op-1)); //devolver carta ao baralho
            mao_temp.remove(op-1);          //remover carta da mao_temp
            
                    
        }while(mao_temp.isEmpty() == false); //enquanto existirem cartas na mao_temp
        
        
        //mudar de estado para a FASE 2
        j.setEstadoActual( j.getEFase2() );
        */
        
        if(j.getProfecia().size()== 5)
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
        {
            j.getBaralho().add(c);
            j.getProfecia().remove(c);
        }
        
        if(j.getProfecia().isEmpty())           //se nao houverem mais cartas na profecia
            j.setEstadoActual(j.getEFase2());   //passar para a fase 2
        
    }
    
    
}
