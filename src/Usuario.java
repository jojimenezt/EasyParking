
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
    private ArrayList<Carro> carros;

    public Usuario(String nombre, String apellido, int edad, String email, String direccion, String tel, int puntos, String placa) {
        super(nombre, apellido, edad, email, direccion, tel);
        this.puntos = puntos;
        this.carros.add(new Carro(placa));
    }

    public Usuario(String nombre, String apellido, int edad, String placa) {
        super(nombre, apellido, edad);
        this.puntos = 0;
        this.carros.add(new Carro(placa));
    }
    
    public void addCarro(String placa){
        this.carros.add(new Carro(placa));
    }
    
}
