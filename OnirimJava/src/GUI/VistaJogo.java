
package GUI;

import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;



public class VistaJogo extends JFrame implements Observer, MouseListener, MouseMotionListener, Serializable{
    
    //public final static int LARGURA = 800;
    //public final static int ALTURA = 600;
    //public final static int LARGURA = 1024;
    //public final static int ALTURA = 900;
    public final static int LARGURA = 1000;
    public final static int ALTURA = 750;
    
    Modelo modelo;
    static Tabuleiro tabuleiro;
    
    private boolean arrastada;
    private VCarta carta;
    private int click_x;
    private int click_y;
    
    
//===CONSTRUTORES ===
    
    public VistaJogo(Modelo m){
        this(m, 10, 10, LARGURA, ALTURA);
    }
    
    public VistaJogo(Modelo m, int x, int y, int largura, int altura){
        //super("Onirim - O Jogo");
        
        modelo = m;
        m.addObserver(this);
        
        
        arrastada = false;
        
        
        tabuleiro = new Tabuleiro(modelo); //criar objectos
        this.add(tabuleiro);               //criar layout
        
        //listeners
        //addMouseListener(this);
        //addMouseMotionListener(this);
        registaListeners();
        
        //janela
        setLocation(x, y);
        setSize(largura, altura);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle("Onirim - O Jogo");
            
        
        //PARA TESTES
        /*JMenuBar barraMenu = new JMenuBar();
        JMenu cheats = new JMenu("Cheats");
        JMenu Cheats_adicionarCartaMesa = new JMenu("Mesa"); 
        JMenuItem Cheats_verCartas = new JMenuItem("Ver cartas");
        
        barraMenu.add(cheats);
        cheats.add(Cheats_verCartas);
        

        this.setJMenuBar(barraMenu); //barra de menus
        */
        //criar a barra de menus
        VBarraMenu BarraMenu = new VBarraMenu(m, this);
        BarraMenu.CriarMenu(this);
        
        
        update(modelo, null);
        validate();
        
                   
    }
    
    
    
    private void registaListeners(){
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    
    
    public void update(Observable o, Object arg){
        
        tabuleiro.getVBaralho().update(modelo.getBaralho().size());
        tabuleiro.getVLimbo().update(modelo.getLimbo().size());
        tabuleiro.getVEliminadas().update(modelo.getEliminadas().size());
        tabuleiro.getVMesa().update(getMesaString());
        tabuleiro.getVMao().update(getMaoString());  
        
        tabuleiro.getVPortas().update(getPortasString());
        
        tabuleiro.getVProfecia().update(getProfeciaString());
        
        //expansão
        tabuleiro.getVTorres().update(getTorresString());
    }
    
    
   static public Tabuleiro getTabuleiro(){
        return tabuleiro;
    }
     
    
//==== get-XXXX-String
    
   //EXPANSÃO
    //getTorresString
    private ArrayList<String> getTorresString()
    {
       ArrayList<String> aux = new ArrayList<String>();
            
        for(int i=0;i<modelo.getTorres().size();i++)
        {
            if(modelo.getTorres().get(i).getTipo() == 7) //TORRES (EXPANSAO)
            {
                if(modelo.getTorres().get(i).getNumeroTorre() == 3){
                    if(modelo.getTorres().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha3");
                    if(modelo.getTorres().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul3");
                    if(modelo.getTorres().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde3");
                    if(modelo.getTorres().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha3");
                }
                if(modelo.getTorres().get(i).getNumeroTorre() == 4){
                    if(modelo.getTorres().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha4");
                    if(modelo.getTorres().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul4");
                    if(modelo.getTorres().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde4");
                    if(modelo.getTorres().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha4");
                }
                if(modelo.getTorres().get(i).getNumeroTorre() == 5){
                    if(modelo.getTorres().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha5");
                    if(modelo.getTorres().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul5");
                    if(modelo.getTorres().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde5");
                    if(modelo.getTorres().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha5");
                }
            }
        }
        return aux;
    }
    
    
    //getProfeciaString
    private ArrayList<String> getProfeciaString()
    {
        ArrayList<String> aux = new ArrayList<String>();
            
        for(int i=0;i<modelo.getProfecia().size();i++)
        {
            if(modelo.getProfecia().get(i).getTipo() == 7) //TORRES (EXPANSAO)
            {
                if(modelo.getProfecia().get(i).getNumeroTorre() == 3){
                    if(modelo.getProfecia().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha3");
                    if(modelo.getProfecia().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul3");
                    if(modelo.getProfecia().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde3");
                    if(modelo.getProfecia().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha3");
                }
                if(modelo.getProfecia().get(i).getNumeroTorre() == 4){
                    if(modelo.getProfecia().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha4");
                    if(modelo.getProfecia().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul4");
                    if(modelo.getProfecia().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde4");
                    if(modelo.getProfecia().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha4");
                }
                if(modelo.getProfecia().get(i).getNumeroTorre() == 5){
                    if(modelo.getProfecia().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha5");
                    if(modelo.getProfecia().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul5");
                    if(modelo.getProfecia().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde5");
                    if(modelo.getProfecia().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha5");
                }
            }
            if(modelo.getProfecia().get(i).getTipo() == 4) //PORTA
            {    
                if(modelo.getProfecia().get(i).getCor() == 1)             
                    aux.add("PortaVermelha");       
                else if(modelo.getProfecia().get(i).getCor() == 2)
                    aux.add("PortaAzul");
                else if(modelo.getProfecia().get(i).getCor() == 3)
                    aux.add("PortaVerde");
                else if(modelo.getProfecia().get(i).getCor() == 4)
                    aux.add("PortaCastanha");
                
                //se nao for uma porta, nem um pesadelo (tem de ser uma camara)
            }else if( (modelo.getProfecia().get(i).getTipo() != 4) && (modelo.getProfecia().get(i).getCor() != 5))
            {   
                if(modelo.getProfecia().get(i).getTipo() == 3) //CHAVE
                {              
                    if(modelo.getProfecia().get(i).getCor() == 1)
                         aux.add("ChaveVermelha");
                    else if(modelo.getProfecia().get(i).getCor() == 2)
                        aux.add("ChaveAzul");
                    else if(modelo.getProfecia().get(i).getCor() == 3)
                        aux.add("ChaveVerde");
                    else if(modelo.getProfecia().get(i).getCor() == 4)
                        aux.add("ChaveCastanha");
                    
                }
                
                else if(modelo.getProfecia().get(i).getTipo()==1) //SOL
                {                    
                    if(modelo.getProfecia().get(i).getCor() == 1)
                        aux.add("SolVermelho");
                    else if(modelo.getProfecia().get(i).getCor() == 2)
                        aux.add("SolAzul");
                    else if(modelo.getProfecia().get(i).getCor() == 3)
                        aux.add("SolVerde");
                    else if(modelo.getProfecia().get(i).getCor() == 4)
                        aux.add("SolCastanho");
                }
                
                else if(modelo.getProfecia().get(i).getTipo()==2) //LUA
                {
                    if(modelo.getProfecia().get(i).getCor() == 1)
                        aux.add("LuaVermelha");
                    else if(modelo.getProfecia().get(i).getCor() == 2)
                        aux.add("LuaAzul");
                    else if(modelo.getProfecia().get(i).getCor() == 3)
                        aux.add("LuaVerde");
                    else if(modelo.getProfecia().get(i).getCor() == 4)
                        aux.add("LuaCastanha");
                }
            }else
              aux.add("Pesadelo"); 
            
        }
        return aux;
    }
    
    private ArrayList<String> getPortasString()
    {
        ArrayList<String> aux = new ArrayList<String>();
   
        for(int i=0;i<modelo.getPortas().size();i++){   
            if(modelo.getPortas().get(i).getCor() == 1) //vermelho
                aux.add("PortaVermelha");
            else if(modelo.getPortas().get(i).getCor() == 2) //azul
                aux.add("PortaAzul");
            else if(modelo.getPortas().get(i).getCor() == 3) //verde
                aux.add("PortaVerde");
            else if(modelo.getPortas().get(i).getCor() == 4) //castanho
                aux.add("PortaCastanha");
            }
        
        return aux;
    }
    
    
    
    private ArrayList<String> getMesaString()
    {
        ArrayList<String> aux = new ArrayList<String>();
   
        for(int i=0;i<modelo.getMesa().size();i++)
        {
            if(modelo.getMesa().get(i).getTipo() == 4) //PORTA
            {
                if(modelo.getMesa().get(i).getCor() == 1) //vermelho
                    aux.add("PortaVermelha");
                else if(modelo.getMesa().get(i).getCor() == 2) //azul
                    aux.add("PortaAzul");
                else if(modelo.getMesa().get(i).getCor() == 3) //verde
                    aux.add("PortaVerde");
                else if(modelo.getMesa().get(i).getCor() == 4) //castanho
                    aux.add("PortaCastanha");
                
            //se nao for uma porta, nem um pesadelo (tem de ser uma camara)
            }else if( (modelo.getMesa().get(i).getTipo() != 4) && (modelo.getMesa().get(i).getCor() != 5))
            {
                if(modelo.getMesa().get(i).getTipo() == 3) //chave
                {
                    if(modelo.getMesa().get(i).getCor() == 1) //vermelho
                         aux.add("ChaveVermelha");
                    else if(modelo.getMesa().get(i).getCor() == 2) //azul
                        aux.add("ChaveAzul");
                    else if(modelo.getMesa().get(i).getCor() == 3) //verde
                        aux.add("ChaveVerde");
                    else if(modelo.getMesa().get(i).getCor() == 4) //castanho
                        aux.add("ChaveCastanha");
                }
                
                else if(modelo.getMesa().get(i).getTipo() == 1) //sol
                {
                    if(modelo.getMesa().get(i).getCor() == 1) //vermelho
                        aux.add("SolVermelho");
                    else if(modelo.getMesa().get(i).getCor() == 2) //azul
                        aux.add("SolAzul");
                    else if(modelo.getMesa().get(i).getCor() == 3) //verde
                        aux.add("SolVerde");
                    else if(modelo.getMesa().get(i).getCor() == 4) //castanho
                        aux.add("SolCastanho");
                }
                
                else if(modelo.getMesa().get(i).getTipo() == 2) //lua
                {
                    if(modelo.getMesa().get(i).getCor() == 1) //vermelho
                        aux.add("LuaVermelha");
                    else if(modelo.getMesa().get(i).getCor() == 2) //azul
                        aux.add("LuaAzul");
                    else if(modelo.getMesa().get(i).getCor() == 3) //verde
                        aux.add("LuaVerde");
                    else if(modelo.getMesa().get(i).getCor() == 4) //castanho
                        aux.add("LuaCastanha");
                }
            }else
                aux.add("Pesadelo");    
        }
        
        return aux;
    }
    
    
    
    private ArrayList<String> getMaoString()
    {
        ArrayList<String> aux = new ArrayList<String>();
            
        for(int i=0;i<modelo.getMao().size();i++)
        {
            
            if(modelo.getMao().get(i).getTipo() == 7) //TORRES (EXPANSAO)
            {
                if(modelo.getMao().get(i).getNumeroTorre() == 3){
                    if(modelo.getMao().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha3");
                    if(modelo.getMao().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul3");
                    if(modelo.getMao().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde3");
                    if(modelo.getMao().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha3");
                }
                if(modelo.getMao().get(i).getNumeroTorre() == 4){
                    if(modelo.getMao().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha4");
                    if(modelo.getMao().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul4");
                    if(modelo.getMao().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde4");
                    if(modelo.getMao().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha4");
                }
                if(modelo.getMao().get(i).getNumeroTorre() == 5){
                    if(modelo.getMao().get(i).getCor() == 1)       //vermelha
                        aux.add("TorreVermelha5");
                    if(modelo.getMao().get(i).getCor() == 2)       //azul
                        aux.add("TorreAzul5");
                    if(modelo.getMao().get(i).getCor() == 3)       //verde
                        aux.add("TorreVerde5");
                    if(modelo.getMao().get(i).getCor() == 4)       //castanha
                        aux.add("TorreCastanha5");
                }
            }
            
            
            if(modelo.getMao().get(i).getTipo() == 4) //PORTA
            {    
                if(modelo.getMao().get(i).getCor() == 1)     //vermelho      
                    aux.add("PortaVermelha");       
                else if(modelo.getMao().get(i).getCor() == 2) //azul
                    aux.add("PortaAzul");
                else if(modelo.getMao().get(i).getCor() == 3) //verde
                    aux.add("PortaVerde");
                else if(modelo.getMao().get(i).getCor() == 4) //castanho
                    aux.add("PortaCastanha");
                
            //se nao for uma porta, nem um pesadelo,  (tem de ser uma camara)
            }else if( (modelo.getMao().get(i).getTipo() != 4) && (modelo.getMao().get(i).getCor() != 5))
            {   
                if(modelo.getMao().get(i).getTipo() == 3)  //chave
                {              
                    if(modelo.getMao().get(i).getCor() == 1) //vermelho
                         aux.add("ChaveVermelha");
                    else if(modelo.getMao().get(i).getCor() == 2) //azul
                        aux.add("ChaveAzul");
                    else if(modelo.getMao().get(i).getCor() == 3) //verde
                        aux.add("ChaveVerde");
                    else if(modelo.getMao().get(i).getCor() == 4) //castanho
                        aux.add("ChaveCastanha");
                    
                }
                
                else if(modelo.getMao().get(i).getTipo() == 1) //sol
                {                    
                    if(modelo.getMao().get(i).getCor() == 1) //vermelho
                        aux.add("SolVermelho");
                    else if(modelo.getMao().get(i).getCor() == 2) //azul
                        aux.add("SolAzul");
                    else if(modelo.getMao().get(i).getCor() == 3) //verde
                        aux.add("SolVerde");
                    else if(modelo.getMao().get(i).getCor() == 4) //castanho
                        aux.add("SolCastanho");
                }
                
                else if(modelo.getMao().get(i).getTipo() == 2) //lua
                {
                    if(modelo.getMao().get(i).getCor() == 1) //vermelho
                        aux.add("LuaVermelha");
                    else if(modelo.getMao().get(i).getCor() == 2) //azul
                        aux.add("LuaAzul");
                    else if(modelo.getMao().get(i).getCor() == 3) //verde
                        aux.add("LuaVerde");
                    else if(modelo.getMao().get(i).getCor() == 4) //castanho
                        aux.add("LuaCastanha");
                }
            }else
              aux.add("Pesadelo"); 
            
        }
        return aux;
    }
    
    
    
    public void jogar_carta(int n){
        modelo.jogar( modelo.getMao().get(n) );
    }
    
    public void descartar_carta(int n){
        modelo.descartar( modelo.getMao().get(n) );
    }
    
    public void descartar_profecia(int n){
        modelo.descartar( modelo.getProfecia().get(n) );
    }
    
        
    
//==== EVENTOS ========
    
    public void mouseEntered(MouseEvent e){
    }
    
    public void mouseMoved(MouseEvent e){
    }
    
    public void mouseClicked(MouseEvent e){
    }
    
    public void mousePressed(MouseEvent e){
    }
    
    public void mouseReleased(MouseEvent e){
        
        if (tabuleiro.getVista_actual().equalsIgnoreCase("Normal")) {
            if (carta != null) {
                arrastada = false;

                if (tabuleiro.getVEliminadas().contains(e.getX(), e.getY())) {
                    descartar_carta(tabuleiro.getVMao().getCartaEscolhida());
                    
                    if (tabuleiro.getVista_actual().equalsIgnoreCase("Final")){
            System.out.println("acabou_vista_jogo");
        }

                }

                if (tabuleiro.getVMesa().contains(e.getX(), e.getY())) {
                    jogar_carta(tabuleiro.getVMao().getCartaEscolhida());
                }

                carta = null;

                tabuleiro.getVMao().reset();
            }
        } else if(tabuleiro.getVista_actual().equalsIgnoreCase("Profecia")) {            
            if (carta != null) {
                arrastada = false;

                if(tabuleiro.getVProfecia().getCartas().size() == 5)
                {
                    if (tabuleiro.getVEliminadas().contains(e.getX(), e.getY())) {
                        descartar_profecia(tabuleiro.getVProfecia().getCartaEscolhida());
                    }  
                }
                else
                {
                    if (tabuleiro.getVBaralho().contains(e.getX(), e.getY())) {
                        descartar_profecia(tabuleiro.getVProfecia().getCartaEscolhida());
                    }
                }
                
                
                carta = null;   
                tabuleiro.getVProfecia().reset();
            } 
        } else if(tabuleiro.getVista_actual().equalsIgnoreCase("ProfeciaTorres")) {
            if (carta != null) {
                arrastada = false;
                
                if(tabuleiro.getVBaralho().contains(e.getX(), e.getY())){
                    descartar_profecia(tabuleiro.getVProfecia().getCartaEscolhida());
                }
                
                carta=null;
                tabuleiro.getVProfecia().reset();
            }
        } else if(tabuleiro.getVista_actual().equalsIgnoreCase("CompraPesadelo")){
            
        
        }
        
       
        this.repaint();
    }
    
    public void mouseExited(MouseEvent e){
      arrastada = false;
        if (tabuleiro.getVista_actual().equalsIgnoreCase("Normal"))
            tabuleiro.getVMao().reset();
        else if(tabuleiro.getVista_actual().equalsIgnoreCase("Profecia"))
            tabuleiro.getVProfecia().reset();
        else if(tabuleiro.getVista_actual().equalsIgnoreCase("ProfeciaTorres"))
            tabuleiro.getVProfecia().reset();
        
        this.repaint();
    }  
    
    public void mouseDragged(MouseEvent e){
        if (tabuleiro.getVista_actual().equalsIgnoreCase("Normal")) {
            if (!arrastada) {
                click_x = e.getX();
                click_y = e.getY();
                arrastada = true;
            }

            if ((carta = tabuleiro.getVMao().escolherCarta(e.getX(), e.getY())) != null) {
                tabuleiro.getVMao().moverCarta(click_x - e.getX(), click_y - e.getY());
            } else {
                arrastada = false;
                tabuleiro.getVMao().reset();
            }
        } else if(tabuleiro.getVista_actual().equalsIgnoreCase("Profecia")) {
             if (!arrastada) {
                click_x = e.getX();
                click_y = e.getY();
                arrastada = true;
            }

            if ((carta = tabuleiro.getVProfecia().escolherCarta(e.getX(), e.getY())) != null) {
                tabuleiro.getVProfecia().moverCarta(click_x - e.getX(), click_y - e.getY());
            } else {
                arrastada = false;
                tabuleiro.getVProfecia().reset();
            }
        } else if(tabuleiro.getVista_actual().equalsIgnoreCase("ProfeciaTorres")){
            if(!arrastada){
                click_x = e.getX();
                click_y = e.getY();
                arrastada = true;
            }
            
            if( (carta = tabuleiro.getVProfecia().escolherCarta(e.getX(), e.getY())) != null){
                tabuleiro.getVProfecia().moverCarta(click_x - e.getX(), click_y - e.getY());
            }else{
                arrastada = false;
                tabuleiro.getVProfecia().reset();
            }
        }     
        this.repaint();
    }
    
    
//==== FIM EVENTOS ====
    
}
