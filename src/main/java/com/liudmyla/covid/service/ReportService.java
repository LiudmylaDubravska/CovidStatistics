package com.liudmyla.covid.service;

import com.liudmyla.covid.controller.model.ReportResponse;
import com.liudmyla.covid.entity.CaseInfectionsDeaths;
import com.liudmyla.covid.entity.CountryInfections;
import com.liudmyla.covid.entity.CountryVaccinations;
import com.liudmyla.covid.repository.CasesRepository;
import com.liudmyla.covid.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private CasesRepository casesRepository;

    @Transactional
    public ReportResponse fetchReport() {
        ReportResponse result = new ReportResponse();
        List<CountryVaccinations> top10HighestVaccinations = vaccinationRepository.fetchTop10HighestVaccinationCountries();
        List<CountryVaccinations> top10LowestVaccinationCountries = vaccinationRepository.fetchTop10LowestVaccinationCountries();
        List<CountryInfections> top10HighestInfectionRate = casesRepository.fetchTop10InfectionRate();
        result.setHighestVaccination(top10HighestVaccinations);
        result.setLowestVaccination(top10LowestVaccinationCountries);
        result.setHighestInfectionsRate(top10HighestInfectionRate);
        return result;
    }

    @Transactional
    public List<CaseInfectionsDeaths> fetchDailyInfectionsDeathsUpUntil(String country, LocalDate localDate) {
        return casesRepository.fetchDailyInfectionsDeathsUpUntil(country, localDate);
    }
}