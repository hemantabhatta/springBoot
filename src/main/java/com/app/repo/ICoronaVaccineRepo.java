package com.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
