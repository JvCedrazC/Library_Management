package com.example.biblioteca.FileUtils;

import java.io.*;
import java.util.ArrayList;

public class ManagingFiles implements Serializable {

    /**
     * Nome do arquivo utilizado para operações de leitura e escrita.
     */
    private String fileName;
    /**
     * Construtor da classe ManagingFiles que recebe o nome do arquivo.
     *
     * @param fileName O nome do arquivo a ser utilizado.
     */
    public ManagingFiles(String fileName){
        this.fileName = fileName;
    }

    /**
     * Salva a lista de objetos no arquivo especificado.
     *
     * @param list A lista de objetos a ser salva no arquivo.
     * @param <T> O tipo dos objetos na lista.
     */
    public <T> void save(ArrayList<T> list){
        try {
            FileOutputStream file = new FileOutputStream(this.fileName);
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(list);
            object.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Recupera a lista de objetos do arquivo especificado.
     *
     * @return A lista de objetos recuperada do arquivo.
     * @param <T> O tipo dos objetos na lista.
     */
    public <T> ArrayList<T> retrieve(){
        try{
            ArrayList<T> list;
            File file = new File(fileName);
            if (!file.exists()){
                save(new ArrayList<T>());
            }
            FileInputStream fileStream = new FileInputStream(this.fileName);
            ObjectInputStream os = new ObjectInputStream(fileStream);
            list = (ArrayList<T>) os.readObject();
            os.close();
            return list;
        }catch (IOException | ClassNotFoundException exception){
            throw new RuntimeException(exception);
        }

    }

}
