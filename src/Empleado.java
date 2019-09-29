/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
class Empleado extends Persona {
    private String nombre;
    private String cargo;
    private int salario;

    public Empleado(String nombre, String apellido, int edad, String email, String direccion, String tel, String cargo, int salario, String id) {
        super(nombre, apellido, edad, email, direccion, tel,id);
        this.cargo = cargo;
        this.salario = salario;
    }

    public Empleado(String cargo, int salario, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }
    
}

  
