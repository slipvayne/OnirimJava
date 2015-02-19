
package Cartas;

import java.io.Serializable;


public class CLTorre extends CLabirinto implements Serializable{
    
    private int numero;    //numero escrito na carta 3,4 ou 5
    private boolean sol_e; //tem sol esquerdo?
    private boolean sol_d; //tem sol direito?
    private boolean lua_e; //tem lua esquerda?
    private boolean lua_d; //tem lua direita?
    
    public CLTorre(int cor, int num){
        super(cor);
        
        numero = num;
        
        sol_e = false;
        sol_d = false;
        lua_e = false;
        lua_d = false;
        
        
        //TORRES VERMELHAS
        if(cor==1 && num==3){
            sol_e = true;
            lua_e = true;
            lua_d = true;
        }
        if(cor==1 && num==4){
            sol_e = true;
            lua_d = true;   
        }
        if(cor==1 && num==4){
            lua_d = true;
        }
        //TORRES AZUIS
        if(cor==2 && num==3){
            sol_d = true;
            lua_e = true;
            lua_d = true;
        }
        if(cor==2 && num==4){
            lua_e = true;
            lua_d = true;
        }
        if(cor==2 && num==5){
            lua_e = true;
        }
        //TORRES VERDES
        if(cor==3 && num==3){
            sol_e = true;
            sol_d = true;
            lua_d = true;
        }
        if(cor==3 && num==4){
            sol_d = true;
            sol_e = true;
        }
        if(cor==3 && num==5){
            sol_e = true;
        }
        //TORRES CASTANHAS
        if(cor==4 && num==3){
            lua_e = true;
            sol_e = true;
            sol_d = true;
        }
        if(cor==4 && num==4){
            lua_e = true;
            sol_d = true;
        }
        if(cor==4 && num==5){
            sol_d = true;
        }
        
        
    }
    
    //GETS
    
    //tipo 7 = torre
    public int getTipo(){
        return 7;
    }
    
    public boolean getSol_e(){
        return sol_e;
    }
    public boolean getSol_d(){
        return sol_d;
    }
    public boolean getLua_e(){
        return lua_e;
    }
    public boolean getLua_d(){
        return lua_d;
    }
    public int getNumeroTorre(){
        return numero;
    }    
    
    
    
}
