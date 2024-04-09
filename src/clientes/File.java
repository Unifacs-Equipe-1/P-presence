package clientes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class File {
    private Object pessoa;
    private String caminho;

    public File(Object pessoa, String caminho) {
        this.pessoa = pessoa;
        this.caminho = caminho;
    }

    public void saveOnFile() {

        try {
            FileOutputStream save = new FileOutputStream(this.caminho);
            ObjectOutputStream stream = new ObjectOutputStream(save);
            stream.writeObject(this.pessoa);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao descarregar os dados");
        } finally {
            System.out.println("Objeto salvo com sucesso!");
        }
    }

    public ArrayList<Object> readOnFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Object> cadastros = new ArrayList<Object>();
        try {
            FileInputStream read = new FileInputStream(this.caminho);
            while (read.available() > 0) {
                ObjectInputStream stream = new ObjectInputStream(read);
                cadastros.add(stream.readObject());
                stream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Falha ao encontrar o arquivo");
            throw e;
        } catch (IOException e) {
            System.out.println("Erro ao ler os dados");
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println("Objeto corrompido ou não encontrado");
            throw e;
        }
        return cadastros;

    }
}
