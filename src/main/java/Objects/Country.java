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
public class Country {
    
    private String name;
    private String infected;
    private String cured;
    private String critic;
    private String death;    
    private String infectedPerDay;
    private String deathPerDay;

    public Country(String name, String infected, String cured, String critic, String death, String infectedPerDay, String deathPerDay) {
        this.name = name;
        this.infected = infected;
        this.cured = cured;
        this.critic = critic;
        this.death = death;
        this.infectedPerDay = infectedPerDay;
        this.deathPerDay = deathPerDay;
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

    @Override
    public String toString() {
        return "Country{" + "name=" + name + 
                ", infected=" + infected + 
                ", cured=" + cured + 
                ", critic=" + critic + 
                ", death=" + death + 
                ", infectedPerDay=" + infectedPerDay + 
                ", deathPerDay=" + deathPerDay + '}';
    }
    
    
    
}