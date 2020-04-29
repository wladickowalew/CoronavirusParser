/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coronavirusguiproject;

import Objects.Country;
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
    private static ArrayList<Country> countries; 
    
    public static void downloadAllData(){
        String URL = "https://coronavirus-monitor.info/";
        try {
            html = Jsoup.connect(URL).get();
            System.out.println(html.title());
            downloadCountriesList();
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getLabelText(){
        Elements objects = html.select("div.col-xs-12.col-sm-12.col-md-9.col-lg-9 h2");
        Element obj = objects.first();
        return obj.text();
    }
    
    public static void downloadCountriesList(){
        Elements objects = html.select("#world_stats .flex-table");
        countries = new ArrayList<>();
        System.out.println(objects.size());
        for(Element object: objects){
            System.out.println(object.text());
        }
    }
    
}
