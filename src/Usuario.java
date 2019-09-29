
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

    public Usuario(String nombre, String apellido, int edad, String email, String direccion, String tel, int puntos, String placa, String id, String nickname, String password) {
        super(nombre, apellido, edad, email, direccion, tel, id, nickname, password);
        this.puntos = puntos;
        this.carros.add(new Carro(placa));
    }

    public Usuario(String nombre, String apellido, int edad, String id, String placa, String nickname, String password) {
        super(nombre, apellido, edad, id,nickname, password);
        this.puntos = 0;
        this.carros=new ArrayList<>();
    }
    
    public void addCarro(String placa){
        this.carros.add(new Carro(placa));
    }
    
    public boolean eliminarCarro(String placa){
        boolean eliminado= false;
        for(int i=0;i<carros.size();i++){
            if(carros.get(i).getPlaca().equals(placa)){
                carros.remove(i);
                eliminado=true;
            }
        }
        return eliminado;
    }
    
    public boolean comprobarUsuario(String nickname,String password){
        boolean ingresar=false;
        if(this.nickname.equals(nickname)&&this.password.equals(password)){
            ingresar=true;
        }else{
            ingresar=false;
        }
        return ingresar;
    }
}
