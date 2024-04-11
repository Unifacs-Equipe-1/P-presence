package clientes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    private Object pessoa;
    private String caminho;

    public Database(Object pessoa, String caminho) {
        this.pessoa = pessoa;
        this.caminho = caminho;
    }

    public void saveOnFile() {

        try {
            ArrayList<Object> cadastros = new ArrayList<Object>();
            cadastros = this.readOnFile();
            FileOutputStream save = new FileOutputStream(this.caminho);
            ObjectOutputStream stream = new ObjectOutputStream(save);
            cadastros.add(this.pessoa);
            stream.writeObject(cadastros);
            stream.flush();
            stream.close();
            save.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao descarregar os dados ou arquivo não encontrado");
        } finally {
            System.out.println("Objeto salvo com sucesso!");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Object> readOnFile() {
        ArrayList<Object> cadastros = new ArrayList<Object>();
        try {
            FileInputStream read = new FileInputStream(this.caminho);
            ObjectInputStream stream = new ObjectInputStream(read);
            if (read.available() > 0) {
                cadastros = (ArrayList<Object>) stream.readObject();
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cadastros;
    }
}
