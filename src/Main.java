import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
public class Main {
    public static void main(String[] args) {
        Parqueadero parq = new Parqueadero();
        Scanner x= new Scanner(System.in);
        int k=0;
        do{
            System.out.println("Bienvenido a Easy parking, seleccione el tipo de usuario: ");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("0. Salir");
            k= x.nextInt();
            switch(k){
                case 1:
                    int l=0;
                    do{
                        System.out.println("Que desea hacer:");
                        System.out.println("1. Registarse");
                        System.out.println("2. Agregar carro");
                        System.out.println("3. Eliminar carro");
                        System.out.println("4. Parquear carro");
                        System.out.println("5.Solicitar factura");
                        System.out.println("0. Salir");
                        l= x.nextInt();
                        switch(l){
                            case 1:
                                System.out.println("Ingrese su nombre: ");
                                String nombre=x.next();
                                System.out.println("Ingrese su apellido: ");
                                String apellido= x.next();
                                System.out.println("Ingrese la edad: ");
                                int edad= x.nextInt();
                                System.out.println("Ingrese el numero de la placa del carro");
                                String placa= x.next();
                                parq.addUsuario(nombre, apellido, edad, placa);
                                System.out.println("Ingreso exitoso");
                            break;
                            
                            case 2:
                                System.out.println("Ingrese su nombre: ");
                                String nombreb= x.next();
                                System.out.println("Ingrese su apellido: ");
                                String apellidob= x.next();
                                Usuario u=parq.buscarUsuario(nombreb, apellidob);
                                if(u.equals(null)){
                                    System.out.println("No existe, debe registrarse");
                                }else{
                                    System.out.println("Ingrese la placa del nuevo carro: ");
                                    String placa2= x.next();
                                    u.addCarro(placa2);
                                }
                            break;
                            
                            case 3:
                                System.out.println("Ingrese la placa del carro a eliminar: ");
                            break;
                            
                        }
                    }while(l!=0);
                break;
                
                case 2:
                break;
                
            }
            
        }while(k!=0);
        
    }
}
