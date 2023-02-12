package com.liudmyla.covid.repository;

import com.liudmyla.covid.entity.CountryVaccinations;
import com.liudmyla.covid.entity.VaccinationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VaccinationRepository extends CrudRepository<VaccinationEntity, Long> {

    @Query(nativeQuery = true, value = "Select c.name as CountryName, " +
            "Sum(v.daily_vaccinations) as vacSum From vaccinations v " +
            "Left Join countries c on v.iso_country = c.code " +
            "Group By c.name Order By vacSum Desc " +
            "Limit 10")
    List<CountryVaccinations> fetchTop10HighestVaccinationCountries();

    @Query(nativeQuery = true, value = "Select c.name as CountryName, " +
            "COALESCE(Sum(v.daily_vaccinations), 0) as vacSum From countries c " +
            "Left Join vaccinations v on v.iso_country = c.code " +
            "Group By c.name Order By vacSum  " +
            "Limit 10")
    List<CountryVaccinations> fetchTop10LowestVaccinationCountries();

}