package com.codegym.module4thi.repository;

import com.codegym.module4thi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
}
