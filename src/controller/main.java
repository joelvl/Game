package controller;

import dll.ConcretCharacter;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class main{

    /**
     * @param args the command line arguments
     */
    
    private static ConcretCharacter character;
            
    public static void main(String[] args) throws InterruptedException {
        
        String path ="src\\Binnacle\\prueba1.txt";
        Log_Creator lc = new Log_Creator();
        lc.addAction("Vegeta vino a pelear");
        lc.addAction("Salió una zanahoria del vívero");
        lc.saveDay("27/11/19",path , false);
        
        DataCharger dc = DataCharger.getInstance();
        System.out.println(dc.loadFile(path));
        
        DiseaseController dc1 = new DiseaseController();
        dc1.chargeDeseases();
        
    }
    
    
    //carga el archivo de configuracion del tiempo
    public static ArrayList<Integer> chargeTime(String path){
        ArrayList<Integer>resp= new ArrayList<>();
        DataCharger dc   = DataCharger.getInstance();
        String data[]    = dc.loadFile(path).split("\n");
        resp.add(Integer.parseInt(data[0]));
        resp.add(Integer.parseInt(data[1]));
        resp.add(Integer.parseInt(data[2]));
        resp.add(Integer.parseInt(data[3]));
        return resp;
    }
}
