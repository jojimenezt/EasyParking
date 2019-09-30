/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
public class Espacio {
    
    private int numero;
    private boolean libre;
    private Carro carro;

    public int getNumero() {
        return numero;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Espacio(int numero) {
        this.numero = numero;
        this.libre = true;
        this.carro = null;
    }
    
    public void llenar(Usuario usuario){
        this.carro = usuario.getCarro();
        this.libre = false;
    }

    public Carro getCarro() {
        return carro;
    }
    
    
        
    
}
