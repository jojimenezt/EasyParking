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
        this.espacios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.empleados = new ArrayList<>();
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
    
    public void addUsuario(String nombre, String apellido, int edad, String placa,String id, String nickname, String password){
        usuarios.add(new Usuario(nombre, apellido, edad, id,placa, nickname,password));
    }
    
    public Usuario buscarUsuario(String nombre, String apellido){
        Usuario usuario= null;
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getNombre().equals(nombre) && usuarios.get(i).getApellido().equals(apellido)){
                usuario=usuarios.get(i);
            }
        }
        if(usuario==null){
            throw new NullPointerException("Usuario no existe");
        }
        return usuario;
    }
    
    public int puestosVacios(){
        int ac=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).isLibre()){
                ac++;
            }
        }
        
        return ac;
    }
    
    
}
