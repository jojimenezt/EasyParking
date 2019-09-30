
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
class Usuario extends Persona {
    private int puntos;
    private Carro carro;

    public Usuario() {
        super(null, null, 0, null, null, null);
    }
    
    

    public Usuario(String nombre, String apellido, int edad, String email, String direccion, String tel, int puntos, String placa, String id, String nickname, String password) {
        super(nombre, apellido, edad, email, direccion, tel, id, nickname, password);
        this.puntos = puntos;
        this.carro = new Carro(placa);
    }

    public Usuario(String nombre, String apellido, int edad, String placa, String id, String nickname, String password) {
        super(nombre, apellido, edad, id, nickname, password);
        this.puntos = 0;
        this.carro = new Carro(placa);
    }

    public int getPuntos() {
        return puntos;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
