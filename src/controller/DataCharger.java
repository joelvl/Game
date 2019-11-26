package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DataCharger {
    private static DataCharger charger;

    private DataCharger() {
    }
    
    public static DataCharger getInstance(){
        if(charger==null)charger= new DataCharger();
        return charger;
    }
    
    public void saveFile(String text, String path, Boolean modify){
        try {
            File file = new File(path);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,modify);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public String loadFile(String path) {
        try{
            File file = openFile(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String text = "";
            while ((line = bufferedReader.readLine()) != null){
                text += line;
                text += "\n";
            }
            text = text.replace("\n\n", "\n");
            return text;
        }catch(Exception e){
            System.out.println("Error al abrir el archivo TXT");
            return null;
        }
    }
    
    protected File openFile(String path){
        File file = null;
        try{
            file = new File(path);
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }
        return file;
    } 
}
