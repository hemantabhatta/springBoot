package com.app.service;

import java.util.Iterator;
import java.util.Optional;

import com.app.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public String registerVaccine(CoronaVaccine vaccine) throws Exception;
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) throws Exception;
	public long getVaccineCount() throws Exception;
	public boolean checkVaccineAvailability(long regno) throws Exception;
	
	public Optional<CoronaVaccine> details(long regno) throws Exception;
	public Iterable<CoronaVaccine> detailsAll() throws Exception;
	public Iterable<CoronaVaccine> detailsAllById(Iterable<Long> regNos) throws Exception;
	public boolean deleteByID(long regNo) throws Exception;
	
	public String removeVaccineById(long regNo) throws Exception;
	public String removeVaccineByObject(CoronaVaccine vaccine) throws Exception;
	public String removeVaccinesByIds(Iterable<Long> ids) throws Exception;
	
	public String removVaccineByObjects(Iterable<CoronaVaccine> vaccines) ;
	public String removeAllVaccines()throws Exception;
	
	
	
}
