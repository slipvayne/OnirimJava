/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;


public class VPortas implements Serializable{
    
    private ArrayList<VCarta> cartas;
    private int x;
    private int y;
    
    
    public VPortas(int _x, int _y) {
        cartas = new ArrayList<VCarta>();
        
        x = _x;
        y = _y;
        
    }
    
    public void add(VCarta c){
        cartas.add(c);
    }
    
    public void desenhar(Graphics g, Component c){
        
        for (int i=0; i < cartas.size(); i++) {
            cartas.get(i).desenhar(g, c);
        }
            
    }
    
    public void update(ArrayList<String> c){
        cartas.clear();
        int aux = x;
        
        for(int i=0; i<c.size(); i++){
            cartas.add(new VCarta( c.get(i)));
            cartas.get(i).setX(aux);
            cartas.get(i).setY(y);
            aux += cartas.get(i).getLarguraImg() - 70;
        }  
    }
    
    
    
}
