
package projecto;

import Cartas.Carta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface implements Serializable{
    
    Jogo jogo; //para ter acesso às cartas
    
    public UserInterface(Jogo j){
        jogo = j;
    }
    
    //QUE CARTA VAI DESCARTAR DA MAO?
    public int QualCartaDescartarDaMao(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual o numero da carta a descartar?");
        for(int i=0; i<jogo.getMao().size(); i++){
            System.out.println((i+1) + "- " + jogo.getMao().get(i) );
        }
        do{
            op = in.nextInt();
        }while( (op<1) || (op>5) );
        
        return op;
    }
    
    //QUE CARTA VAI JOGAR?
    public int QualCartaJogar(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("Qual o numero da carta a jogar?");
        for(int i=0; i<jogo.getMao().size(); i++){
            System.out.println((i+1) + "- " + jogo.getMao().get(i) );
        }
        do{
            op = in.nextInt();
        }while( (op<1) || (op>jogo.getMao().size()) );
        
        return op;
    }    
    
    //QUAL A PROXIMA CARTA A METER NO BARALHO? (usado na profecia)
      //recebe a mao temporaria da profecia
    public int ProxCartaAMeterNoBaralho(ArrayList <Carta> mao_temp){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("Escolha a proxima carta a colocar no baralho:\n");
        //imprimir as cartas restantes
        for(int i=0; i<mao_temp.size(); i++)
            System.out.println((i+1) + "-" + mao_temp.get(i).toString() );
            
        do{
            op = in.nextInt();
        }while( (op<1) || (op>mao_temp.size()) );
     
        return op;
    }
    
    
    //QUER DESCARTAR UMA CHAVE PARA ABRIR A PORTA?
    public int DescartarChaveAbrirPorta(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("Quer descartar um chave para abrir a Porta? 1-Sim 0-Nao");
        do{
            op = in.nextInt();
        }while( (op<0) || (op>1));
        
        return op;
    }
    
    
    //COMPROU UM PESADELO
    public void ComprouPesadelo(){
        System.out.println("\nComprou um Pesadelo!\n");
    }
    
    //ESTA A TENTAR JOGAR UMA CARTA DA MESMA COR DE UMA PORTA QUE JÁ FOI ABERTA 2x
    public void NaoPodeJogarCartaPorquePortasJaAbertas(){
        System.out.println("Nao pode jogar essa carta, pois todas as portas dessa cor ja foram abertas!");
        System.out.println("\nEscolha outra carta de cor diferente.\n");
    }
    
    //APRESENTACAO INICIAL
    public void OnirimSplash(){
        System.out.println("o============================================o");
        System.out.println("|x                                          x|");
        System.out.println("|   OOOOO   N     N  I  RRRR   I  M       M  |");
        System.out.println("|  O     O  NN    N     R   R     MM     MM  |");
        System.out.println("|  O     O  N N   N  I  R   R  I  M M   M M  |");
        System.out.println("|  O     O  N  N  N  I  RRRR   I  M  M M  M  |");
        System.out.println("|  O     O  N   N N  I  R  R   I  M   M   M  |");
        System.out.println("|  O     O  N    NN  I  R   R  I  M       M  |");
        System.out.println("|   OOOOO   N     N  I  R   R  I  M       M  |");
        System.out.println("|x                                          x|");
        System.out.println("o============================================o");    
    }
    
    //A BARALHAR...
    public void aBaralhar(){
        System.out.println("A baralhar cartas...\n");
    }
    
    //A COMPRAR CARTAS
    public void aComprarCartas(){
        System.out.println("A comprar cartas...\n");
    }
    
    //A VERIFICAR LIMBO
    public void aVerificarLimbo(){
        System.out.println("A verificar limbo...\n");
    }
    
    //QUER JOGAR OU DESCARTAR UMA CARTA?
    public int JogarOuDescartar(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1- Jogar carta");
        System.out.println("2- Descartar carta");
        System.out.println("3- Ver cartas na mesa");
        System.out.println("4- Ver portas abertas");
        System.out.println("5- Ver cartas eliminadas");
        System.out.println("6- Ver cartas no limbo");
        System.out.println("7- Usar cheats");
        
        do{
            op = in.nextInt();
        }while((op<1) || (op>7));
    
        return op;
    }
    
    //APENAS PODE DESCARTAR CARTAS PQ A SUA MAO SO CONTEM CARTAS COM CORES DE PORTAS JÁ ABERTAS 2x
    public void NaoPodeJogarCarta(){
        System.out.println("Nao pode jogar cartas, pois a sua mao so contem cartas com cores de portas ja abertas 2 vezes");
    }
    
    //SO PODE JOGAR CARTAS DE TIPOS DIFERENTES
    public void NaoPodeJogarCartaCorDiferenteTipoIgual(){
        System.out.println("Para poder jogar uma carta, estas tem de ser de tipo diferente da anterior. (a nao ser que a mesa esteja vazia)\n");
    }
    
    //VER MAO DO JOGADOR
    public void imprime_mao(){
        System.out.println("Cartas na mao:");
        for(int i=0; i<jogo.getMao().size(); i++)
            System.out.println(i+1 + " - " + jogo.getMao().get(i));
    }
            
    //VER PILHA DE CARTAS ELIMINADAS
    public void imprime_eliminadas(){
        System.out.println("\nCartas eliminadas:");
        if(jogo.getEliminadas().isEmpty())
            System.out.println("-Nao existem cartas eliminadas\n");
        for(int i=0; i<jogo.getEliminadas().size(); i++)
            System.out.println(i+1 + " - " + jogo.getEliminadas().get(i));
    }
            
    //VER LISTA DE PORTAS JA ABERTAS
    public void imprime_portas(){
        System.out.println("\nPortas ja abertas:");
        if(jogo.getPortas().isEmpty())
            System.out.println("-Nao existem portas abertas\n");
        for(int i=0; i<jogo.getPortas().size(); i++)
            System.out.println(i+1 + " - " + jogo.getPortas().get(i));
    }
    
    //VER CARTAS NA MESA
    public void imprime_mesa(){
        System.out.println("\nCartas na mesa:");
        if(jogo.getMesa().isEmpty())
            System.out.println("-A mesa nao tem cartas\n");
        for(int i=0; i<jogo.getMesa().size(); i++)
            System.out.println(i+1 + " - " + jogo.getMesa().get(i));
    }
    
    //VER CARTAS NO LIMBO
    public void imprime_limbo(){
        System.out.println("\nCartas no limbo:");
        if(jogo.getLimbo().isEmpty())
            System.out.println("-O limbo esta vazio\n");
        for(int i=0; i<jogo.getLimbo().size(); i++)
            System.out.println(i+1 + " - " + jogo.getLimbo().get(i));
    }
    
    
    
    //ACTIVOU UMA PROFECIA
    public void activou_profecia(){
        System.out.println("\nActivou uma Profecia!\n");
        System.out.println("Cartas do topo do baralho:");
    }
 
    
    //QUE CARTA VAI DESCARTAR? (PROFECIA)
     //recebe a mao temporaria da profecia
    public int QualCartaDescartarProfecia(ArrayList <Carta> mao_temp){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual o numero da carta a descartar?");
        for(int i=0; i<mao_temp.size(); i++){
            System.out.println((i+1) + "- " + mao_temp.get(i) );
        }
        do{
            op = in.nextInt();
        }while( (op<1) || (op>mao_temp.size()) );
        
        return op;
    }
    
    
    //FASE 1
    public void Fase1(){
        System.out.println("\n\n=== FASE 1 ===\n\n");
    }
    
    //FASE 2
    public void Fase2(){
        System.out.println("\n\n=== FASE 2 ===\n\n");
    }
    
    //FASE 3
    public void Fase3(){
        System.out.println("\n\n=== FASE 3 ===\n\n");
    }    
    
    //PARABENS VENCEU!
    public void vitoria(){
        System.out.println("\n\n=== PARABENS! VENCEU!===\n\n");
    }
    
    //PERDEU O JOGO
    public void derrota(){
        System.out.println("\n\n=== PERDEU... Nao existem mais cartas no baralho... ===\n\n");
    }
    
    //JA NAO EXISTEM CARTAS NO BARALHO
    public void NaoHaCartasNoBaralho(){
        System.out.println("Ja nao ha cartas no baralho...\n");
    }
    
    //ENCONTROU UMA PORTA
    public void EncontrouUmaPorta(){
        System.out.println("\nEncontrou uma porta!\n");
    }
    
    //AS CORES DAS CARTAS TEM DE SER IGUAIS
    public void CartaCorDiferente(){
        System.out.println("\nAs cores das cartas têm de ser iguais para a poder jogar\n");
    }
    
    //COMPROU UMA PORTA MAS NAO TEM CHAVES VALIDAS PARA A ABRIR
    public void ComprouPortaMasNaoTemChave(){
        System.out.println("Comprou uma porta, mas nao tem nenhuma chave valida para a abrir...\n");
    }
    
    
    //COMPROU UMA PORTA DE CERTA COR
    public void ComprouPorta(Carta porta){
        if(porta.getCor() == 1)
            System.out.println("Comprou uma porta vermelha\n");
        else if(porta.getCor() == 2)
            System.out.println("Comprou uma porta azul\n");
        else if(porta.getCor() == 3)
            System.out.println("Comprou uma porta verde\n");
        else if(porta.getCor() == 4)
            System.out.println("Comprou uma porta castanha\n");
    }
    
    //CHEATS -> QUAL O TIPO DA CARTA QUE QUER ADICIONAR?
    public int Cheats_QualTipoCartaAdicionar(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual o tipo da carta que quer adicionar?");
        System.out.println("1-Camara");
        System.out.println("2-Porta");
        System.out.println("3-Pesadelo");
        
        do{
            op = in.nextInt();
        }while( (op<1) || (op>3) );
        
        return op;
    }
    
    //CHEATS -> QUAL A COR DA CARTA QUE QUER ADICIONAR?
    public int Cheats_QualCorCartaAdicionar(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual a cor da carta?");
        System.out.println("1-Vermelho");
        System.out.println("2-Azul");
        System.out.println("3-Verde");
        System.out.println("4-Castanho");
        
        do{
            op = in.nextInt();
        }while( (op<1) || (op>4) );
        
        return op;
    }
    
    //CHEATS -> QUAL O SUBTIPO DA CARTA QUE QUER ADICIONAR?
    public int Cheats_QualSubTipoCartaAdicionar(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual o subtipo da carta?");
        System.out.println("1-Sol");
        System.out.println("2-Lua");
        System.out.println("3-Chave");
        
        do{
            op = in.nextInt();
        }while( (op<1) || (op>3) );
        
        return op;
    }
    
    //ADICIONADA CAMARA -COR- -SUBTIPO- A -LOCAL-
    public void AdicionadaCamaraCorSubtipo(int cor, int subtipo,int local){
        String s;
        
        s = "Adicionada Camara ";
        
        if(cor==1)
            s += "vermelha ";
        if(cor==2)
            s += "azul ";
        if(cor==3)
            s += "verde ";
        if(cor==4)
            s += "castanha ";
        
        if(subtipo==1)
            s+= "sol ";
        if(subtipo==2)
            s+= "lua ";
        if(subtipo==3)
            s+= "chave ";
        
        if(local==1)
            s+= "a mao.";
        if(local==2)
            s+= "ao topo do baralho.";
        if(local==3)
            s+= "a mesa.";
        
        System.out.println(s);
    }
    
    //ADICIONADA PORTA -COR- A -LOCAL-
    public void AdicionadaPortaCor(int cor, int local){
        String s;
        
        s = "Adicionada Porta ";
        
        if(cor==1)
            s += "vermelha ";
        if(cor==2)
            s += "azul ";
        if(cor==3)
            s += "verde ";
        if(cor==4)
            s += "castanha ";
        
        if(local==1)
            s+= "a mao.";
        if(local==2)
            s+= "ao topo do baralho.";
        if(local==3)
            s+= "a lista de portas.";
        
        System.out.println(s);
        
    }

    //ADICIONADO PESADELO A -LOCAL-
    public void AdicionadoPesadelo(int local){
        String s="";
        
        if(local==1)
            s = "Adicionado Pesadelo a mao";
        if(local==2)
            s = "Adicionado Pesadelo ao topo do baralho";
        if(local==3)
            s = "Nao pode meter Pesadelos na mesa";
        
        System.out.println(s);
        
    }
    
    //QUAL CHEAT QUER?
    public int escolherCheat(){
        Scanner in = new Scanner(System.in);
        int op=0;
        
        System.out.println("\nQual a cheat que quer usar?");
        System.out.println("1-Ver 7 cartas do topo do baralho");
        System.out.println("2-Adicionar uma carta a mao");
        System.out.println("3-Adicionar uma carta ao topo do baralho");
        System.out.println("4-Adicionar uma carta a mesa");
        
        do{
            op = in.nextInt();
        }while( (op<1) || (op>4) );
        
        return op;
    }        
    
}
