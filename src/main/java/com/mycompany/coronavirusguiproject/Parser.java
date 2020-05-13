/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coronavirusguiproject;

import Objects.Place;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
    private static ArrayList<Place> regions;
    
    public static void downloadAllData(){
        String URL = "https://coronavirus-monitor.info/";
        try {
            html = Jsoup.connect(URL).get();
            //System.out.println(html.title());
            downloadCountriesList();
            showCountries();
            downloadRegionsList();
            showRegions();
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
    
    public static Place getCountry(int index){
        return countries.get(index); 
    }
    
    public static String[] getRegionsNames(){
        String[] names = new String[regions.size()];
        for(int i = 0; i <  regions.size(); i++){
            names[i] = regions.get(i).getName();
        }
        return names;
    }
    
    public static Place getRegion(int index){
        return regions.get(index); 
    }
    
    public static void sortBy(String field){
        switch (field){
            case "name":
                regions.sort(Comparator.comparing(Place::getName));
                countries.sort(Comparator.comparing(Place::getName));
                break;
            case "infected":
              Comparator comp = new Comparator<Place>() {
                    @Override
                    public int compare(Place o1, Place o2) {
                        int n1 = Integer.parseInt(o1.getInfected());
                        int n2 = Integer.parseInt(o2.getInfected());
                        return n2 - n1;
                    }
                };
                regions.sort(comp);
                countries.sort(comp);
                break;
        }
        
    }
    
    public static void downloadCountriesList(){
        Elements objects = html.select("#world_stats .flex-table");
        countries = new ArrayList<>();
        System.out.println(objects.size());
        for(Element object: objects){
            //System.out.println(object.text());
            Place country =  parseCountry(object);
            if (country != null)
                countries.add(country);
        }
    }
    
    public static void downloadRegionsList(){
        Elements objects = html.select("#russia_stats .flex-table");
        regions = new ArrayList<>();
        System.out.println(objects.size());
        for(Element object: objects){
            //System.out.println(object.text());
            Place region = parseRegion(object);
            if (region != null)
                regions.add(region);
        }
    }
    
    private static void showCountries(){
        for(Place country: countries){
            System.out.println(country);
        }
    }
    
    private static void showRegions(){
        for(Place region: regions){
            System.out.println(region);
        }
    }
    
    private static Place parseCountry(Element data){
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
    
    private static Place parseRegion(Element data){
       try{
            String name = data.getElementsByAttribute("data-region").first().text();
            Place ans = new Place(name);
            
            String infected_data = data.getElementsByAttribute("data-confirmed").first().text();
            int index = infected_data.indexOf(" ");
            if (index == -1){
                ans.setInfected(infected_data);
            }else{
                ans.setInfected(infected_data.substring(0, index));
                ans.setInfectedPerDay(infected_data.substring(index + 2));
            }
            
            String cured_data = data.getElementsByAttribute("data-cured").first().text();
            index = infected_data.indexOf(" ");
            if (index == -1){
                ans.setCured(cured_data);
            }else{
                ans.setCured(cured_data.substring(0, index));
                ans.setCuredPerDay(cured_data.substring(index + 2));
            }
            
            Elements deaths = data.getElementsByAttribute("data-deaths");
            String death_data = deaths.first().text();
            index = death_data.indexOf(" ");
            if (index == -1){
                ans.setDeath(death_data);
            }else{
                ans.setDeath(death_data.substring(0, index));
                ans.setDeathPerDay(death_data.substring(index+2));
            }
            String percent = deaths.last().text();
            ans.setDeathPercent(percent);
            return ans;
       }catch(Exception e){}
        return null;
    }
    
}
