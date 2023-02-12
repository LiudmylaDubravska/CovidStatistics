package com.liudmyla.covid.repository;

import com.liudmyla.covid.entity.CaseEntity;
import com.liudmyla.covid.entity.CaseInfectionsDeaths;
import com.liudmyla.covid.entity.CountryInfections;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CasesRepository extends CrudRepository<CaseEntity, Long> {

    @Query(nativeQuery = true, value = "Select c.name as CountryName, " +
            "(100000.0 * Sum(cases.infections))/c.population as infectionsRate From cases " +
            "Left Join countries c on cases.iso_country = c.code "+
            "Group By c.name, c.population Order By infectionsRate Desc " +
            "Limit 10")
    List<CountryInfections> fetchTop10InfectionRate();

    @Query(nativeQuery = true, value = "Select c.name as countryName, " +
            "Sum(cases.infections) as infections, " +
            "Sum(cases.deaths) as deaths From cases " +
            "Left Join countries c on cases.iso_country = c.code "+
            "where cases.recorded_date <= :localDate and c.name LIKE :country% " +
            "Group By c.name"
    )
    List<CaseInfectionsDeaths> fetchDailyInfectionsDeathsUpUntil(String country, LocalDate localDate);
}