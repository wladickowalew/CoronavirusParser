/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author ROOT
 */
public class Place {
    private final String DEFAULT_ANWER = "Нет данных";
    private String name;
    private String infected;
    private String infectedPerDay;
    private String cured;
    private String curedPerDay; 
    private String critic;
    private String death;    
    private String deathPerDay;
    private String deathPercent;
    
    {
        infected = DEFAULT_ANWER;
        infectedPerDay = DEFAULT_ANWER;
        cured = DEFAULT_ANWER;
        curedPerDay = DEFAULT_ANWER; 
        critic = DEFAULT_ANWER;
        death = DEFAULT_ANWER;    
        deathPerDay = DEFAULT_ANWER;
        deathPercent = DEFAULT_ANWER;
    }

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfected() {
        return infected;
    }

    public void setInfected(String infected) {
        this.infected = infected;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getCritic() {
        return critic;
    }

    public void setCritic(String critic) {
        this.critic = critic;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getInfectedPerDay() {
        return infectedPerDay;
    }

    public void setInfectedPerDay(String infectedPerDay) {
        this.infectedPerDay = infectedPerDay;
    }

    public String getDeathPerDay() {
        return deathPerDay;
    }

    public void setDeathPerDay(String deathPerDay) {
        this.deathPerDay = deathPerDay;
    }

    public String getCuredPerDay() {
        return curedPerDay;
    }

    public void setCuredPerDay(String curedPerDay) {
        this.curedPerDay = curedPerDay;
    }

    public String getDeathPercent() {
        return deathPercent;
    }

    public void setDeathPercent(String deathPercent) {
        this.deathPercent = deathPercent;
    }

    @Override
    public String toString() {
        return "Place{name=" + name + ", infected=" + infected + ", infectedPerDay=" + infectedPerDay + ", cured=" + cured + ", curedPerDay=" + curedPerDay + ", critic=" + critic + ", death=" + death + ", deathPerDay=" + deathPerDay + ", deathPercent=" + deathPercent + '}';
    }
   
}