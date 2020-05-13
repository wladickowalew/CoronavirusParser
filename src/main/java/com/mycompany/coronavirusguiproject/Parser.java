/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coronavirusguiproject;

import Objects.Place;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ROOT
 */
public class Parser {
    
    private static Document html;
    private static ArrayList<Place> countries; 
    
    public static void downloadAllData(){
        String URL = "https://coronavirus-monitor.info/";
        try {
            html = Jsoup.connect(URL).get();
            //System.out.println(html.title());
            downloadCountriesList();
            showCountries();
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getLabelText(){
        Elements objects = html.select("div.col-xs-12.col-sm-12.col-md-9.col-lg-9 h2");
        Element obj = objects.first();
        return obj.text();
    }
    
    public static String[] getCountriesNames(){
        String[] names = new String[countries.size()];
        for(int i = 0; i < countries.size(); i++){
            names[i] = countries.get(i).getName();
        }
        return names;
    }
    
    public static Place getPlace(int index){
        return countries.get(index); 
    }
    
    public static void downloadCountriesList(){
        Elements objects = html.select("#world_stats .flex-table");
        countries = new ArrayList<>();
        System.out.println(objects.size());
        for(Element object: objects){
            //System.out.println(object.text());
            Place country =  parsePlace(object);
            if (country != null)
                countries.add(country);
        }
    }
    
    private static void showCountries(){
        for(Place country: countries){
            System.err.println(country);
        }
    }
    
    private static Place parsePlace(Element data){
       try{
            String name = data.getElementsByAttribute("data-country").first().text();
            Place ans = new Place(name);
            String cured = data.getElementsByAttribute("data-cured").first().text();
            ans.setCured(cured);
            String critic = data.getElementsByAttribute("data-critical").first().text();
            ans.setCritic(critic);
            
            String infected_data = data.getElementsByAttribute("data-confirmed").first().text();
            int index = infected_data.indexOf(" ");
            if (index == -1){
                ans.setInfected(infected_data);
            }else{
                ans.setInfected(infected_data.substring(0, index));
                ans.setInfectedPerDay(infected_data.substring(index + 2));
            }
            
            String death_data = data.getElementsByAttribute("data-deaths").first().text();
            index = death_data.indexOf(" ");
            if (index == -1){
                ans.setDeath(death_data);
            }else{
                ans.setDeath(death_data.substring(0, index));
                ans.setDeathPerDay(death_data.substring(index+2));

            }
            return ans;
            
           
           //System.out.println(name+" "+infected+" "+cured+" "+critic+" "+death);
       }catch(Exception e){}
        return null;
    }
    
}
