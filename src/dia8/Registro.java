/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia8;

/**
 *
 * @author thepu
 */
public class Registro {
    int value;
    String nombre;
    
    public Registro(int value, String nombre){
        this.nombre = nombre;
        this.value = value;
    }
    
    public void addValor(int valor){
        this.value += valor; 
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getValue(){
        return this.value;
    }
    
    
}
