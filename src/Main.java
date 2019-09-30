import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
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
    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }
    
    public static void test() throws FileNotFoundException{
        PrintStream archivoTiempos = new PrintStream("times.txt");
        
        Test test = new Test();
        
        for(int i=2; i<6; i++){
        
            int n = (int) Math.pow(10,i);
            int p = n/4;            
            System.out.println("\nn = "+n+"  p = "+p);
            archivoTiempos.println("\nn = "+n+"  p = "+p);
            long[] times;
            
            System.out.println("\n  DYNAMIC ARRAY: ");
            archivoTiempos.println("\n  DYNAMIC ARRAY: ");
            times = test.testDynamicArray(n,p);
            printNano(times[0],archivoTiempos);
            printNano(times[1],archivoTiempos);
            
            System.out.println("\n  ARRAY: ");
            archivoTiempos.println("\n  ARRAY: ");
            times = test.testDynamicArray(n,p);
            printNano(times[0],archivoTiempos);
            printNano(times[1],archivoTiempos);
            
            
            System.out.println("\n  LIST:");
            archivoTiempos.println("\n  LIST:");
            times = test.testList(n,p);
            printNano(times[0],archivoTiempos);
            printNano(times[1],archivoTiempos);
            
        }
    }
    
    public static void test(int n, int p) throws FileNotFoundException{
        PrintStream archivoTiempos = new PrintStream("times.txt");
        
        Test test = new Test();
               
        System.out.println("\nn = "+n+"  p = "+p);
        archivoTiempos.println("\nn = "+n+"  p = "+p);
        long[] times;

        System.out.println("\n  DYNAMIC ARRAY: ");
        archivoTiempos.println("\n  DYNAMIC ARRAY: ");
        times = test.testDynamicArray(n,p);
        printNano(times[0],archivoTiempos);
        printNano(times[1],archivoTiempos);

        System.out.println("\n  ARRAY: ");
        archivoTiempos.println("\n  ARRAY: ");
        times = test.testDynamicArray(n,p);
        printNano(times[0],archivoTiempos);
        printNano(times[1],archivoTiempos);


        System.out.println("\n  LIST:");
        archivoTiempos.println("\n  LIST:");
        times = test.testList(n,p);
        printNano(times[0],archivoTiempos);
        printNano(times[1],archivoTiempos);
        
    }
    
    public static void printNano(long ns, PrintStream archivo){
        System.out.println("  ns: "+ns);
        archivo.println("  ns: "+ns);
        int s = (int) (ns / Math.pow(10,9));
        if(s>0){
            System.out.print("  tiempo = " + (int)(s/60)+":"+(s%60));
            archivo.print("  tiempo = " + (int)(s/60)+":"+(s%60));
            System.out.println();
            archivo.println();
        }
    }
    
    public static void menu() throws FileNotFoundException{
        Parqueadero parq = new Parqueadero();
        BufferedReader bf = new BufferedReader(new FileReader("data.easy"));
        parq.cargarInfo(new File("data.easy"));
        for(int i=0;i<parq.getUsuarios().size();i++){
            System.out.println(parq.getUsuarios().get(i));
        }
        PrintStream lectura= new PrintStream("data.easy");
        for(int i=0;i<parq.getUsuarios().size();i++){
          lectura.print(parq.getUsuarios().get(i).getNombre()+ "//");
          lectura.print(parq.getUsuarios().get(i).getApellido()+ "//");
          lectura.print(parq.getUsuarios().get(i).getEdad()+ "//");
          lectura.print(parq.getUsuarios().get(i).getCarro().getPlaca()+ "//");
          lectura.print(parq.getUsuarios().get(i).getId()+ "//");
          lectura.print(parq.getUsuarios().get(i).getNickname()+ "//");
          lectura.print(parq.getUsuarios().get(i).getPassword());
        }
        
        Usuario temp = null;
        
        Scanner x= new Scanner(System.in);
        int k=0;
        do{
            System.out.println("1. Entrar como usuario");
            System.out.println("2. Test");
            System.out.println("0. Salir");
            k= x.nextInt();
            switch(k){
                case 1:
                    int l=0;
                    do{
                        System.out.println("1. Registro");
                        System.out.println("2. Login");
                        System.out.println("0. Salir");
                        l= x.nextInt();
                        switch(l){
                            case 1:
                                System.out.println("Ingrese su nombre: ");
                                String nombre=x.next();
                                lectura.print(nombre + "//");
                                System.out.println("Ingrese su apellido: ");
                                String apellido= x.next();
                                lectura.print(apellido + "//");
                                System.out.println("Ingrese la edad: ");
                                int edad= x.nextInt();
                                lectura.print(edad + "//");
                                System.out.println("Ingrese el numero de la placa del carro");
                                String placa= x.next();
                                lectura.print(placa + "//");
                                System.out.println("Ingrese su numero de identificacion");
                                String id= x.next();
                                lectura.print(id + "//");
                                System.out.println("Ingrese su nickname");
                                String nickname= x.next();
                                lectura.print(nickname + "//");
                                System.out.println("Ingrese su contraseña");
                                String password= x.next();
                                lectura.print(password + "//");
                                parq.addUsuario(nombre, apellido, edad, placa, id,nickname,password);
                                System.out.println("Ingreso exitoso");
                            break;
                            
                            
                            case 2:
                                int opc=0;
                                do{
                                    if(temp == null){
                                        System.out.println("Ingrese nickname");
                                        String nickname2=x.next();
                                        System.out.println("Ingrese contraseña");
                                        String password2=x.next();
                                        if(parq.comprobarUsuario(nickname2, password2)) temp = parq.asignarUsuario(nickname2, password2);
                                        else {
                                            temp = null;
                                            System.out.println("El usuario no existe debe registrarse");
                                        }
                                    }
                                    if(temp != null){ 
                                        System.out.println("1. Parquear carro");
                                        System.out.println("2. Terminar servicio de parqueadero");
                                        System.out.println("0. Cerrar secion");
                                        opc=x.nextInt();
                                        switch(opc){
                                            case 1:
                                                parq.parqueo(temp);
                                                System.out.println("Se ha parqueado el carro");
                                            break;
                                            
                                            case 2:
                                                parq.desparqueo(temp);
                                                System.out.println("Se ha desparqueado el carro");
                                            break;
                                        }
                                    }
                                }while(opc!=0);
                            break;
                        }
                    }while(l!=0);
                break;
                
                case 2:
                    System.out.println("1. Automatico");
                    System.out.println("2. Personalizado");
                    System.out.println("0. Salir");
                    l= x.nextInt();
                    switch(l){
                        case 1:
                            test();
                        case 2:
                            System.out.println("Elija los valores a trabajar");
                            System.out.println("n: ");
                            int n = x.nextInt();
                            System.out.println("p: ");
                            int p = x.nextInt();
                            test(n,p);
                            
                    }
                            
                break;
                                
            }
        }while(k!=0);  
    }
    
    
}
