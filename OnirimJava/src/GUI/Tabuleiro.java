
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.*;
import projecto.ImageCreator;


public class Tabuleiro extends JPanel implements Serializable{
    
    private final String IMG_FUNDO = "images\\background.jpg";
    private static ImageIcon ImageIcon_fundo;
    
    private VBaralho VBaralho;
    private VMao VMao;
    private VMesa VMesa;
    private VLimbo VLimbo;
    private VEliminadas VEliminadas;
    private VPortas VPortas;
    private VProfecia VProfecia;
    private OpProfecia OpProfecia;
    
    //expansao
    private VTorres VTorres;
    
    private VBarraMenu VBarraMenu;
    
    //private static String vista_actual;
    private String vista_actual;
    
    private String instrucao;
    private Modelo modelo;
    
    
    public Tabuleiro(Modelo m){
        ImageIcon_fundo = (new ImageCreator( IMG_FUNDO )).createImageIcon();
        //setSize(1024, 900);
        
        //VBaralho = new VBaralho(10,20);
        VBaralho = new VBaralho(600,500);
        VMao = new VMao(20,500);
        VMesa = new VMesa(20,300);
        VLimbo = new VLimbo(530, 20);
        //VEliminadas = new VEliminadas(200,20);
        VEliminadas = new VEliminadas(600,300);
        
        VPortas = new VPortas(50,100);
        
        VProfecia = new VProfecia(800,60);
        OpProfecia = new OpProfecia(600,400);
        
        VTorres = new VTorres(470,100);
        //Menu = new Menu(topo do programa);
        //VBarraMenu = new VBarraMenu();   
        
        modelo = m;
        
        
        setBackground(Color.WHITE);
        vista_actual = "Normal";
    }
    
    
    protected void paintComponent(Graphics g){
        int count = 0;
        int total_portas;
        super.paintComponent(g);
        
        Image Img_fundo = ImageIcon_fundo.getImage();
        g.drawImage(Img_fundo, 0, 0, null);
        
        
        /*for(int i = 0; i<modelo.getJogo().getBaralho().size(); i++)
            if(modelo.getBaralho().get(i).getTipo() == 4) //se for uma PORTA
                count++;
        for(int i = 0; i<modelo.getJogo().getLimbo().size(); i++)
            if(modelo.getLimbo().get(i).getTipo() == 4)  //se for uma PORTA
                count++;
        */
        
        
        
        
         //total_portas = 8-count;
         total_portas = modelo.getPortas().size();
         
         if(modelo.getJogo().getEstado_actual() == modelo.getJogo().getEProfecia())         
             vista_actual = "Profecia";
         else if(modelo.getJogo().getEstado_actual() == modelo.getJogo().getEProfeciaTorres())
             vista_actual = "ProfeciaTorres";
         else
             vista_actual = "Normal";
        
                  
         //SE JA NÃO EXISTIREM CARTAS VÁLIDAS NO BARALHO (só portas ou pesadelos)
           //o user deverá perder o jogo (Fase final = perdeu)
         if(modelo.getJogo().getEstado_actual() == modelo.getJogo().getEFinal()){
             vista_actual = "Final";
         }
         if(vista_actual.equalsIgnoreCase("Final")){
            Font f2 = new Font(Font.SERIF,Font.ITALIC,20);
            g.setFont(f2);
            g.setColor(Color.DARK_GRAY);
            g.drawString("já não existem cartas no baralho...", 380, 350);
            Font f = new Font(Font.SERIF,Font.BOLD,60);
            g.setFont(f);
            g.setColor(Color.DARK_GRAY);
            g.drawString("Perdeu...", 400, 300);
                               
            return;
         }
         
         
         //se tiver menos de 8 OU ( 8 portas e não tiver ainda as torres e a expansão)
         if((total_portas < 8 ) || (total_portas >=8 && modelo.getJogo().getTorres_ok()==false && modelo.getJogo().getExpansao()==true)){
  
            Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
            g.setFont(font);
            //g.setColor(Color.WHITE);
            g.setColor(Color.LIGHT_GRAY);
            
            g.drawString(String.valueOf(total_portas)+"/8", 400, 90);

            Font f = new Font(Font.SERIF,Font.BOLD,30);
            g.setFont(f);
            //g.drawString("Portas abertas", 500, 200);
            g.drawString("Portas abertas", 200, 90);
            
            VBaralho.desenhar(g, this);
            VMao.desenhar(g, this);
            VMesa.desenhar(g, this);
            VEliminadas.desenhar(g, this);
            VPortas.desenhar(g, this);
            
            //jogo com expansão
            if(modelo.getJogo().getExpansao() == true)
                VTorres.desenhar(g, this);
            
            
            //g.setColor( Color.GREEN);
            g.setColor( Color.LIGHT_GRAY);
            
            
            if (vista_actual.equalsIgnoreCase("Normal")) {
                //g.drawString("Em Jogo", 400, 720);
                g.drawString("Em Jogo", 20, 60);
            }
            if(vista_actual.equalsIgnoreCase("Profecia"))
            {
                VProfecia.desenhar(g, this);
                //g.drawString("Profecia", 400, 720);
                g.drawString("Profecia", 20, 60);
            }
            if(vista_actual.equalsIgnoreCase("ProfeciaTorres"))
            {
                VProfecia.desenhar(g, this);
                g.drawString("Profecia(T)", 20, 60);
            }
            
         }else{
                
             //tem 8 portas abertas e é um jogo normal?
             if(modelo.getPortas().size() == 8 && modelo.getJogo().getExpansao() == false){
                Font f2 = new Font(Font.SERIF,Font.ITALIC,20);
                g.setFont(f2);
                g.setColor(Color.LIGHT_GRAY);
                g.drawString("conseguiu abrir todas as portas!", 390, 350);
                Font f = new Font(Font.SERIF,Font.BOLD,60);
                g.setFont(f);
                //g.setColor(Color.WHITE);
                g.setColor(Color.LIGHT_GRAY);
                //g.drawString("Venceu!", 250, 300);
                g.drawString("Venceu!", 400, 300);
                //se tiver 8 portas e a combinação de torres E se for um jogo com expansão
             }else if(modelo.getPortas().size() == 8 && modelo.getJogo().getTorres_ok() == true && modelo.getJogo().getExpansao() == true){
                Font f2 = new Font(Font.SERIF,Font.ITALIC,20);
                g.setFont(f2);
                g.setColor(Color.LIGHT_GRAY);
                g.drawString("conseguiu abrir todas as portas e todas as torres!", 380, 350);
                Font f = new Font(Font.SERIF,Font.BOLD,60);
                g.setFont(f);
                //g.setColor(Color.WHITE);
                g.setColor(Color.LIGHT_GRAY);
                //g.drawString("Venceu!", 250, 300);
                g.drawString("Venceu!", 400, 300);
             }else if(modelo.getBaralho().isEmpty()){
                Font f2 = new Font(Font.SERIF,Font.ITALIC,20);
                g.setFont(f2);
                g.setColor(Color.DARK_GRAY);
                g.drawString("já não existem cartas no baralho...", 380, 350);
                Font f = new Font(Font.SERIF,Font.BOLD,60);
                g.setFont(f);
                //g.setColor(Color.RED);
                g.setColor(Color.DARK_GRAY);
                //g.drawString("Perdeu...", 250, 300);
                g.drawString("Perdeu...", 400, 300);
             }
             
         }
            
    }   

//==== GETS E SETS =====
    
    //gets
    public VBaralho getVBaralho(){
        return VBaralho;
    }
    public VMao getVMao(){
        return VMao;
    }
    public VMesa getVMesa(){
        return VMesa;
    }
    public VLimbo getVLimbo(){
        return VLimbo;
    }
    public VEliminadas getVEliminadas(){
        return VEliminadas;
    }
    public VPortas getVPortas(){
        return VPortas;
    }
    public VProfecia getVProfecia(){
        return VProfecia;
    }
    public VTorres getVTorres(){
        return VTorres;
    }
    public VBarraMenu getVBarraMenu(){
        return VBarraMenu;
    }
    public String getVista_actual(){
        return vista_actual;
    }
    public String getInstrucao(){
        return instrucao;
    }
    
    //sets
    public void setVBaralho(VBaralho v) {
        VBaralho = v;
    }
    public void setVMao(VMao v) {
        VMao = v;
    }
    public void setVMesa(VMesa v) {
        VMesa = v;
    }
    public void setVLimbo(VLimbo v) {
        VLimbo = v;
    }
    public void setVEliminadas(VEliminadas v) {
        VEliminadas = v;
    }
    public void setVPortas(VPortas v){
        VPortas = v;
    }
    public void setVProfecia(VProfecia v) {
        VProfecia = v;
    }
    public void setVBarraMenu(VBarraMenu v){
        VBarraMenu = v;
    }
    public void setVista_actual(String s){
        vista_actual = s;
    }
    public void setInstrucao(String s){
        instrucao = s;
    }


//====FIM GETS E SETS ====
}
    
    

