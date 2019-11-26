package controller;



public class Log_Creator {
    private String binnacle;
    private final DataCharger dc;

    public Log_Creator() {
        binnacle ="";
        dc       = DataCharger.getInstance();
    }
    
    public void addAction(String action){
        binnacle+=action+"\n";
    }
    
    public void saveDay(String date, String path, Boolean modify){
        
        binnacle ="Fecha: "+date+"\n"+binnacle;
        dc.saveFile(binnacle, path, modify);
        binnacle="";
        
    }
    
}
