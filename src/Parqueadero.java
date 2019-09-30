/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parqueadero {
    
    private ArrayList<Espacio> espacios;
    private ArrayList<Usuario> usuarios;
    
    
    int espaciosTotales;
    
    int espaciosOcupados;


    public Parqueadero() {
        this.espacios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void addEspacio(){
        espacios.add(new Espacio(espaciosTotales+1));
        espaciosTotales++;
    }
    
    public void addUsuario(String nombre, String apellido, int edad, String placa,String id, String nickname, String password){
        usuarios.add(new Usuario(nombre, apellido, edad, id, placa, nickname,password));
    }
    /*
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
    }*/
    
    public Usuario buscarId(String id){
        Usuario usuario= null;
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getId().equals(id)){
                usuario=usuarios.get(i);
            }
        }
        if(usuario==null){
            throw new NullPointerException("Usuario no existe");
        }
        return usuario;
    }
    
    public boolean comprobarUsuario(String nickname,String password){
        boolean ingresar=false;
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getNickname().equals(nickname) && usuarios.get(i).getPassword().equals(password)){
                ingresar=true;
            }else{
                ingresar=false;
            }
        }
        return ingresar;
    }
    
    public int puestosVacios(){
        return espaciosTotales - espacios.size();
    }
    
    public int nextLibre(){
        if(espacios.size() < espaciosTotales) {
            if(espacios.isEmpty()) return 0;
            else if(espacios.get(espacios.size()-1).getNumero()<espaciosTotales-1) return espacios.get(espacios.size()-1).getNumero()+1;
            else{
                for(int i=0; i<espacios.size(); i++) if(espacios.get(i).getNumero() !=i) return espacios.get(i-1).getNumero()+1;
            }
        }
        return -1;
        
    }
    
    public void parqueo(Usuario user){
        if(espacios.size() < espaciosTotales){
            for(int i=0; i< espacios.size(); i++) if(espacios.get(i).getCarro().getPlaca().equals(user.getCarro().getPlaca())){
                    System.out.println("Carro ya en parqueadero");
                    return;
            }
            int nextLibre = nextLibre();
            espacios.add(espacios.size(), new Espacio(nextLibre));
            espacios.get(espacios.size()-1).llenar(user);
        } else {
            System.out.println("Parqueadero ocupado");
        }
    }
    
    public void desparqueo(Usuario user){
        for(int i=0; i< espacios.size(); i++) if(espacios.get(i).getCarro().getPlaca().equals(user.getCarro().getPlaca())) espacios.remove(i);
    }

    public int getEspaciosTotales() {
        return espaciosTotales;
    }

    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }
    
    public void cargarInfo(File archivo) throws FileNotFoundException{
        Scanner x= new Scanner(archivo);
        x.useDelimiter("//");
        Usuario user = new Usuario();
        int ac=0;
        while(x.hasNext()){
            user.setNombre(x.next());
            user.setApellido(x.next());
            user.setEdad(x.nextInt());
            user.setCarro(new Carro(x.next()));
            user.setId(x.next());
            user.setNickname(x.next());
            user.setPassword(x.next());
            ac++;
            usuarios.add(user);
        }
        
        
    }
    
    public Usuario asignarUsuario(String nickname, String password){
        Usuario u= null;
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getNickname().equals(nickname) && usuarios.get(i).getNickname().equals(nickname)){
                u=usuarios.get(i);
            }
        }
        
        return u;
    }
    
    public String retornarUsuario(File file) throws FileNotFoundException{
        String u= null;
        Scanner x= new Scanner(file);
        while(x.hasNextLine()){
            String temp=x.nextLine().trim();
        }
        return u;
    }
}
