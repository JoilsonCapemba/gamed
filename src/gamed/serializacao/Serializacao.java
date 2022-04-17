package gamed.serializacao;

import gamed.Obra;
import gamed.Utente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializacao<T> {
    public void serializar(T obj, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T deserialize(String fileName) {
        T obj = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = (T) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return obj;
    }
}
