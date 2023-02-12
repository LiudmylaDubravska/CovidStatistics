package com.liudmyla.covid.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class CaseId implements Serializable {
    private LocalDate recordedDate;
    private String isoCountry;

    public CaseId(LocalDate recordedDate, String isoCountry) {
        this.recordedDate = recordedDate;
        this.isoCountry = isoCountry;
    }
}
