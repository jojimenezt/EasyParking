
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simón
 */
public class Test {
    
    public long[] testList(int n, int p){
        long start = System.nanoTime();
        
        Random rnd = new Random();
        
        Chain<Usuario> usuarios = new Chain();
        
        for(int i=0; i<n; i++) {
            usuarios.add(usuarios.size, new Usuario(randString(rnd, 10),randString(rnd, 10),rnd.nextInt(50)+15, (String)(randString(rnd, 3))+rnd.nextInt(999),randString(rnd, 10),randString(rnd, 10),randString(rnd, 10)));
            if(i%5 == 0) usuarios.get(rnd.nextInt(usuarios.size)).setNombre(randString(rnd, 10));
            if(i%20 == 0) usuarios.remove(rnd.nextInt(usuarios.size));
        }
        
              
        long timex  = System.nanoTime();
        long[] total = new long[2];
        total[0] = timex - start;
        
        
        Chain<Espacio> espacios = new Chain();
        
        for(int i = 0; i<10; i++){
            int lim = rnd.nextInt(p-espacios.size);
            for(int j=0; j<lim; j++) {
                Usuario user = usuarios.get(rnd.nextInt(usuarios.size-1));
                boolean posible = true;
                for(int k=0; k< espacios.size(); k++) if(espacios.get(k).getCarro().getPlaca().equals(user.getCarro().getPlaca())) posible = false;
                
                int nextLibre = -1;
                 if(espacios.size() < p){
                    if(espacios.isEmpty()) nextLibre = 0;
                    else if(espacios.get(espacios.size()-1).getNumero()<p-1) nextLibre =  espacios.get(espacios.size()-1).getNumero()+1;
                    else{
                        for(int l=0; l<espacios.size(); l++) if(espacios.get(l).getNumero() !=l) nextLibre = espacios.get(l).getNumero()+1;
                    }
                 }
                
                if(nextLibre > -1){
                    espacios.add(espacios.size, new Espacio(nextLibre));
                    espacios.get(espacios.size-1).llenar(user);
                }
            }
            if(espacios.size>0) lim = rnd.nextInt(espacios.size);
            else lim = 0;
            for(int j=0; j<lim; j++){
                espacios.remove(rnd.nextInt(espacios.size-1));
            }
        }
        
        total[1] = System.nanoTime()- timex;
        
        return total;
    }

    public long[] testDynamicArray(int n, int p){
        long start = System.nanoTime();
        
        Random rnd = new Random();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            usuarios.add(usuarios.size(), new Usuario(randString(rnd, 10),randString(rnd, 10),rnd.nextInt(50)+15, (String)(randString(rnd, 3))+rnd.nextInt(999),randString(rnd, 10),randString(rnd, 10),randString(rnd, 10)));
            if(i%5 == 0) usuarios.get(rnd.nextInt(usuarios.size())).setNombre(randString(rnd, 10));
            if(i%20 == 0) usuarios.remove(rnd.nextInt(usuarios.size()));
        }
        
              
        long timex  = System.nanoTime();
        long[] total = new long[2];
        total[0] = timex - start;
        
        
        ArrayList<Espacio> espacios = new ArrayList<>();
        
        for(int i = 0; i<10; i++){
            int lim = rnd.nextInt(p-espacios.size());
            for(int j=0; j<lim; j++) {
                Usuario user = usuarios.get(rnd.nextInt(usuarios.size()));
                boolean posible = true;
                for(int k=0; k< espacios.size(); k++) if(espacios.get(k).getCarro().getPlaca().equals(user.getCarro().getPlaca())) posible = false;
                
                int nextLibre = -1;
                 if(espacios.size() < p){
                    if(espacios.isEmpty()) nextLibre = 0;
                    else if(espacios.get(espacios.size()-1).getNumero()<p-1) nextLibre =  espacios.get(espacios.size()-1).getNumero()+1;
                    else{
                        for(int l=0; l<espacios.size(); l++) if(espacios.get(l).getNumero() !=l) nextLibre = espacios.get(l).getNumero()+1;
                    }
                 }
                
                if(nextLibre > -1){
                    espacios.add(espacios.size(), new Espacio(nextLibre));
                    espacios.get(espacios.size()-1).llenar(user);
                }
            }
            if(espacios.size()>0) lim = rnd.nextInt(espacios.size());
            else lim = 0;
            for(int j=0; j<lim; j++){
                espacios.remove(rnd.nextInt(espacios.size()-1));
            }
        }
        
        total[1] = System.nanoTime()- timex;
        
        return total;
    }
    
    public long[] testArray(int n, int p){
        long start = System.nanoTime();
        
        Random rnd = new Random();
        
        Usuario[] usuarios = new Usuario[n];
        
        int usuariosNull = n;
        
        for(int i=0; i<n; i++) {
            usuarios[i] = new Usuario(randString(rnd, 10),randString(rnd, 10),rnd.nextInt(50)+15, (String)(randString(rnd, 3))+rnd.nextInt(999),randString(rnd, 10),randString(rnd, 10),randString(rnd, 10));
            
            usuariosNull--;
            if(i%5 == 0) usuarios[rnd.nextInt(n)].setNombre(randString(rnd, 10));
            if(i%20 == 0){
                usuarios[rnd.nextInt(n)] = null;
                usuariosNull++;
            }
            if(i%100 == 0) System.out.println(i);
        }
        
              
        long timex  = System.nanoTime();
        long[] total = new long[2];
        total[0] = timex - start;
        
        
        Espacio[] espacios = new Espacio[p];
        int espaciosOcupados = 0;
        
        for(int i = 0; i<10; i++){
            int lim = rnd.nextInt(p-espaciosOcupados);
            for(int j=0; j<lim; j++) {
                Usuario user = usuarios[rnd.nextInt(n)];
                boolean posible = true;
                for(int k=0; k< n; k++) if(espacios[k] != null) {
                        if(espacios[k].getCarro().getPlaca().equals(user.getCarro().getPlaca())) posible = false;
                }
                
                int nextLibre = -1;
                
                if(espacios[n-espaciosOcupados] == null) nextLibre = n-espaciosOcupados;
                else{
                    for(int k=0; k<n; k++) if(espacios[k] == null) nextLibre = k;
                }
                
                if(nextLibre > -1){
                    espacios[nextLibre]= new Espacio(nextLibre);
                    espacios[nextLibre].llenar(user);
                }
            }
            lim = rnd.nextInt(n);
            for(int j=0; j<lim; j++){
                espacios[rnd.nextInt(n)]=null;
            }
        }
        
        total[1] = System.nanoTime()- timex;
        
        return total;
    }
    
    public String randString(Random rnd, int n){
        StringBuilder strb = new StringBuilder();
        for(int i=0; i<n; i++) strb.append((char)(rnd.nextInt(25)+65));
        return strb.toString();
    }
    
}
