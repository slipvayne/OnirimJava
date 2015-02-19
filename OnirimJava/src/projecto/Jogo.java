
package projecto;

import Cartas.*;
import Estados.Estados;
import Estados.EInicial;
import Estados.EFase3;
import Estados.EFase2;
import Estados.EFase1;
import Estados.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class Jogo implements Serializable{
    
    private ArrayList <Carta> baralho = new ArrayList<Carta>();
    private ArrayList <Carta> limbo = new ArrayList<Carta>();
    private ArrayList <Carta> eliminadas = new ArrayList<Carta>();
    private ArrayList <Carta> mesa = new ArrayList<Carta>();
    private ArrayList <Carta> mao = new ArrayList<Carta>();
    private ArrayList <Carta> portas = new ArrayList<Carta>();
    private ArrayList <Carta> profecia = new ArrayList<Carta>();
    
    //expansão
    private ArrayList <Carta> torres = new ArrayList<Carta>();
    //não é preciso pq usa-se na mesma a variavel da profecia
    //private ArrayList <Carta> profeciaTorres = new ArrayList<Carta>();
    
    //definir estados
    private Estados EActual;
    private Estados EAnterior;
    private EInicial EInicial = new EInicial(this);
    private EFase1 EFase1 = new EFase1(this);
    private EFase2 EFase2 = new EFase2(this);
    private EFase3 EFase3 = new EFase3(this);
    private EProfecia EProfecia = new EProfecia(this);
    
    private EFinal EFinal = new EFinal(this);
    
    //expansao
    private EProfeciaTorres EProfeciaTorres = new EProfeciaTorres(this);
    private boolean expansao = false;
    private boolean torres_ok = false; //se tiver a true, então o pesadelo
                                       //ja nao pode descartar torres e já
                                       //se pode vencer o jogo
    
    
    private UserInterface ui;
    private Cheats cheats;
    
    
    public Jogo(boolean exp){
        
        //criar baralho
        criar_Pesadelos();
        criar_Portas();
        criar_Camaras();
        
        
        //jogo com expancao
        if(exp==true){
            expansao = true;
            criar_Torres(); //adicionar torres ao baralho
        }
        
        //set estado actual = estadoinicial
        setEstadoActual(EInicial);
        //estado_actual.comprar() (comprar cartas no estado inicial)
        //implementar as funcs lá debaixo e depois meter só comprar_carta();
        EActual.comprar_carta();
        
        
        ui = new UserInterface(this);
        cheats = new Cheats(this);
        
    }
    
//====== EXPANSAO TORRES =========
    //adicionar as (12) torres ao baralho (3 de cada cor, 3 de cada numero)
    public void criar_Torres(){
        //torres vermelhas
        baralho.add( new CLTorre(1,3));
        baralho.add( new CLTorre(1,4));
        baralho.add( new CLTorre(1,5));
        //torres azuis
        baralho.add( new CLTorre(2,3));
        baralho.add( new CLTorre(2,4));
        baralho.add( new CLTorre(2,5));
        //torres verdes
        baralho.add( new CLTorre(3,3));
        baralho.add( new CLTorre(3,4));
        baralho.add( new CLTorre(3,5));
        //torres castanhas
        baralho.add( new CLTorre(4,3));
        baralho.add( new CLTorre(4,4));
        baralho.add( new CLTorre(4,5));
    }
    
    //gets
    public ArrayList<Carta> getTorres(){
        return torres;
    }
    //não é preciso porque usa-se na mesma a var. da profecia
    /*public ArrayList<Carta> getProfeciaTorres(){
        return profeciaTorres;
    }*/
    public boolean getTorres_ok(){
        return torres_ok;
    }
    public void setTorres_ok(boolean b){
        torres_ok = b;
    }
    public EProfeciaTorres getEProfeciaTorres(){
        return EProfeciaTorres;
    }
    public boolean getExpansao(){
        return expansao;
    }
    public void bloquearTorres(){
        
        if(torres.size() >= 4){
            
            if( torres.get(torres.size() - 1).getCor() != torres.get( torres.size() - 2).getCor() )
                if( torres.get(torres.size() - 1).getCor() != torres.get( torres.size() - 3).getCor() )
                    if( torres.get(torres.size() - 1).getCor() != torres.get( torres.size() - 4).getCor() )
                        torres_ok = true; // ja tem 4 torres de cores diferentes
        }
    }
    
//====== FIM EXPANSAO TORRES =====
    
    
    
  
//=======ADICIONAR CARTAS =======
    
    //adicionar as (10) cartas de pesadelo ao baralho
    public void criar_Pesadelos(){
        for(int i=0; i<10; i++)
            baralho.add(new CSPesadelo());
    }
    
    //adicionar as (8) portas ao baralho (2 de cada cor)
    public void criar_Portas(){
        for(int i=0; i<2; i++){         //criar 2 portas de cada
            baralho.add(new CPorta(1)); //porta vermelha
            baralho.add(new CPorta(2)); //porta azul
            baralho.add(new CPorta(3)); //porta verde
            baralho.add(new CPorta(4)); //porta castanha
        }
    }
    
    //adicionar as (58) cartas de labirinto (camaras)
    public void criar_Camaras(){ 
        //criar camaras sol vermelhas (9)
        for(int i=0; i<9; i++){
            baralho.add(new CLCamara(1,1));
        }
        //criar camaras sol azuis (8)
        for(int i=0; i<8; i++){
            baralho.add(new CLCamara(2,1));
        }        
        //criar camaras sol verdes (7)
         for(int i=0; i<7; i++){
            baralho.add(new CLCamara(3,1));
        }       
        //criar camaras sol castanhas (6)
        for(int i=0; i<6; i++){
            baralho.add(new CLCamara(4,1));
        }         
         
        //criar cartas lua(4 de cada cor)
        for(int i=0; i<4; i++){
            baralho.add(new CLCamara(1,2)); //vermelhas
            baralho.add(new CLCamara(2,2)); //azuis
            baralho.add(new CLCamara(3,2)); //verdes
            baralho.add(new CLCamara(4,2)); //castanhas
        }
        
        //criar cartas chave(3 cada cor)
        for(int i=0; i<3; i++){
            baralho.add(new CLCamara(1,3)); //vermelhas
            baralho.add(new CLCamara(2,3)); //azuis
            baralho.add(new CLCamara(3,3)); //verdes
            baralho.add(new CLCamara(4,3)); //castanhas
        }   
    }
        
//=====FIM ADICIONAR CARTAS =====
   

//===== EFEITOS DE CARTAS ====== 
    
    //vai buscar a porta correspondente à cor das cartas na mesa
    public void buscar_Porta(){
        int num_cartas = 0; //numero de cartas da mesma cor na mesa
        int num_portas = 0; //numero de portas abertas da cor da ultima carta jogada
        int num_cartas_necessarias = 3; //n de cartas necessarias para abrir uma porta
                                        //3 se existirem 0 portas, 6 se existir 1 porta
        
   
        //percorrer toda a mesa
        for(int i=0; i<mesa.size(); i++){
            //se a carta actual for da cor da ultima carta jogada
            if(mesa.get(i).getCor() == mesa.get( mesa.size() - 1).getCor()){
                num_cartas++;
            }
        }
        
        //saber quantas portas desta cor já foram abertas
        for(int i=0; i<portas.size(); i++){
            //se não existirem portas abertas, sai do for
            if(portas.isEmpty())
                break;
            
            //se a cor da porta actual for igual à cor da ultima carta jogada
            if(portas.get(i).getCor() == mesa.get( mesa.size() - 1).getCor())
                num_portas++;
        }
        
        if(num_portas == 1)
            num_cartas_necessarias = 6;
        
        //se existirem (3 + (3 * NUMERO_DE_PORTAS_ABERTAS_DA_MESMA_COR)) cartas da mesma cor da ultima
        //so deverá abrir a porta se as ultimas 3 cartas forem da mesma cor
        if(num_cartas >= num_cartas_necessarias){
            if(mesa.get(mesa.size() -1).getCor() == mesa.get(mesa.size() -2).getCor()){
                if(mesa.get(mesa.size() -1).getCor()== mesa.get(mesa.size() -3).getCor()){
            
            
                    //percorrer todo o baralho
                    for(int i=0; i<baralho.size(); i++){
                        //se a carta tiver a mesma cor da ultima carta jogada E se a carta for uma porta
                        if( (baralho.get(i).getCor() == mesa.get( mesa.size() - 1).getCor()) && (baralho.get(i).getTipo() == 4) ){
                            portas.add( baralho.get(i) ); //adicionar porta ao array de portas
                            baralho.remove(i);            //remover porta do baralho
                            Collections.shuffle(baralho); //baralhar baralho
                            return;
                        }
                    }
                }
            }
        }
        
          
    }
    
    
    //identifica se o utilizador comprou uma porta e pergunta-lhe se a quer abrir (se tiver uma chave valida)
    public void abrir_Porta(){
        
        boolean aux; //usada para saber se o user tem uma chave valida na mao false-nao, true-sim
        
        //se for uma porta
        if(mao.get( mao.size() - 1).getTipo() == 4){
            ui.ComprouPorta(mao.get( mao.size() - 1)); //imprimir a cor da porta
                
            aux = false; //reset da variavel aux.
                
            //ver se o jogador tem uma chave da mesma cor da porta na mao
            for(int i=0; i<mao.size(); i++){
                // se o tipo da carta for uma chave(3) E a cor da carta for igual à da porta
                if( (mao.get(i).getTipo() == 3) && (mao.get(i).getCor() == mao.get( mao.size() - 1).getCor()) )
                    aux = true; //tem uma chave valida na mao
            }
                
            //se tiver uma chave valida, perguntar ao user se a quer usar pra abrir a porta
            if(aux == true){
                for(int i=0; i<mao.size(); i++){
                // se o tipo da carta for uma chave(3) E a cor da carta for igual à da porta
                    if( (mao.get(i).getTipo() == 3) && (mao.get(i).getCor() == mao.get( mao.size() - 1).getCor()) ){
                        //if( ui.DescartarChaveAbrirPorta() == 1){ //1 - quer descartar
                            portas.add( mao.get( mao.size() - 1) ); //adicionar porta da mao ao array de portas
                            eliminadas.add(mao.get(i));             //adicionar chave ao array de cartas eliminadas
                            mao.remove(i);                                    //remover carta chave da mao
                            mao.remove( mao.size() - 1 );           //remover a porta da mao
                            //a porta é a ultima carta da mao (o utilizador acabou de a tirar do baralho)
                            break; //sair do for
                        /*}else{ //utilizador não quer descartar a chave para abrir a porta
                            //colocar a porta no limbo
                            limbo.add( mao.get( mao.size() - 1 ) );
                            //remover porta da mao
                            mao.remove( mao.size() - 1 );
                            break; //sair do for
                        }*/
                    }//fim if
                }//fim for
            }else{ //nao tem uma chave valida para abrir a porta
                ui.ComprouPortaMasNaoTemChave();
                //colocar a porta no limbo
                limbo.add( mao.get( mao.size() - 1 ) );
                //remover porta da mao
                mao.remove( mao.size() - 1 );
            }
        }//se for uma porta (fim if)            
    
    }
    
//=====FIM EFEITOS DE CARTAS ====
  
 
/*
//===== CLASSE PRINCIPAL DO JOGO ==========
    
    //jogar
    public void jogar(){
        
        int op=0; //para as opções de interface
        int aux=0; //usada quando o utilizador quer jogar uma carta invalida (cor diferente e/ou tipo igual)
        
        //definir maquina de estados
        Estados estado;
        EInicial eInicial = new EInicial(this);
        EFase1 eFase1 = new EFase1(this);
        EFase2 eFase2 = new EFase2(this);
        EFase3 eFase3 = new EFase3(this);
        
        //definir o estado inicial
        estado = eInicial;
        
        ui.OnirimSplash(); //mostrar logotipo inicial
        
        //====FASE INICIAL====
        //estado.baralhar();          //baralhar as cartas do baralho
        //ui.aBaralhar();
        
        estado.comprar_carta();     //comprar cartas ate ter uma mao de 5 cartas válidas (apenas labirintos)
        ui.aComprarCartas();
        
        //estado.limpar_limbo();      //passar todas as cartas do limbo de novo para o baralho e baralha-lo
        //i.aVerificarLimbo();
        
        //so sairá do ciclo assim que ganhar/perder
        while(true){
            //====FASE 1=====
            estado = eFase1;
            ui.Fase1();
            
            ui.imprime_mao();
            
            //enquanto nao jogar ou descartar uma carta, ou jogar/descartar uma carta valida (aux=0 valida, aux=-1 nao valida)
            while( (op>2) || (op<1) || (aux==-1)){
                
                aux=0; //reset da variavel auxiliar
                
                //verificar a mao do jogador para ver se tem cartas repetidas 
                //NAO É NECESSARIO
                /*if( verificar_mao() == true){ //pode jogar
                    op = ui.JogarOuDescartar();
                }else{
                    op = ui.JogarOuDescartar();
                    if(op==1){
                        ui.NaoPodeJogarCarta();//nao pode jogar (apenas pode descartar)
                        op = 0;
                    }
                }*/
                /*
                op = ui.JogarOuDescartar();
     
                switch(op){
                    case 1: //jogar carta
                        
                        if(estado.jogar_carta() == true){ //jogou a carta
                            break;
                        }else{                             //nao pode jogar a carta
                            ui.NaoPodeJogarCartaCorDiferenteTipoIgual();
                            aux=-1; //carta nao valida; vai mostrar de novo as opções ao user
                            break;
                        }    
                    case 2: //descartar carta
                        estado.descartar_carta();
                        break;
                    case 3: //ver mesa
                        ui.imprime_mesa();
                        break;
                    case 4://ver portas
                        ui.imprime_portas();
                        break;
                    case 5: //ver eliminadas
                        ui.imprime_eliminadas();
                        break;
                    case 6: //ver limbo
                        ui.imprime_limbo();
                        break;
                    case 7: //usar cheats
                        int op_cheat=0;
                        op_cheat = ui.escolherCheat();
                        switch(op_cheat){
                            case 1: //ver 7 cartas do topo do baralho
                                cheats.verCartasTopoBaralho();
                                break;
                            case 2: //adicionar carta à mao
                                cheats.addCartaMao();
                                break;
                            case 3: //adicionar carta ao topo do baralho
                                cheats.addCartaBaralho();
                                break;
                            case 4: //adicionar carta à mesa
                                cheats.addCartaMesa();
                                break;
                        }
                        break; //switch principal
                }
                
            }//fim while
            
            op = 0; //reset da variavel das opções do jogador
            
            //verificar vitoria
            if( estado.verificar_estado_jogo() == 1){
                ui.vitoria();
                break;
            }
                
            //====fase 2=====
            estado = eFase2;
            ui.Fase2();
            
            ui.imprime_mao();
            
            estado.comprar_carta();
            
            //verificar derrota e vitoria
            if( estado.verificar_estado_jogo() == 1){
                ui.vitoria();
                break;
            }
            else if(estado.verificar_estado_jogo() == -1){
                ui.derrota();
                break;
            }
            
            //====fase 3=====
            estado = eFase3;
            ui.Fase3();
            
            ui.aVerificarLimbo();
            
            estado.limpar_limbo();
            
        }//fim while
    }
    
//===== FIM CLASSE PRINCIPAL DO JOGO ======
 */   
    
    
    
    
//===== GETS ======
    public ArrayList<Carta> getBaralho() {
        return baralho;
    }

    public ArrayList<Carta> getEliminadas() {
        return eliminadas;
    }

    public ArrayList<Carta> getLimbo() {
        return limbo;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public ArrayList<Carta> getMesa() {
        return mesa;
    }
    
    public ArrayList<Carta> getPortas() {
        return portas;
    }
    
    public ArrayList<Carta> getProfecia() {
        return profecia;
    }
     
//===== FIM GETS =====


//===== ESTADOS ======
    
    //GETS ESTADOS
    
    public EFase1 getEFase1() {
        return EFase1;
    }

    public EFase2 getEFase2() {
        return EFase2;
    }

    public EFase3 getEFase3() {
        return EFase3;
    }

    public EInicial getEInicial() {
        return EInicial;
    }
    
    public EProfecia getEProfecia() {
        return EProfecia;
    }
    
    public EFinal getEFinal() {
        return EFinal;
    }

    public Estados getEstado_actual() {
        return EActual;
    }

    public Estados getEstado_anterior() {
        return EAnterior;
    }
    
    //SETS ESTADOS
    
    public void setEstadoActual(Estados est){
        EAnterior = EActual;
        EActual = est;   
        
        /*if(EActual == EFinal)
        {
            Modelo m_temp = new Modelo(this);
            Tabuleiro t_temp = new Tabuleiro(m_temp);
            
            t_temp.setVista_actual("Final");
                    
            //System.exit(0);
        }*/
           
    }

    
//===== FIM ESTADOS ==

//=====FUNÇÕES DOS ESTADOS ====
    
    
    public void jogar_carta(Carta c){
        EActual.jogar_carta(c);
    }
    
    public void comprar_carta(){
        EActual.comprar_carta();
    }
    
    public void descartar_carta(Carta c){
        EActual.descartar_carta(c);
    }
    
    public void baralhar(){
        EActual.baralhar();
    }
    public void limpar_limbo(){
        EActual.limpar_limbo();
    }
    
    
    public void profecia(Carta c){
        EActual.profecia(c);
    }
    
    /*public void termina(){
        EActual.termina();
    }
    */
    
//=====FIM FUNÇÕES DOS ESTADOS ====
    
    
}