package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.entity.CoronaVaccine;
import com.app.repo.ICoronaVaccineRepo;
@Service("VaccineService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) throws Exception {
		CoronaVaccine savedvaccine=null;

		if(vaccine!=null) {
			//use repo
			savedvaccine=coronaRepo.save(vaccine);
		}
		return savedvaccine!=null? "vaccine registered/update sucessfully with id "+savedvaccine.getRegNo():
			"vaccine registered/update failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) throws Exception {
		if(vaccines!=null) {
			return coronaRepo.saveAll(vaccines);
		}
		else {
			throw new IllegalArgumentException("batch insertion order not done");
		}

	}

	@Override
	public long getVaccineCount() throws Exception {
		// TODO Auto-generated method stub
		return coronaRepo.count();
	}

	@Override
	public boolean checkVaccineAvailability(long regno) throws Exception {
		// TODO Auto-generated method stub
		return coronaRepo.existsById(regno);
	}

	@Override
	public Optional<CoronaVaccine> details(long regno) throws Exception {
		// TODO Auto-generated method stub
		return coronaRepo.findById(regno);
	}

	@Override
	public Iterable<CoronaVaccine> detailsAll() throws Exception {
		// TODO Auto-generated method stub
		return coronaRepo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> detailsAllById(Iterable<Long> regNos) throws Exception {
		// TODO Auto-generated method stub
		return coronaRepo.findAllById(regNos);
	}

	@Override
	public boolean deleteByID(long regNo) throws Exception {
		boolean b;
		try {
			b=true;
			coronaRepo.deleteById(regNo);
		} catch (Exception e) {
			b=false;
		}
	
		
		return b;
	}

	@Override
	public String removeVaccineById(long regNo) throws Exception {
		Optional<CoronaVaccine> opt=coronaRepo.findById(regNo);
		if(opt.isPresent()) {
			coronaRepo.deleteById(regNo);
			return "record deleted having id "+regNo;
		}	
		else
			return "record not found deletion";
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) throws Exception {
		Optional<CoronaVaccine> opt=coronaRepo.findById(vaccine.getRegNo());
		if (opt.isPresent()) {
			coronaRepo.delete(vaccine);
			return "Record deleted having id "+vaccine.getRegNo();
		}else {
			return "no records are deleted";
		}
		
	}

	@Override
	public String removeVaccinesByIds(Iterable<Long> ids) throws Exception {
		Iterable<CoronaVaccine> listEntities=coronaRepo.findAllById(ids);
		int count=((List)ids).size();
		if(((List)listEntities).size()==count) {
			coronaRepo.deleteAllById(ids);
			return count+" no. of record deleted";
		}else {
			return "problem in deleting records"; 
		}
		
	}

	@Override
	public String removVaccineByObjects(Iterable<CoronaVaccine> vaccines) {
			
		try {
			StringBuilder builder=new StringBuilder(" ");
			coronaRepo.deleteAll(vaccines);
			builder.append("given vaccines deleted +");
			int count=builder.length()-1;
			vaccines.forEach(v1->builder.append(v1.getRegNo()+" ,"));
			builder.deleteCharAt(builder.length()-1);
			
			return builder.toString();
		} catch (Exception e) {
			StringBuilder builder=new StringBuilder(" ");
		 new IllegalArgumentException("given vaccines are not found");
		 return e.getMessage();
			
		}
		
	}

	@Override
	public String removeAllVaccines() throws Exception {
		long count=coronaRepo.count();
		if(count!=0) {
			coronaRepo.deleteAll();
			return count+" no. of records are deleted";
		}else
			return "table is empty no records are available";
		
	}
}
