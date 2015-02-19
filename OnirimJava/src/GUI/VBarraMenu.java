
package GUI;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import projecto.Cheats;
import projecto.Jogo;


public class VBarraMenu extends JFrame implements Serializable{
    
    private Jogo j;
    private Modelo m;
    private Cheats c;
    private VistaJogo vj;
    
    JFileChooser jfc = new JFileChooser();
    
    
    //barra de menus
    JMenuBar barraMenu;
    
    //menus
    JMenu ficheiro;
    JMenuItem novo_jogo;
    JMenuItem novo_jogo_expansao;
    JMenuItem gravar_jogo;
    JMenuItem carregar_jogo;
    JMenuItem sair_jogo;
    
    JMenu cheats;
    JMenu Cheats_adicionarCartaMesa;
    JMenu Cheats_adicionarCartaMao;
    JMenu Cheats_adicionarCartaBaralho;
     //mesa
    JMenu Cheats_cartaCamaraMesa;
    JMenu Cheats_cartaPortaMesa;
    JMenu Cheats_Camara_vermelha_Mesa;
    JMenu Cheats_Camara_azul_Mesa;
    JMenu Cheats_Camara_verde_Mesa;
    JMenu Cheats_Camara_castanha_Mesa;
    JMenuItem Cheats_Porta_vermelha_Mesa;
    JMenuItem Cheats_Porta_azul_Mesa;
    JMenuItem Cheats_Porta_verde_Mesa;
    JMenuItem Cheats_Porta_castanha_Mesa;
      //baralho
    JMenu Cheats_cartaCamaraBaralho;
    JMenu Cheats_cartaPortaBaralho;
    JMenu Cheats_Camara_vermelha_Baralho;
    JMenu Cheats_Camara_azul_Baralho;
    JMenu Cheats_Camara_verde_Baralho;
    JMenu Cheats_Camara_castanha_Baralho;
    JMenu Cheats_cartaTorreBaralho;
    JMenu Cheats_Torre_vermelha_Baralho;
    JMenu Cheats_Torre_azul_Baralho;
    JMenu Cheats_Torre_verde_Baralho;
    JMenu Cheats_Torre_castanha_Baralho;
    JMenuItem Cheats_Porta_vermelha_Baralho;
    JMenuItem Cheats_Porta_azul_Baralho;
    JMenuItem Cheats_Porta_verde_Baralho;
    JMenuItem Cheats_Porta_castanha_Baralho;
      //mao
    JMenu Cheats_cartaCamaraMao;
    JMenu Cheats_cartaPortaMao;
    JMenu Cheats_Camara_vermelha_Mao;
    JMenu Cheats_Camara_azul_Mao;
    JMenu Cheats_Camara_verde_Mao;
    JMenu Cheats_Camara_castanha_Mao;
    JMenuItem Cheats_Porta_vermelha_Mao;
    JMenuItem Cheats_Porta_azul_Mao;
    JMenuItem Cheats_Porta_verde_Mao;
    JMenuItem Cheats_Porta_castanha_Mao;
    
    
    //menu items
    JMenuItem Cheats_verCartas;
    JMenuItem Cheats_PesadeloMao;
    JMenuItem Cheats_PesadeloBaralho;
       //mesa
    JMenuItem Cheats_Camara_vermelha_Mesa_Sol;
    JMenuItem Cheats_Camara_vermelha_Mesa_Lua;
    JMenuItem Cheats_Camara_vermelha_Mesa_Chave;
    
    JMenuItem Cheats_Camara_azul_Mesa_Sol;
    JMenuItem Cheats_Camara_azul_Mesa_Lua;
    JMenuItem Cheats_Camara_azul_Mesa_Chave;
    
    JMenuItem Cheats_Camara_verde_Mesa_Sol;
    JMenuItem Cheats_Camara_verde_Mesa_Lua;
    JMenuItem Cheats_Camara_verde_Mesa_Chave;
    
    JMenuItem Cheats_Camara_castanha_Mesa_Sol;
    JMenuItem Cheats_Camara_castanha_Mesa_Lua;
    JMenuItem Cheats_Camara_castanha_Mesa_Chave;
    
       //baralho
    JMenuItem Cheats_Camara_vermelha_Baralho_Sol;
    JMenuItem Cheats_Camara_vermelha_Baralho_Lua;
    JMenuItem Cheats_Camara_vermelha_Baralho_Chave;
    
    JMenuItem Cheats_Camara_azul_Baralho_Sol;
    JMenuItem Cheats_Camara_azul_Baralho_Lua;
    JMenuItem Cheats_Camara_azul_Baralho_Chave;
    
    JMenuItem Cheats_Camara_verde_Baralho_Sol;
    JMenuItem Cheats_Camara_verde_Baralho_Lua;
    JMenuItem Cheats_Camara_verde_Baralho_Chave;
    
    JMenuItem Cheats_Camara_castanha_Baralho_Sol;
    JMenuItem Cheats_Camara_castanha_Baralho_Lua;
    JMenuItem Cheats_Camara_castanha_Baralho_Chave;
    
        //baralho-expansao
    JMenuItem Cheats_Torre_vermelha_Baralho_1;
    JMenuItem Cheats_Torre_vermelha_Baralho_2;
    JMenuItem Cheats_Torre_vermelha_Baralho_3;
    JMenuItem Cheats_Torre_azul_Baralho_1;
    JMenuItem Cheats_Torre_azul_Baralho_2;
    JMenuItem Cheats_Torre_azul_Baralho_3;
    JMenuItem Cheats_Torre_verde_Baralho_1;
    JMenuItem Cheats_Torre_verde_Baralho_2;
    JMenuItem Cheats_Torre_verde_Baralho_3;
    JMenuItem Cheats_Torre_castanha_Baralho_1;
    JMenuItem Cheats_Torre_castanha_Baralho_2;
    JMenuItem Cheats_Torre_castanha_Baralho_3;
    
    
       //mao
    JMenuItem Cheats_Camara_vermelha_Mao_Sol;
    JMenuItem Cheats_Camara_vermelha_Mao_Lua;
    JMenuItem Cheats_Camara_vermelha_Mao_Chave;
    
    JMenuItem Cheats_Camara_azul_Mao_Sol;
    JMenuItem Cheats_Camara_azul_Mao_Lua;
    JMenuItem Cheats_Camara_azul_Mao_Chave;
    
    JMenuItem Cheats_Camara_verde_Mao_Sol;
    JMenuItem Cheats_Camara_verde_Mao_Lua;
    JMenuItem Cheats_Camara_verde_Mao_Chave;
    
    JMenuItem Cheats_Camara_castanha_Mao_Sol;
    JMenuItem Cheats_Camara_castanha_Mao_Lua;
    JMenuItem Cheats_Camara_castanha_Mao_Chave;
    
    
    
    
    public VBarraMenu(Modelo modelo, VistaJogo vistajogo){
        
        m = modelo;
        j = m.getJogo();
        c = new Cheats(j);
        vj = vistajogo;
        
        
        
        
        barraMenu = new JMenuBar();
        
        ficheiro = new JMenu("Ficheiro");
        barraMenu.add(ficheiro);
        novo_jogo = new JMenuItem("Novo jogo");
        novo_jogo_expansao = new JMenuItem("Novo jogo+expansao");
        gravar_jogo = new JMenuItem("Gravar");
        carregar_jogo = new JMenuItem("Carregar");
        sair_jogo = new JMenuItem("Sair");
        ficheiro.add(novo_jogo);
        ficheiro.add(novo_jogo_expansao);
        ficheiro.addSeparator();
        ficheiro.add(gravar_jogo);
        ficheiro.add(carregar_jogo);
        ficheiro.addSeparator();
        ficheiro.add(sair_jogo);
        
        
        cheats = new JMenu("Cheats");
        Cheats_adicionarCartaMesa = new JMenu("Mesa");
        Cheats_adicionarCartaMao = new JMenu("Mao");
        Cheats_adicionarCartaBaralho = new JMenu("Baralho");
        Cheats_cartaCamaraMesa = new JMenu("Camara");
        Cheats_cartaPortaMesa = new JMenu("Porta");
        Cheats_cartaCamaraBaralho = new JMenu("Camara");
        Cheats_cartaPortaBaralho = new JMenu("Porta");
        Cheats_cartaCamaraMao =  new JMenu("Camara");
        Cheats_cartaPortaMao = new JMenu("Porta");
        
        Cheats_verCartas = new JMenuItem("Ver cartas");
        Cheats_PesadeloMao = new JMenuItem("Pesadelo");
        Cheats_PesadeloBaralho = new JMenuItem("Pesadelo");
           //mesa
        Cheats_Camara_vermelha_Mesa = new JMenu("Vermelha");
        Cheats_Camara_azul_Mesa = new JMenu("Azul");
        Cheats_Camara_verde_Mesa = new JMenu("Verde");
        Cheats_Camara_castanha_Mesa = new JMenu("Castanha");
        Cheats_Porta_vermelha_Mesa = new JMenuItem("Vermelha");
        Cheats_Porta_azul_Mesa = new JMenuItem("Azul");
        Cheats_Porta_verde_Mesa = new JMenuItem("Verde");
        Cheats_Porta_castanha_Mesa = new JMenuItem("Castanha");
        
        Cheats_Camara_vermelha_Mesa_Sol = new JMenuItem("Sol");
        Cheats_Camara_vermelha_Mesa_Lua = new JMenuItem("Lua");
        Cheats_Camara_vermelha_Mesa_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_azul_Mesa_Sol = new JMenuItem("Sol");
        Cheats_Camara_azul_Mesa_Lua = new JMenuItem("Lua");
        Cheats_Camara_azul_Mesa_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_verde_Mesa_Sol = new JMenuItem("Sol");
        Cheats_Camara_verde_Mesa_Lua = new JMenuItem("Lua");
        Cheats_Camara_verde_Mesa_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_castanha_Mesa_Sol = new JMenuItem("Sol");
        Cheats_Camara_castanha_Mesa_Lua = new JMenuItem("Lua");
        Cheats_Camara_castanha_Mesa_Chave = new JMenuItem("Chave");
        
           //baralho
        Cheats_Camara_vermelha_Baralho = new JMenu("Vermelha");
        Cheats_Camara_azul_Baralho = new JMenu("Azul");
        Cheats_Camara_verde_Baralho = new JMenu("Verde");
        Cheats_Camara_castanha_Baralho = new JMenu("Castanha");
        Cheats_Porta_vermelha_Baralho = new JMenuItem("Vermelha");
        Cheats_Porta_azul_Baralho = new JMenuItem("Azul");
        Cheats_Porta_verde_Baralho = new JMenuItem("Verde");
        Cheats_Porta_castanha_Baralho = new JMenuItem("Castanha");
        
        Cheats_Camara_vermelha_Baralho_Sol = new JMenuItem("Sol");
        Cheats_Camara_vermelha_Baralho_Lua = new JMenuItem("Lua");
        Cheats_Camara_vermelha_Baralho_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_azul_Baralho_Sol = new JMenuItem("Sol");
        Cheats_Camara_azul_Baralho_Lua = new JMenuItem("Lua");
        Cheats_Camara_azul_Baralho_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_verde_Baralho_Sol = new JMenuItem("Sol");
        Cheats_Camara_verde_Baralho_Lua = new JMenuItem("Lua");
        Cheats_Camara_verde_Baralho_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_castanha_Baralho_Sol = new JMenuItem("Sol");
        Cheats_Camara_castanha_Baralho_Lua = new JMenuItem("Lua");
        Cheats_Camara_castanha_Baralho_Chave = new JMenuItem("Chave");
        
           //baralho-expansao
        Cheats_cartaTorreBaralho = new JMenu("Torre");
        Cheats_Torre_vermelha_Baralho = new JMenu("Vermelha");
        Cheats_Torre_azul_Baralho = new JMenu("Azul");
        Cheats_Torre_verde_Baralho = new JMenu("Verde");
        Cheats_Torre_castanha_Baralho = new JMenu("Castanha");
        
        Cheats_Torre_vermelha_Baralho_1 = new JMenuItem("Número 3");
        Cheats_Torre_vermelha_Baralho_2 = new JMenuItem("Número 4");
        Cheats_Torre_vermelha_Baralho_3 = new JMenuItem("Número 5");
        Cheats_Torre_azul_Baralho_1 = new JMenuItem("Número 3");
        Cheats_Torre_azul_Baralho_2 = new JMenuItem("Número 4");
        Cheats_Torre_azul_Baralho_3 = new JMenuItem("Número 5");
        Cheats_Torre_verde_Baralho_1 = new JMenuItem("Número 3");
        Cheats_Torre_verde_Baralho_2 = new JMenuItem("Número 4");
        Cheats_Torre_verde_Baralho_3 = new JMenuItem("Número 5");
        Cheats_Torre_castanha_Baralho_1 = new JMenuItem("Número 3");
        Cheats_Torre_castanha_Baralho_2 = new JMenuItem("Número 4");
        Cheats_Torre_castanha_Baralho_3 = new JMenuItem("Número 5");
        
        
        Cheats_cartaTorreBaralho.add(Cheats_Torre_vermelha_Baralho);
          Cheats_Torre_vermelha_Baralho.add(Cheats_Torre_vermelha_Baralho_1);
          Cheats_Torre_vermelha_Baralho.add(Cheats_Torre_vermelha_Baralho_2);
          Cheats_Torre_vermelha_Baralho.add(Cheats_Torre_vermelha_Baralho_3);
        Cheats_cartaTorreBaralho.add(Cheats_Torre_azul_Baralho);
          Cheats_Torre_azul_Baralho.add(Cheats_Torre_azul_Baralho_1);
          Cheats_Torre_azul_Baralho.add(Cheats_Torre_azul_Baralho_2);
          Cheats_Torre_azul_Baralho.add(Cheats_Torre_azul_Baralho_3);
        Cheats_cartaTorreBaralho.add(Cheats_Torre_verde_Baralho);
          Cheats_Torre_verde_Baralho.add(Cheats_Torre_verde_Baralho_1);
          Cheats_Torre_verde_Baralho.add(Cheats_Torre_verde_Baralho_2);
          Cheats_Torre_verde_Baralho.add(Cheats_Torre_verde_Baralho_3);
        Cheats_cartaTorreBaralho.add(Cheats_Torre_castanha_Baralho);
          Cheats_Torre_castanha_Baralho.add(Cheats_Torre_castanha_Baralho_1);
          Cheats_Torre_castanha_Baralho.add(Cheats_Torre_castanha_Baralho_2);
          Cheats_Torre_castanha_Baralho.add(Cheats_Torre_castanha_Baralho_3);
        
           //mao
        Cheats_Camara_vermelha_Mao = new JMenu("Vermelha");
        Cheats_Camara_azul_Mao = new JMenu("Azul");
        Cheats_Camara_verde_Mao = new JMenu("Verde");
        Cheats_Camara_castanha_Mao = new JMenu("Castanha");
        Cheats_Porta_vermelha_Mao = new JMenuItem("Vermelha");
        Cheats_Porta_azul_Mao = new JMenuItem("Azul");
        Cheats_Porta_verde_Mao = new JMenuItem("Verde");
        Cheats_Porta_castanha_Mao = new JMenuItem("Castanha");
        
        Cheats_Camara_vermelha_Mao_Sol = new JMenuItem("Sol");
        Cheats_Camara_vermelha_Mao_Lua = new JMenuItem("Lua");
        Cheats_Camara_vermelha_Mao_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_azul_Mao_Sol = new JMenuItem("Sol");
        Cheats_Camara_azul_Mao_Lua = new JMenuItem("Lua");
        Cheats_Camara_azul_Mao_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_verde_Mao_Sol = new JMenuItem("Sol");
        Cheats_Camara_verde_Mao_Lua = new JMenuItem("Lua");
        Cheats_Camara_verde_Mao_Chave = new JMenuItem("Chave");
        
        Cheats_Camara_castanha_Mao_Sol = new JMenuItem("Sol");
        Cheats_Camara_castanha_Mao_Lua = new JMenuItem("Lua");
        Cheats_Camara_castanha_Mao_Chave = new JMenuItem("Chave");
        
        
        
            
        
        barraMenu.add(cheats);
        cheats.add(Cheats_verCartas);
        cheats.add(Cheats_adicionarCartaBaralho);
        cheats.add(Cheats_adicionarCartaMesa);
        cheats.add(Cheats_adicionarCartaMao);
        
        
  //mesa      
        Cheats_adicionarCartaMesa.add(Cheats_cartaCamaraMesa);
        Cheats_cartaCamaraMesa.add(Cheats_Camara_vermelha_Mesa);
        Cheats_cartaCamaraMesa.add(Cheats_Camara_azul_Mesa);
        Cheats_cartaCamaraMesa.add(Cheats_Camara_verde_Mesa);
        Cheats_cartaCamaraMesa.add(Cheats_Camara_castanha_Mesa);
        
        Cheats_Camara_vermelha_Mesa.add(Cheats_Camara_vermelha_Mesa_Sol);
        Cheats_Camara_vermelha_Mesa.add(Cheats_Camara_vermelha_Mesa_Lua);
        Cheats_Camara_vermelha_Mesa.add(Cheats_Camara_vermelha_Mesa_Chave);
        Cheats_Camara_azul_Mesa.add(Cheats_Camara_azul_Mesa_Sol);
        Cheats_Camara_azul_Mesa.add(Cheats_Camara_azul_Mesa_Lua);
        Cheats_Camara_azul_Mesa.add(Cheats_Camara_azul_Mesa_Chave);
        Cheats_Camara_verde_Mesa.add(Cheats_Camara_verde_Mesa_Sol);
        Cheats_Camara_verde_Mesa.add(Cheats_Camara_verde_Mesa_Lua);
        Cheats_Camara_verde_Mesa.add(Cheats_Camara_verde_Mesa_Chave);
        Cheats_Camara_castanha_Mesa.add(Cheats_Camara_castanha_Mesa_Sol);
        Cheats_Camara_castanha_Mesa.add(Cheats_Camara_castanha_Mesa_Lua);
        Cheats_Camara_castanha_Mesa.add(Cheats_Camara_castanha_Mesa_Chave);
        
        Cheats_adicionarCartaMesa.add(Cheats_cartaPortaMesa);
        Cheats_cartaPortaMesa.add(Cheats_Porta_vermelha_Mesa);
        Cheats_cartaPortaMesa.add(Cheats_Porta_azul_Mesa);
        Cheats_cartaPortaMesa.add(Cheats_Porta_verde_Mesa);
        Cheats_cartaPortaMesa.add(Cheats_Porta_castanha_Mesa);
        
        
   //baralho
        Cheats_adicionarCartaBaralho.add(Cheats_cartaCamaraBaralho);
        Cheats_cartaCamaraBaralho.add(Cheats_Camara_vermelha_Baralho);
        Cheats_cartaCamaraBaralho.add(Cheats_Camara_azul_Baralho);
        Cheats_cartaCamaraBaralho.add(Cheats_Camara_verde_Baralho);
        Cheats_cartaCamaraBaralho.add(Cheats_Camara_castanha_Baralho);
        
        Cheats_Camara_vermelha_Baralho.add(Cheats_Camara_vermelha_Baralho_Sol);
        Cheats_Camara_vermelha_Baralho.add(Cheats_Camara_vermelha_Baralho_Lua);
        Cheats_Camara_vermelha_Baralho.add(Cheats_Camara_vermelha_Baralho_Chave);
        
        Cheats_Camara_azul_Baralho.add(Cheats_Camara_azul_Baralho_Sol);
        Cheats_Camara_azul_Baralho.add(Cheats_Camara_azul_Baralho_Lua);
        Cheats_Camara_azul_Baralho.add(Cheats_Camara_azul_Baralho_Chave);
        
        Cheats_Camara_verde_Baralho.add(Cheats_Camara_verde_Baralho_Sol);
        Cheats_Camara_verde_Baralho.add(Cheats_Camara_verde_Baralho_Lua);
        Cheats_Camara_verde_Baralho.add(Cheats_Camara_verde_Baralho_Chave);
        
        Cheats_Camara_castanha_Baralho.add(Cheats_Camara_castanha_Baralho_Sol);
        Cheats_Camara_castanha_Baralho.add(Cheats_Camara_castanha_Baralho_Lua);
        Cheats_Camara_castanha_Baralho.add(Cheats_Camara_castanha_Baralho_Chave);
        
        Cheats_adicionarCartaBaralho.add(Cheats_cartaPortaBaralho);
        Cheats_cartaPortaBaralho.add(Cheats_Porta_vermelha_Baralho);
        Cheats_cartaPortaBaralho.add(Cheats_Porta_azul_Baralho);
        Cheats_cartaPortaBaralho.add(Cheats_Porta_verde_Baralho);
        Cheats_cartaPortaBaralho.add(Cheats_Porta_castanha_Baralho);
         
        
        //expansao
        Cheats_adicionarCartaBaralho.add(Cheats_cartaTorreBaralho);
        
        Cheats_adicionarCartaBaralho.add(Cheats_PesadeloBaralho);
                
   //mao
        Cheats_adicionarCartaMao.add(Cheats_cartaCamaraMao);
        Cheats_cartaCamaraMao.add(Cheats_Camara_vermelha_Mao);
        Cheats_cartaCamaraMao.add(Cheats_Camara_azul_Mao);
        Cheats_cartaCamaraMao.add(Cheats_Camara_verde_Mao);
        Cheats_cartaCamaraMao.add(Cheats_Camara_castanha_Mao);
        
        Cheats_Camara_vermelha_Mao.add(Cheats_Camara_vermelha_Mao_Sol);
        Cheats_Camara_vermelha_Mao.add(Cheats_Camara_vermelha_Mao_Lua);
        Cheats_Camara_vermelha_Mao.add(Cheats_Camara_vermelha_Mao_Chave);
        
        Cheats_Camara_azul_Mao.add(Cheats_Camara_azul_Mao_Sol);
        Cheats_Camara_azul_Mao.add(Cheats_Camara_azul_Mao_Lua);
        Cheats_Camara_azul_Mao.add(Cheats_Camara_azul_Mao_Chave);
        
        Cheats_Camara_verde_Mao.add(Cheats_Camara_verde_Mao_Sol);
        Cheats_Camara_verde_Mao.add(Cheats_Camara_verde_Mao_Lua);
        Cheats_Camara_verde_Mao.add(Cheats_Camara_verde_Mao_Chave);
        
        Cheats_Camara_castanha_Mao.add(Cheats_Camara_castanha_Mao_Sol);
        Cheats_Camara_castanha_Mao.add(Cheats_Camara_castanha_Mao_Lua);
        Cheats_Camara_castanha_Mao.add(Cheats_Camara_castanha_Mao_Chave);
                   
        
        Cheats_adicionarCartaMao.add(Cheats_cartaPortaMao);
        Cheats_cartaPortaMao.add(Cheats_Porta_vermelha_Mao);
        Cheats_cartaPortaMao.add(Cheats_Porta_azul_Mao);
        Cheats_cartaPortaMao.add(Cheats_Porta_verde_Mao);
        Cheats_cartaPortaMao.add(Cheats_Porta_castanha_Mao);
        
        Cheats_adicionarCartaMao.add(Cheats_PesadeloMao);
        
        
        //registar action listeners
        registarListeners();
        
    }
    
    //public void CriarMenu(VistaJogo v){
    public void CriarMenu(JFrame v){
        //recebe uma vista e aplica-lhe a barra de menus
        v.setJMenuBar(barraMenu);
    }
    
    
    //registar listeners
    private void registarListeners(){
        
      //FICHEIRO
        //novo_jogo
        novo_jogo.addActionListener(new NovoJogoListener());
        //novo_jogo_expansao
        novo_jogo_expansao.addActionListener(new NovoJogoExpListener());
        //gravar_jogo
        gravar_jogo.addActionListener(new GuardarListener());
        //carregar_jogo
        carregar_jogo.addActionListener(new CarregarListener());
        //sair
        sair_jogo.addActionListener(new SairListener());
        
        
      //CHEATS  
        
        Cheats_verCartas.addActionListener(new ListarCartasListener());
        
        //mesa
        Cheats_Camara_vermelha_Mesa_Sol.addActionListener(new AddCartaCamaraVermelhaSolMesa());
        Cheats_Camara_vermelha_Mesa_Lua.addActionListener(new AddCartaCamaraVermelhaLuaMesa());
        Cheats_Camara_vermelha_Mesa_Chave.addActionListener(new AddCartaCamaraVermelhaChaveMesa());
        Cheats_Camara_azul_Mesa_Sol.addActionListener(new AddCartaCamaraAzulSolMesa());
        Cheats_Camara_azul_Mesa_Lua.addActionListener(new AddCartaCamaraAzulLuaMesa());
        Cheats_Camara_azul_Mesa_Chave.addActionListener(new AddCartaCamaraAzulChaveMesa());
        Cheats_Camara_verde_Mesa_Sol.addActionListener(new AddCartaCamaraVerdeSolMesa());
        Cheats_Camara_verde_Mesa_Lua.addActionListener(new AddCartaCamaraVerdeLuaMesa());
        Cheats_Camara_verde_Mesa_Chave.addActionListener(new AddCartaCamaraVerdeChaveMesa());
        Cheats_Camara_castanha_Mesa_Sol.addActionListener(new AddCartaCamaraCastanhaSolMesa());
        Cheats_Camara_castanha_Mesa_Lua.addActionListener(new AddCartaCamaraCastanhaLuaMesa());
        Cheats_Camara_castanha_Mesa_Chave.addActionListener(new AddCartaCamaraCastanhaChaveMesa());
         
        Cheats_Porta_vermelha_Mesa.addActionListener(new AddCartaPortaVermelhaMesa());
        Cheats_Porta_azul_Mesa.addActionListener(new AddCartaPortaAzulMesa());
        Cheats_Porta_verde_Mesa.addActionListener(new AddCartaPortaVerdeMesa());
        Cheats_Porta_castanha_Mesa.addActionListener(new AddCartaPortaCastanhaMesa());
        
        //mao
        Cheats_Camara_vermelha_Mao_Sol.addActionListener(new AddCartaCamaraVermelhaSolMao());
        Cheats_Camara_vermelha_Mao_Lua.addActionListener(new AddCartaCamaraVermelhaLuaMao());
        Cheats_Camara_vermelha_Mao_Chave.addActionListener(new AddCartaCamaraVermelhaChaveMao());
        Cheats_Camara_azul_Mao_Sol.addActionListener(new AddCartaCamaraAzulSolMao());
        Cheats_Camara_azul_Mao_Lua.addActionListener(new AddCartaCamaraAzulLuaMao());
        Cheats_Camara_azul_Mao_Chave.addActionListener(new AddCartaCamaraAzulChaveMao());
        Cheats_Camara_verde_Mao_Sol.addActionListener(new AddCartaCamaraVerdeSolMao());
        Cheats_Camara_verde_Mao_Lua.addActionListener(new AddCartaCamaraVerdeLuaMao());
        Cheats_Camara_verde_Mao_Chave.addActionListener(new AddCartaCamaraVerdeChaveMao());
        Cheats_Camara_castanha_Mao_Sol.addActionListener(new AddCartaCamaraCastanhaSolMao());
        Cheats_Camara_castanha_Mao_Lua.addActionListener(new AddCartaCamaraCastanhaLuaMao());
        Cheats_Camara_castanha_Mao_Chave.addActionListener(new AddCartaCamaraCastanhaChaveMao());
         
        Cheats_Porta_vermelha_Mao.addActionListener(new AddCartaPortaVermelhaMao());
        Cheats_Porta_azul_Mao.addActionListener(new AddCartaPortaAzulMao());
        Cheats_Porta_verde_Mao.addActionListener(new AddCartaPortaVerdeMao());
        Cheats_Porta_castanha_Mao.addActionListener(new AddCartaPortaCastanhaMao());
        
        Cheats_PesadeloMao.addActionListener(new AddCartaPesadeloMao());
        
        //baralho
        Cheats_Camara_vermelha_Baralho_Sol.addActionListener(new AddCartaCamaraVermelhaSolBaralho());
        Cheats_Camara_vermelha_Baralho_Lua.addActionListener(new AddCartaCamaraVermelhaLuaBaralho());
        Cheats_Camara_vermelha_Baralho_Chave.addActionListener(new AddCartaCamaraVermelhaChaveBaralho());
        Cheats_Camara_azul_Baralho_Sol.addActionListener(new AddCartaCamaraAzulSolBaralho());
        Cheats_Camara_azul_Baralho_Lua.addActionListener(new AddCartaCamaraAzulLuaBaralho());
        Cheats_Camara_azul_Baralho_Chave.addActionListener(new AddCartaCamaraAzulChaveBaralho());
        Cheats_Camara_verde_Baralho_Sol.addActionListener(new AddCartaCamaraVerdeSolBaralho());
        Cheats_Camara_verde_Baralho_Lua.addActionListener(new AddCartaCamaraVerdeLuaBaralho());
        Cheats_Camara_verde_Baralho_Chave.addActionListener(new AddCartaCamaraVerdeChaveBaralho());
        Cheats_Camara_castanha_Baralho_Sol.addActionListener(new AddCartaCamaraCastanhaSolBaralho());
        Cheats_Camara_castanha_Baralho_Lua.addActionListener(new AddCartaCamaraCastanhaLuaBaralho());
        Cheats_Camara_castanha_Baralho_Chave.addActionListener(new AddCartaCamaraCastanhaChaveBaralho());
         
        Cheats_Porta_vermelha_Baralho.addActionListener(new AddCartaPortaVermelhaBaralho());
        Cheats_Porta_azul_Baralho.addActionListener(new AddCartaPortaAzulBaralho());
        Cheats_Porta_verde_Baralho.addActionListener(new AddCartaPortaVerdeBaralho());
        Cheats_Porta_castanha_Baralho.addActionListener(new AddCartaPortaCastanhaBaralho());
        
        Cheats_PesadeloBaralho.addActionListener(new AddCartaPesadeloBaralho());
        
        
        //baralho-expansão
        Cheats_Torre_vermelha_Baralho_1.addActionListener(new AddTorreVermelha3());
        Cheats_Torre_vermelha_Baralho_2.addActionListener(new AddTorreVermelha4());
        Cheats_Torre_vermelha_Baralho_3.addActionListener(new AddTorreVermelha5());
        Cheats_Torre_azul_Baralho_1.addActionListener(new AddTorreAzul3());
        Cheats_Torre_azul_Baralho_2.addActionListener(new AddTorreAzul4());
        Cheats_Torre_azul_Baralho_3.addActionListener(new AddTorreAzul5());
        Cheats_Torre_verde_Baralho_1.addActionListener(new AddTorreVerde3());
        Cheats_Torre_verde_Baralho_2.addActionListener(new AddTorreVerde4());
        Cheats_Torre_verde_Baralho_3.addActionListener(new AddTorreVerde5());
        Cheats_Torre_castanha_Baralho_1.addActionListener(new AddTorreCastanha3());
        Cheats_Torre_castanha_Baralho_2.addActionListener(new AddTorreCastanha4());
        Cheats_Torre_castanha_Baralho_3.addActionListener(new AddTorreCastanha5());
        
    }
    
    
    //ACTION LISTENERS
    
    //======= FICHEIRO =======
    
    //NEW GAME
    class NovoJogoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            String texto="Quer criar um novo jogo?";
            int op;
            
            //tem a certza que quer criar um novo jogo?
            op = JOptionPane.showConfirmDialog(rootPane, texto, "Novo jogo", 2);
           
            
            if(op==0){
                m.setJogo( new Jogo(false)); //criar um jogo novo
                c = new Cheats(m.getJogo()); //passar o novo jogo às cheats
            }
            
            vj.update(m, e);
        }
    }
    //NEW GAME EXP
    class NovoJogoExpListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            String texto="Quer criar um novo jogo com expansão?";
            int op;
            
            //tem a certza que quer criar um novo jogo?
            op = JOptionPane.showConfirmDialog(rootPane, texto, "Novo jogo", 2);
           
            
            if(op==0){
                m.setJogo( new Jogo(true)); //criar um jogo novo com expansão
                c = new Cheats(m.getJogo()); //passar o novo jogo às cheats
            }
            
            vj.update(m, e);
        }
    }
    //SAVE
    class GuardarListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //abrir pop up
                //JFileChooser guardar = new JFileChooser();
                
                //guardar.showSaveDialog(null);
                String s;
                
                s = salvarComo();
                
                if(s != "ERRO")
                    save(s);
                //escrever ficheiro
            } catch (IOException ex) {
                Logger.getLogger(VBarraMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //LOAD
    class CarregarListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try {
                    String s;
                    
                    s = getFile();
                    carregarFicheiro(s);
                } catch (IOException ex) {
                    Logger.getLogger(VBarraMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VBarraMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(VBarraMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
     public String salvarComo() {

        FileNameExtensionFilter filter = new FileNameExtensionFilter(".oni", "oni");
        int val;

        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(filter);
        jfc.setFileFilter(filter);
        val = jfc.showSaveDialog(rootPane);

        String nome;

        if (val != JFileChooser.APPROVE_OPTION) {
            return "ERRO";
        }

        nome = jfc.getSelectedFile().getAbsolutePath();
        nome = nome + jfc.getFileFilter().getDescription();

        return nome;

    }
   
    public String getFile() throws IOException {
         
        int val;
        
        
        jfc.setCurrentDirectory(null);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".oni", "oni");
        jfc.addChoosableFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);

        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setFileFilter(filter);
        val = jfc.showOpenDialog(null);

        String nome;

        if (val != JFileChooser.APPROVE_OPTION) {
            return "ERRO";
        }
        nome = jfc.getSelectedFile().getAbsolutePath();
        if (!jfc.getSelectedFile().isFile()) {
            String s = "FICHEIRO INVÁLIDO\n\nO ficheiro "+nome+" não é admitido. \n\n Ficheiro tem de ser .oni";
            JOptionPane.showMessageDialog(rootPane, s, "Erro", JOptionPane.ERROR_MESSAGE);

            return "ERRO";
        }
        
        System.out.println(nome);
        jfc.removeChoosableFileFilter(filter);
        return nome;
    }
     
    private void carregarFicheiro(String path) throws IOException, ClassNotFoundException, AWTException{
        ObjectInputStream in;        
        
        in = new ObjectInputStream(new FileInputStream(path));

        
        m = (Modelo) in.readObject();
       
        Jogo j = m.getJogo();
                
        VistaJogo v = new VistaJogo(m);

        
        vj.dispose();
        in.close();
       
        v.update(m, null);
                
        
    }
        
        
        
     private void save(String path) throws IOException {
        File fstream = new File(path);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fstream));

        out.writeObject((Modelo) m);

        out.close();
    }

   
    //LOAD
    
    //SAIR
    class SairListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            String texto="Tem a certeza que quer sair?";
            int op;
            
            //tem a certza que quer sair?
            op = JOptionPane.showConfirmDialog(rootPane, texto, "Sair", 2);
            
            if(op==0){
                System.exit(0); 
            }
  
        }  
    }
    
    
    
 //====== CHEATS =============
    
    //============LISTAR CARTAS =========
    class ListarCartasListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            JOptionPane.showMessageDialog(rootPane, c.verCartasTopoBaralho(), "Cartas do topo do baralho", 1);
            
        } 
    }
    
    
    //EXPANSAO
      //adicionar torres ao baralho
    
    //adicionar carta -> baralho -> torre -> vermelha
    class AddTorreVermelha3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(1,3);
            vj.update(m, e); 
        }  
    }
    class AddTorreVermelha4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(1,4);
            vj.update(m, e); 
        }  
    }
    class AddTorreVermelha5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(1,5);
            vj.update(m, e); 
        }  
    }
    //adicionar carta -> baralho -> torre -> azul
    class AddTorreAzul3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(2,3);
            vj.update(m, e); 
        }  
    }
    class AddTorreAzul4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(2,4);
            vj.update(m, e); 
        }  
    }
    class AddTorreAzul5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(2,5);
            vj.update(m, e); 
        }  
    }
    //adicionar carta -> baralho -> torre -> verde
    class AddTorreVerde3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(3,3);
            vj.update(m, e); 
        }  
    }
    class AddTorreVerde4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(3,4);
            vj.update(m, e); 
        }  
    }
    class AddTorreVerde5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(3,5);
            vj.update(m, e); 
        }  
    }
    //adicionar carta -> baralho -> torre -> castanha
    class AddTorreCastanha3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(4,3);
            vj.update(m, e); 
        }  
    }
    class AddTorreCastanha4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(4,4);
            vj.update(m, e); 
        }  
    }
    class AddTorreCastanha5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addTorreBaralho(4,5);
            vj.update(m, e); 
        }  
    }
    
    
    //============= MAO ==================
    
    //addicionar carta -> mao -> camara -> vermelha
    class AddCartaCamaraVermelhaSolMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,1,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaLuaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,2,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaChaveMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,3,1);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mao -> camara -> azul
    class AddCartaCamaraAzulSolMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,1,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulLuaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,2,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulChaveMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,3,2);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mao -> camara -> verde
    class AddCartaCamaraVerdeSolMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,1,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeLuaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,2,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeChaveMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,3,3);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mao -> camara -> castanha
    class AddCartaCamaraCastanhaSolMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,1,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaLuaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,2,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaChaveMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(1,3,4);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mao -> porta
    class AddCartaPortaVermelhaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(2,0,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaAzulMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(2,0,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaVerdeMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(2,0,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaCastanhaMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(2,0,4);
            vj.update(m, e); 
        }  
    }
    //adicionar carta -> mao -> pesadelo
    class AddCartaPesadeloMao implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMao(3,0,0);
            vj.update(m, e); 
        }  
    }
    
    
    //============== MESA ===============
    //addicionar carta -> mesa -> camara -> vermelha
    class AddCartaCamaraVermelhaSolMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,1,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaLuaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,2,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaChaveMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,3,1);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mesa -> camara -> azul
    class AddCartaCamaraAzulSolMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,1,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulLuaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,2,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulChaveMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,3,2);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mesa -> camara -> verde
    class AddCartaCamaraVerdeSolMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,1,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeLuaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,2,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeChaveMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,3,3);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mesa -> camara -> castanha
    class AddCartaCamaraCastanhaSolMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,1,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaLuaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,2,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaChaveMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(1,3,4);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> mesa -> porta
    class AddCartaPortaVermelhaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(2,0,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaAzulMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(2,0,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaVerdeMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(2,0,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaCastanhaMesa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaMesa(2,0,4);
            vj.update(m, e); 
        }  
    }
    
    //======================= BARALHO =============
    
    //addicionar carta -> baralho -> camara -> vermelha
    class AddCartaCamaraVermelhaSolBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,1,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaLuaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,2,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVermelhaChaveBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,3,1);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> baralho -> camara -> azul
    class AddCartaCamaraAzulSolBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,1,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulLuaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,2,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraAzulChaveBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,3,2);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> baralho -> camara -> verde
    class AddCartaCamaraVerdeSolBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,1,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeLuaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,2,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraVerdeChaveBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,3,3);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> baralho -> camara -> castanha
    class AddCartaCamaraCastanhaSolBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,1,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaLuaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,2,4);
            vj.update(m, e); 
        }  
    }
    class AddCartaCamaraCastanhaChaveBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(1,3,4);
            vj.update(m, e); 
        }  
    }
    //addicionar carta -> baralho -> porta
    class AddCartaPortaVermelhaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(2,0,1);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaAzulBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(2,0,2);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaVerdeBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(2,0,3);
            vj.update(m, e); 
        }  
    }
    class AddCartaPortaCastanhaBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(2,0,4);
            vj.update(m, e); 
        }  
    }
    //adicionar carta -> baralho -> pesadelo
    class AddCartaPesadeloBaralho implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c.addCartaBaralho(3,0,0);
            vj.update(m, e); 
        }  
    }
    
       
}
