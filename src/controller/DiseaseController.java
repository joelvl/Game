package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class DiseaseController {
    
    private final String pathConfig="src\\Binnacle\\diseaseConfig.txt";
    //private ArrayList<Disease> diseaseList;

    public DiseaseController() {
    }
   
    
    public void chargeDeseases(){
        DataCharger dc   = DataCharger.getInstance();
        String      data = dc.loadFile(pathConfig);
        System.out.println(data);
        String diseases[] = data.split("\n");
        
        for(int i=0; i<diseases.length;i+=4){
            getDisease(diseases[i],diseases[i+1],diseases[i+2],diseases[i+3]);
        }
    }

    private String getDisease(String name, String affect, String need, String cure) {
        HashMap<String, Integer> affectList = readAt(affect);
        HashMap<String, Integer> needList = readAt(need);
        ArrayList<String> cureList = new ArrayList<>();
        String cures[] = cure.split(",");
        for(String item: cures){
            cureList.add(item);
        }
        // Disease disease = new Disease(name,affectList,needList,cureList);
        return null;
    }
    
    private HashMap<String, Integer> readAt(String read){
        HashMap<String, Integer> resp = new HashMap<>();
        String list[] = read.split(",");
        for(String data: list){
            String items[] = data.split("_");
            resp.put(items[0],Integer.parseInt(items[1]));
        }
        return resp;
    }
}
