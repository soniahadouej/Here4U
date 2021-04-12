package tn.g3.spring.service.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import tn.g3.spring.entity.Contract;
//import tn.g3.spring.entity.ContractPaymentType;
//import tn.g3.spring.entity.ContractStatus;
//import tn.g3.spring.entity.ProductType;
import tn.g3.spring.service.IContractService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SinistreServiceImplTest {
	@Autowired
	IContractService us;

	/*@Test
	public void contextLoads1() {
	us.retrieveAllContracts();
	}

	@Test
	public void contextLoads() throws ParseException {

	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 Date d = dateFormat.parse("2015-03-23");
	 Date d1 = dateFormat.parse("2020-03-23");
	 Contract c = new Contract(ProductType.AUTO,"aaaaa",d , d1,ContractStatus.AAAAA,ContractPaymentType.CARTEBANCAIRE,505.5f);

			 us.addContract(c);
	 
	}*/
}
