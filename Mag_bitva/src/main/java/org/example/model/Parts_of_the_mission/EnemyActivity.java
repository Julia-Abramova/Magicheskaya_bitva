package org.example.model.Parts_of_the_mission;
import java.util.ArrayList;
import java.util.List;
import org.example.model.enums.EscalationRisk;
import org.example.model.enums.Mobility;


public class EnemyActivity {
    private String behaviorType;
    private List<String> targetPriority;
    private List<String> attackPatterns;
    private Mobility mobility;
    private EscalationRisk escalationRisk;

    public EnemyActivity() {
        this.behaviorType = "";
        this.targetPriority = new ArrayList<>();
        this.attackPatterns = new ArrayList<>();
        this.mobility = Mobility.UNKNOWN;
        this.escalationRisk = EscalationRisk.UNKNOWN;
    }

    public EnemyActivity(String behaviorType, List<String> targetPriority,
                         List<String> attackPatterns, Mobility mobility,
                         EscalationRisk escalationRisk) {
        this.behaviorType = behaviorType;
        this.targetPriority = targetPriority;
        this.attackPatterns = attackPatterns;
        this.mobility = mobility;
        this.escalationRisk = escalationRisk;
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public List<String> getTargetPriority() {
        return targetPriority;
    }

    public void setTargetPriority(List<String> targetPriority) {
        this.targetPriority = targetPriority;
    }

    public List<String> getAttackPatterns() {
        return attackPatterns;
    }

    public void setAttackPatterns(List<String> attackPatterns) {
        this.attackPatterns = attackPatterns;
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility(Mobility mobility) {
        this.mobility = mobility;
    }

    public EscalationRisk getEscalationRisk() {
        return escalationRisk;
    }

    public void setEscalationRisk(EscalationRisk escalationRisk) {
        this.escalationRisk = escalationRisk;
    }
}