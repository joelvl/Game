/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dll.ConcretCharacter;

/**
 *
 * @author Administrator
 */
public final class TimeController extends Thread implements Runnable {
    
    private double duration, start, fin, quarterHour;
    private int day, hour, minutes, seconds, counter, year;
    private String time, ampm; 
    private boolean isDay;
    private ConcretCharacter character;
    
    public TimeController(ConcretCharacter pCharacter) throws InterruptedException{
        this.character = pCharacter;
        this.ampm = "am";
        this.isDay = true;
        this.day = 1;
        convertTime(3,0,2,0);
        //run();
        
    }
    
    public void convertTime (int pYear, double pHour, double pMinutes, double pSeconds) {        
        this.year = pYear;
        pSeconds = pHour*3600 + pMinutes*60 + pSeconds;
        this.duration = pSeconds / 86400;
        this.quarterHour = duration*900;
    }
    
    public String calculateTime(){
        fin = System.currentTimeMillis();
        seconds = (int)(((fin - start)/(duration))/1000);
        String h, m;
        hour = seconds/3600;
        minutes = (seconds%3600)/60;
        h = hour>9?""+hour:"0"+hour;
        m = minutes>9?""+minutes:"0"+minutes;
        time = h+ " : " + m + " " + ampm;
        return time;
    }
    
    @Override
    public void run(){
        counter = 0;
        start = System.currentTimeMillis();
        while(true){ //se hace cada 15 min; 
            counter++;
            System.out.println(calculateTime()); // imprime la hora actual 
            if (counter%48 == 0){ //Pregutna si ha pasado medio dia
                isDay = !isDay;
                ampm = isDay?"am":"pm";
                day += isDay?1:0;
                start = System.currentTimeMillis();
                counter = 0;
                //System.out.println("Day: " + day); //imprime el dia 
            }
            if (day == year){
                year += 1;
                character.incrementAttribute("edad", 1);
            }
            if (counter%4 == 0){//aqui el 4 deberia ser configurable
                character.changeState();
            }
            //aqui hay que bajarle a los atributos; 
            try {
                Thread.sleep((long)(1000 * quarterHour));
            }catch(InterruptedException e) {}
        }
    }
    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getFin() {
        return fin;
    }

    public void setFin(double fin) {
        this.fin = fin;
    }

    public double getQuarterHour() {
        return quarterHour;
    }

    public void setQuarterHour(double quarterHour) {
        this.quarterHour = quarterHour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public boolean isIsDay() {
        return isDay;
    }

    public void setIsDay(boolean isDay) {
        this.isDay = isDay;
    }
    
    
}
