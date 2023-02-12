package com.liudmyla.covid.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(CaseId.class)
@Table(name ="cases")
public class CaseEntity {

    @Column(name = "recorded_date")
    @Id
    private LocalDate recordedDate;

    @Column(name = "infections")
    private int infections;

    @Column(name = "deaths")
    private int deaths;

    @Column(name = "iso_country")
    @Id
    private String isoCountry;

    public LocalDate getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(LocalDate recordedDate) {
        this.recordedDate = recordedDate;
    }

    public int getInfections() {
        return infections;
    }

    public void setInfections(int infections) {
        this.infections = infections;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    @Override
    public String toString() {
        return "CaseEntity{" +
                ", recordedDate=" + recordedDate +
                ", infections=" + infections +
                ", deaths=" + deaths +
                ", isoCountry='" + isoCountry + '\'' +
                '}';
    }
}
