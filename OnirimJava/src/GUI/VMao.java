
package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;


public class VMao implements Serializable{
    
    private ArrayList<VCarta> cartas;
    private String info;
    private int x;
    private int y;
    
    
    public VMao(int _x, int _y) {
        cartas = new ArrayList<VCarta>();
        
        x = _x;
        y = _y;
        
    }
    
    public void desenhar(Graphics g, Component c){
        VCarta aux = null;
        
        for(int i=0; i<cartas.size(); i++){
            if( cartas.get(i).getSelected() == false){
                cartas.get(i).desenhar(g, c);
            }else{
                aux = cartas.get(i);
            }
        }
        
        if (aux != null)
            aux.desenhar(g, c);
            
    }
    
    
    public VCarta escolherCarta(int _x, int _y){
        
        for(int i=0; i<cartas.size(); i++){
            if( cartas.get(i).getSelected() == true){
                return cartas.get(i);
            }  
        }
        
        for(int i=0; i<cartas.size(); i++){
            if(cartas.get(i).contains(_x, _y)){
                cartas.get(i).setSelected(true);
                return cartas.get(i);
            }
        }
        
        return null;     
    }
    
    
    public void moverCarta(int _x, int _y){
        for(int i=0; i<cartas.size(); i++){
            if(cartas.get(i).getSelected() == true){
                cartas.get(i).move(_x, _y);
            }
        }
    }
    
    
    public void reset(){
        for(int i=0; i<cartas.size(); i++)
            cartas.get(i).reset();
    }
    
    
    public void update(ArrayList<String> c){
        
        cartas.clear();
        int aux = x;
        
        for(int i=0; i<c.size(); i++){
            cartas.add(new VCarta( c.get(i)));
            cartas.get(i).setX(aux);
            cartas.get(i).setY(y);
            aux += cartas.get(i).getLarguraImg() + 5;
        }    
    }
    
    
    public void add(VCarta c){
        cartas.add(c);
    }
    
    
//==== GETS E SETS =====
    
    //gets
    public ArrayList<VCarta> getCartas(){
        return cartas;
    }
    public int getCartaEscolhida(){
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getSelected() == true) {
                return i;
            }
        }
        return -1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    //sets
    public void setCartas(ArrayList<VCarta> c){
        cartas = c;
    }
    
    
    
//==== FIM GETS E SETS====
    
    
    
}
