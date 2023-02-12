package com.liudmyla.covid.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(VaccinationId.class)
@Table(name ="vaccinations")
public class VaccinationEntity {

    @Column(name = "recorded_date")
    @Id
    private LocalDate recordedDate;

    @Column(name = "daily_vaccinations_raw")
    private int dailyVaccinationsRaw;

    @Column(name = "daily_vaccinations")
    private int dailyVaccinations;

    @Column(name = "iso_country")
    @Id
    private String isoCountry;

    public LocalDate getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(LocalDate recordedDate) {
        this.recordedDate = recordedDate;
    }

    public int getDailyVaccinationsRaw() {
        return dailyVaccinationsRaw;
    }

    public void setDailyVaccinationsRaw(int dailyVaccinationsRaw) {
        this.dailyVaccinationsRaw = dailyVaccinationsRaw;
    }

    public int getDailyVaccinations() {
        return dailyVaccinations;
    }

    public void setDailyVaccinations(int dailyVaccinations) {
        this.dailyVaccinations = dailyVaccinations;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    @Override
    public String toString() {
        return "VaccinationEntity{" +
                "recordedDate=" + recordedDate +
                ", dailyVaccinationsRaw=" + dailyVaccinationsRaw +
                ", dailyVaccinations=" + dailyVaccinations +
                ", isoCountry='" + isoCountry + '\'' +
                '}';
    }
}
