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
    private int infected;
    private int cured;
    private int critic;
    private int death;
    
    private int infectedPerDay;
    private int deathPerDay;
    
    
    {
        infectedPerDay = 0;
        deathPerDay = 0;
    }

    public Country(String name, int infected, int cured, int critic, int death) {
        this.name = name;
        this.infected = infected;
        this.cured = cured;
        this.critic = critic;
        this.death = death;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getCritic() {
        return critic;
    }

    public void setCritic(int critic) {
        this.critic = critic;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getInfectedPerDay() {
        return infectedPerDay;
    }

    public void setInfectedPerDay(int infectedPerDay) {
        this.infectedPerDay = infectedPerDay;
    }

    public int getDeathPerDay() {
        return deathPerDay;
    }

    public void setDeathPerDay(int deathPerDay) {
        this.deathPerDay = deathPerDay;
    }
    
    
    
}
