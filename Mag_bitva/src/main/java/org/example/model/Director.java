package org.example.model;


public class Director {
    private MissionBuilder missionBuilder;
    
    public void setMissionBuilder(MissionBuilder mb) {missionBuilder = mb; }
    public Mission getMission() {return missionBuilder.getMission(); }
    
    public void constructMission() {
        
    }
}
