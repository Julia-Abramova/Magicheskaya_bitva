package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.example.model.Parts_of_the_mission.*;
import org.example.model.enums.Outcome;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "mission")
public class Mission {

    private String missionId;
    private LocalDate date;
    private String location;
    private Outcome outcome;
    private Long damageCost = null;
    private String note = "";

    @JacksonXmlElementWrapper(localName = "sorcerers")
    @JacksonXmlProperty(localName = "sorcerer")
    private final List<Sorcerer> sorcerers = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "techniques")
    @JacksonXmlProperty(localName = "technique")
    private final List<Technique> techniques = new ArrayList<>();

    private Curse curse;

    private EconomicAssessment economicAssessment;
    private CivilianImpact civilianImpact;
    private EnemyActivity enemyActivity;
    private EnvironmentConditions environmentConditions;

    @JacksonXmlElementWrapper(localName = "operationTimeline")
    @JacksonXmlProperty(localName = "timeline")
    private final List<OperationTimeline> operationTimeline = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "operationTags")
    @JacksonXmlProperty(localName = "tag")
    private final List<String> operationTags = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "supportUnits")
    @JacksonXmlProperty(localName = "unit")
    private final List<String> supportUnits = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "recommendations")
    @JacksonXmlProperty(localName = "recommendation")
    private final List<String> recommendations = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "artifactsRecovered")
    @JacksonXmlProperty(localName = "artifact")
    private final List<String> artifactsRecovered = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "evacuationZones")
    @JacksonXmlProperty(localName = "zone")
    private final List<String> evacuationZones = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "statusEffects")
    @JacksonXmlProperty(localName = "effect")
    private final List<String> statusEffects = new ArrayList<>();

    public Mission() {
    }

    public String getMissionId() { return missionId; }
    public LocalDate getDate() { return date; }
    public String getLocation() { return location; }
    public Outcome getOutcome() { return outcome; }
    public Long getDamageCost() { return damageCost; }
    public String getNote() { return note; }
    public Curse getCurse() { return curse; }
    public EconomicAssessment getEconomicAssessment() { return economicAssessment; }
    public CivilianImpact getCivilianImpact() { return civilianImpact; }
    public EnemyActivity getEnemyActivity() { return enemyActivity; }
    public EnvironmentConditions getEnvironmentConditions() { return environmentConditions; }
    public List<OperationTimeline> getOperationTimeline() { return new ArrayList<>(operationTimeline); }
    public List<Sorcerer> getSorcerers() { return new ArrayList<>(sorcerers); }
    public List<Technique> getTechniques() { return new ArrayList<>(techniques); }
    public List<String> getOperationTags() { return new ArrayList<>(operationTags); }
    public List<String> getSupportUnits() { return new ArrayList<>(supportUnits); }
    public List<String> getRecommendations() { return new ArrayList<>(recommendations); }
    public List<String> getArtifactsRecovered() { return new ArrayList<>(artifactsRecovered); }
    public List<String> getEvacuationZones() { return new ArrayList<>(evacuationZones); }
    public List<String> getStatusEffects() { return new ArrayList<>(statusEffects); }

    public void setMissionId(String missionId) { this.missionId = missionId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setOutcome(Outcome outcome) { this.outcome = outcome; }
    public void setDamageCost(long damageCost) { this.damageCost = damageCost; }
    public void setNote(String note) { this.note = note; }

    public void setCurse(Curse curse) { this.curse = curse; }
    public void setEconomicAssessment(EconomicAssessment ea) { this.economicAssessment = ea; }
    public void setCivilianImpact(CivilianImpact ci) { this.civilianImpact = ci; }
    public void setEnemyActivity(EnemyActivity ea) { this.enemyActivity = ea; }
    public void setEnvironmentConditions(EnvironmentConditions ec) { this.environmentConditions = ec; }

    public void addSorcerer(Sorcerer s) { if (s != null) this.sorcerers.add(s); }
    public void addTechnique(Technique t) { if (t != null) this.techniques.add(t); }
    public void addOperationTimeline(OperationTimeline t) { if (t != null) this.operationTimeline.add(t); }

    public void addOperationTag(String tag) { if (tag != null) this.operationTags.add(tag); }
    public void addSupportUnit(String unit) { if (unit != null) this.supportUnits.add(unit); }
    public void addRecommendation(String rec) { if (rec != null) this.recommendations.add(rec); }
    public void addArtifactRecovered(String artifact) { if (artifact != null) this.artifactsRecovered.add(artifact); }
    public void addEvacuationZone(String zone) { if (zone != null) this.evacuationZones.add(zone); }
    public void addStatusEffect(String effect) { if (effect != null) this.statusEffects.add(effect); }
}