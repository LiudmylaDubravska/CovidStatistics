package com.liudmyla.covid.controller.model;

import com.liudmyla.covid.entity.CountryInfections;
import com.liudmyla.covid.entity.CountryVaccinations;

import java.util.List;

public class ReportResponse {
    List<CountryVaccinations> highestVaccination;
    List<CountryVaccinations> lowestVaccination;
    List<CountryInfections> highestInfectionsRate;

    public ReportResponse() {
    }

    public List<CountryVaccinations> getHighestVaccination() {
        return highestVaccination;
    }

    public List<CountryVaccinations> getLowestVaccination() {
        return lowestVaccination;
    }

    public void setHighestVaccination(List<CountryVaccinations> highestVaccination) {
        this.highestVaccination = highestVaccination;
    }

    public void setLowestVaccination(List<CountryVaccinations> lowestVaccination) {
        this.lowestVaccination = lowestVaccination;
    }

    public List<CountryInfections> getHighestInfectionsRate() {
        return highestInfectionsRate;
    }

    public void setHighestInfectionsRate(List<CountryInfections> highestInfectionsRate) {
        this.highestInfectionsRate = highestInfectionsRate;
    }

}
