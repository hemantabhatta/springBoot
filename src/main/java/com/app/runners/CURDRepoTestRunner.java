package com.app.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.app.entity.CoronaVaccine;
import com.app.service.ICoronaVaccineMgmtService;

@Component
public class CURDRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Iterable<CoronaVaccine> listvacines=service.registerInBatch(List.of(new CoronaVaccine("sputnik", "Russie","Russia",567.8, 2),
			        new CoronaVaccine("pyzer", "pyzer","USA",678.8, 2),
			        new CoronaVaccine("moderena", "moderena","USA",455.8, 2)));
			Iterable<CoronaVaccine> listvacines=service.registerInBatch(Arrays.asList(new CoronaVaccine("sputnik", "Russie","Russia",567.8, 2),
		            new CoronaVaccine("pyzer", "pyzer","USA",678.8, 2),
		            new CoronaVaccine("moderena", "moderena","USA",455.8, 2)));
			System.out.println("Reg no.s are");
			listvacines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		}*/
		try {
			Iterable<CoronaVaccine> listvacines=service.registerInBatch(Arrays.asList(new CoronaVaccine("sputnik", "Russie","Russia",567.8, 2),
		            new CoronaVaccine("pyzer", "pyzer","USA",678.8, 2),
		            new CoronaVaccine("moderena", "moderena","USA",455.8, 2)));
			System.out.println("Reg no.s are");
			listvacines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
			System.out.println("Records Count:: " + service.getVaccineCount());
			System.out.println("Regno 10, vaccines availability?:: " + service.checkVaccineAvailability(10));
			System.out.println("==============findById============");
			
			/*Optional<CoronaVaccine> opt=service.details(15);
			if(opt.isPresent()) 
				System.out.println("record no "+opt.get().getRegNo()+" "+opt.get());
			else
				System.out.println(" Record not found");*/
			
			/*Optional<CoronaVaccine> opt=service.details(15);
			if(opt.isPresent()) 
				System.out.println("record no "+opt.get().getRegNo()+" "+opt.get());
				opt.orElseThrow(()->new IllegalArgumentException("record not found"));	*/
			
			
			/* CoronaVaccine vaccine=service.details(5L).orElseThrow(()->new IllegalArgumentException("not available"));
			    System.out.println(vaccine);*/
			   
			/* CoronaVaccine vaccine1=service.details(12L).orElse(new CoronaVaccine());
			  System.out.println(vaccine1);*/
					  
					   
			CoronaVaccine vaccine3=service.details(12L).orElseGet(()-> new CoronaVaccine());
			System.out.println(vaccine3);
			
			//System.out.println("details about vaccines:: " + service.details(5).get());

			System.out.println("=============Details All db entries:: FInd All============");
			/*Iterable<CoronaVaccine> listAll=service.detailsAll();
			listAll.forEach(Vaccine->System.out.println(Vaccine));//for each with lambda
			*/

			/*System.out.println("--------------");
			service.detailsAll().forEach(vaccine->System.out.println(vaccine));//improved foreach with lambda
			*/

			/*System.out.println("-----------------");
			service.detailsAll().forEach(System.out::println);//for each method with method reference
			*/							
			
			/*System.out.println("-----------------");
			Arrays.asList(service.detailsAll()).stream().map(vaccine->vaccine).forEach(System.out::println);//using stream api
			*/	
			
			List<CoronaVaccine> listAll=(List<CoronaVaccine>) service.detailsAll();
			System.out.println(listAll);
			//how to display as sorting order
			List<CoronaVaccine> sort=listAll.stream().sorted((v1,v2)->v1.getCountry().compareToIgnoreCase(v2.getCountry())
				/*	
					double price=(double)v2.getPrice()-(double)v1.getPrice();
					if(price<0.0d)
						return 1;
					else
						return -1;*/
			).filter(v->v.getPrice()< 600).collect(Collectors.toList());
			listAll.forEach(System.out::println);
			System.out.println("+++++++++++");
			sort.forEach(System.out::println);
			/*System.out.println("-----------------");
			Arrays.asList(service.detailsAll()).stream().forEach(System.out::println);//using stream api
			*/
			System.out.println("Details All bY regNos::findAllById()");
			
			/*Iterable<CoronaVaccine> detilsAllByID = service.detailsAllById(List.of(5L, 6L,7L));
			detilsAllByID.forEach(vaccine -> System.out.println(vaccine));//for each with lamda
*/			
			
/*			service.detailsAllById(List.of(5L,6L,7L)).forEach(vaccine->System.out.println(vaccine));//improved foreach with lambda*/
			
			service.detailsAllById(List.of(5L,6L,7L)).forEach(System.out::println);//foreach with method reference
				
			
			
			System.out.println("-----------------");
			/*Arrays.asList(service.detailsAll()).stream().map(vaccine->vaccine).forEach(System.out::println);//using stream api
			*/	
			
			System.out.println("=========save method========");
			//create entity class obj
			/*CoronaVaccine vaccine=new CoronaVaccine("jhonson & jhonson", "jhonson", "USA", 700.85, 1);
			//call b.method
			System.out.println(service.registerVaccine(vaccine));*/
			
			
			/*System.out.println("delete by id?:: "+service.deleteByID(11));*/

			System.out.println("===============deleteById========");
			/*System.out.println(service.removeVaccineById(23L));*/
			System.out.println("=============deleteByObject========");
			/*	CoronaVaccine vaccine=new CoronaVaccine();
				vaccine.setRegNo(4L);
				System.out.println(service.removeVaccineByObject(vaccine));*/
			System.out.println("======removevaccinesByIds=======");
			/*System.out.println(service.removeVaccinesByIds(List.of(5L,6L)));*/
			
			System.out.println("===remove vaccines by Entites=======");
			CoronaVaccine vaccine1=new CoronaVaccine();
			vaccine1.setRegNo(4L);
			CoronaVaccine vaccine2=new CoronaVaccine();
			vaccine2.setRegNo(5L);
			Iterable<CoronaVaccine> vaccines=new ArrayList<CoronaVaccine>();
			((List<CoronaVaccine>) vaccines).add(vaccine1);
			((List<CoronaVaccine>) vaccines).add(vaccine2);
			
			System.out.println(service.removVaccineByObjects(vaccines));
			
			System.out.println("=========deleteAll()==========");
			/*System.out.println(service.removeAllVaccines());*/
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
