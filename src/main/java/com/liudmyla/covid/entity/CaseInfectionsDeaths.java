package com.liudmyla.covid.entity;

import java.math.BigInteger;

public interface CaseInfectionsDeaths {

    String getCountryName();
    BigInteger getInfections();
    BigInteger getDeaths();
}
