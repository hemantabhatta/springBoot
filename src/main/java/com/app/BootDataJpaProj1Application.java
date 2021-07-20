package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.app.entity.CoronaVaccine;
import com.app.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class BootDataJpaProj1Application {

	public static void main(String[] args) {
		//get container
		ApplicationContext ctx=SpringApplication.run(BootDataJpaProj1Application.class, args);
		/*//get object
		ICoronaVaccineMgmtService service=ctx.getBean("VaccineService", ICoronaVaccineMgmtService.class);
		try {
			//CoronaVaccine vaccine=new CoronaVaccine("COVISHIELD","BharatBiotech", "india", 980.0, 2);
			CoronaVaccine vaccine=new CoronaVaccine(2L,"COVISHIELD","Bharat", "india", 980.0, 2);
			String msg=service.registerVaccine(vaccine);
			System.out.println(msg);
			System.out.println("saved");
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();*/
	}

}
