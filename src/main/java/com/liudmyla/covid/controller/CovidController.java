package com.liudmyla.covid.controller;

import com.liudmyla.covid.controller.model.ReportResponse;
import com.liudmyla.covid.entity.CaseInfectionsDeaths;
import com.liudmyla.covid.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/Query")
    public List<CaseInfectionsDeaths> query(String countryName, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return reportService.fetchDailyInfectionsDeathsUpUntil(countryName, localDate);
    }

    @GetMapping("/Reports")
    public ReportResponse reports() {
        return reportService.fetchReport();
    }

}
