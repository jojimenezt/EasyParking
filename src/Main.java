import java.util.*;
import sun.security.tools.KeyStoreUtil;
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
                        System.out.println("2. Agregar automovil");
                        System.out.println("3. Eliminar automovil");
                        System.out.println("4. Reservar parqueo automovil");
                        System.out.println("5. Solicitar factura");
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
                                System.out.println("Ingrese su numero de identificacion");
                                String id= x.next();
                                System.out.println("Ingrese su nickname");
                                String nickname= x.next();
                                System.out.println("Ingrese su contraseña");
                                String password= x.next();
                                parq.addUsuario(nombre, apellido, edad, placa, id,nickname,password);
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
                                System.out.println("Ingrese su nombre: ");
                                String nombre2= x.next();
                                System.out.println("Ingrese su apellido");
                                String apellido2= x.next();
                                Usuario u1= parq.buscarUsuario(nombre2, apellido2);
                                 if(u1==null){
                                    System.out.println("No existe, debe registrarse");
                                }else{
                                    System.out.println("Ingrese la placa del carro a eliminar: ");
                                    String placa3= x.next();
                                    u1.eliminarCarro(placa3);
                                }
                            break;
                            
                            case 4:
                                //revisar como se va a hacer lo de los lugares de parqueo
                            break;
                            
                            case 5:
                                //revisar lo de puntos 
                            break;
                            
                        }
                    }while(l!=0);
                break;
                
                case 2:
                    int m=0;
                    do{
                        System.out.println("1. Determinar el numero de puestos vacios: ");
                        System.out.println("2. Determinar la contabilidad de Easy Parking: ");
                        System.out.println("3. Agregar espacio al parqueadero: ");
                        System.out.println("4. Agregar espacio al parqueadero: ");
                        System.out.println("0. Salir");
                        m=x.nextInt();
                        switch(m){
                            case 1:
                                System.out.println("El numero de espacios vacios es: "+ parq.puestosVacios());
                            break;
                            
                            case 2:
                                //contabilidad
                            break;
                            
                            case 3:
                                parq.addEspacio();
                                System.out.println("Se ha agregado un nuevo espacio en el parqueadero");
                            break;
                            
                        }
                        
                    }while(m!=0);
                break;
                
            }
            
        }while(k!=0);
        
    }
}
