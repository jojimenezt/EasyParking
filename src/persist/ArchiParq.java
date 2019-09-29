/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import entidad.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Lenovo
 */
public class ArchiParq {
    public void guardar(Parqueadero parq) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileOutputStream istream=new FileOutputStream("parq.obj");
        ObjectOutputStream salida=new ObjectOutputStream(istream);
        salida.writeObject(parq);
        salida.close();
    }
    
    public Parqueadero recuperar() throws IOException, ClassNotFoundException{
        FileInputStream istream=new FileInputStream("parq.txt");
        ObjectInputStream entrada=new ObjectInputStream(istream);
        Parqueadero parq =(Parqueadero) entrada.readObject();
        entrada.close();
        return parq;
    }
}
