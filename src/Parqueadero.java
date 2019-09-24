/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */

import java.util.*;

public class Parqueadero {
    
    private ArrayList<Espacio> espacios;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Empleado> empleados;
    
    int espaciosTotales;

    public Parqueadero() {
        espacios = new ArrayList<>();
        usuarios = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    
    public void addEspacio(){
        espacios.add(new Espacio(espaciosTotales+1));
        espaciosTotales++;
    }
    
    public void addUsuario(String nombre, String apellido, int edad, String placa){
        usuarios.add(new Usuario(nombre, apellido, edad, placa));
    }
    
    
}
