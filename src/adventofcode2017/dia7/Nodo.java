/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2017.dia7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thepu
 */
public class Nodo {
    List<Nodo> hijos;
    Nodo padre;
    int longuitud;
    String nombre;
    boolean esmain;
    int numero;
    
    public Nodo(){
        hijos = new ArrayList<>();
        longuitud = 0;
        esmain = false;
        numero = -1;
    }
    
    public Nodo(String nombre){
        super();
        this.nombre = nombre;
        this.numero = -1;
    }
    
    public void addPadre(Nodo padre){
        this.padre = padre;
    }
    
    public void addHijo(Nodo hijo){
        hijos.add(hijo);
        hijo.addPadre(this);
    }
    
    public boolean esMain(){
        if(padre==null)return true;
        else return false;
    }
    
    public boolean esPadre(){
        if(this.hijos.size()>0)return true;
        return false;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public int getLonguitud(){
        if(hijos.size()==0)return 1;
        else return this.hijos.get(0).getLonguitud()+1;
    }
    
    public List<Nodo> getHijos(){
        return this.hijos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public boolean esHijoDirecto(Nodo nodoaux){
        for(int i = 0; i<this.hijos.size();i++)
            if(nodoaux.nombre.equals(this.hijos.get(i).nombre))return true;
        
        return false;
    }
    
    public int sumValores(){
        int acum = this.numero;
        for(int i = 0;i<this.hijos.size();i++){
            acum +=this.hijos.get(i).sumValores();
        }
        return acum;
    }
    
//    public Nodo contieneNodo(Nodo nodoaux){
//        if(this.nombre==nodoaux.nombre)return this;
//        else {
//            for(int i = 0; i<this.hijos.size();i++)
//                contieneNodo(this.hijos.get(i).contieneNodo(nodoaux));
//        }
//        return null;
//    }
}
