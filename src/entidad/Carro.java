package entidad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
public class Carro extends Automotor{
    private float cilindraje;
    private String serieMotor;


    public Carro(String placa, String marca, float cilindraje, String color, int modelo) {
        super(placa,marca,modelo,color);
        this.cilindraje = cilindraje;
        this.serieMotor=serieMotor;
    }

    public Carro(String placa) {
        super(placa);
    }

    public String getPlaca() {
        return placa;
    }
    
    
    
}
