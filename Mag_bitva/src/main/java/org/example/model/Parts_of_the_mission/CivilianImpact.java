package org.example.model.Parts_of_the_mission;

import org.example.model.enums.PublicExposureRisk;

public class CivilianImpact {
    private Integer evacuated;
    private Integer injured;
    private Integer missing;
    private PublicExposureRisk publicExposureRisk;

    public CivilianImpact() {
        this.evacuated = 0;
        this.injured = 0;
        this.missing = 0;
        this.publicExposureRisk = PublicExposureRisk.UNKNOWN;
    }

    public CivilianImpact(Integer evacuated, Integer injured, Integer missing,
                          PublicExposureRisk publicExposureRisk) {
        this.evacuated = evacuated;
        this.injured = injured;
        this.missing = missing;
        this.publicExposureRisk = publicExposureRisk;
    }

    public Integer getEvacuated() {
        return evacuated;
    }

    public void setEvacuated(Integer evacuated) {
        this.evacuated = evacuated;
    }

    public Integer getInjured() {
        return injured;
    }

    public void setInjured(Integer injured) {
        this.injured = injured;
    }

    public Integer getMissing() {
        return missing;
    }

    public void setMissing(Integer missing) {
        this.missing = missing;
    }

    public PublicExposureRisk getPublicExposureRisk() {
        return publicExposureRisk;
    }

    public void setPublicExposureRisk(PublicExposureRisk publicExposureRisk) {
        this.publicExposureRisk = publicExposureRisk;
    }
}
