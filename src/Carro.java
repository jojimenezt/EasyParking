/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
public class Carro {
    private String placa;
    private float cilindraje;
    private float color;

    public Carro(String placa, float cilindraje, float color) {
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.color = color;
    }

    public Carro(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
    
    
    
}
