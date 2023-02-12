package com.liudmyla.covid.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class VaccinationId implements Serializable {
    private LocalDate recordedDate;
    private String isoCountry;

    public VaccinationId(LocalDate recordedDate, String isoCountry) {
        this.recordedDate = recordedDate;
        this.isoCountry = isoCountry;
    }

}
