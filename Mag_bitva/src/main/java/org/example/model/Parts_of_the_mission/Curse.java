package org.example.model.Parts_of_the_mission;

import org.example.model.enums.ThreatLevel;

public class Curse {
    public String name;
    public ThreatLevel threatLevel;

    public Curse() {}
    
    public Curse(String name, ThreatLevel threatLevel) {
        this.name = name;
        this.threatLevel = threatLevel;
    }

    public String getName() {
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public ThreatLevel getThreatLevel() { 
        return threatLevel; 
    }
    public void setThreatLevel(ThreatLevel threatLevel) {
        this.threatLevel = threatLevel; 
    }
}