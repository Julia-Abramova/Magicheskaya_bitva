package org.example.model.Parts_of_the_mission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.example.model.enums.EscalationRisk;
import org.example.model.enums.Mobility;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnemyActivity {

    private String behaviorType;
    
    @JacksonXmlElementWrapper(localName = "targetPriority")
    @JacksonXmlProperty(localName = "priority")
    private List<String> targetPriority = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "attackPatterns")
    @JacksonXmlProperty(localName = "pattern")
    private List<String> attackPatterns = new ArrayList<>();

    private Mobility mobility;
    private EscalationRisk escalationRisk;

    @JacksonXmlElementWrapper(localName = "countermeasuresUsed")
    @JacksonXmlProperty(localName = "measure")
    private List<String> countermeasuresUsed = new ArrayList<>();

    public EnemyActivity() {
        this.behaviorType = "";
        this.targetPriority = new ArrayList<>();
        this.attackPatterns = new ArrayList<>();
        this.countermeasuresUsed = new ArrayList<>();
        this.mobility = Mobility.UNKNOWN;
        this.escalationRisk = EscalationRisk.UNKNOWN;
    }

    // Геттеры и сеттеры
    public String getBehaviorType() { return behaviorType; }
    public void setBehaviorType(String behaviorType) { this.behaviorType = behaviorType; }

    public List<String> getTargetPriority() { return targetPriority; }
    public void setTargetPriority(List<String> targetPriority) { this.targetPriority = targetPriority; }

    public List<String> getAttackPatterns() { return attackPatterns; }
    public void setAttackPatterns(List<String> attackPatterns) { this.attackPatterns = attackPatterns; }

    public Mobility getMobility() { return mobility; }
    public void setMobility(Mobility mobility) { this.mobility = mobility; }

    public EscalationRisk getEscalationRisk() { return escalationRisk; }
    public void setEscalationRisk(EscalationRisk escalationRisk) { this.escalationRisk = escalationRisk; }

    public List<String> getCountermeasuresUsed() { return countermeasuresUsed; }
    public void setCountermeasuresUsed(List<String> countermeasuresUsed) { this.countermeasuresUsed = countermeasuresUsed; }
}