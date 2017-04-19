package pk.edu.nust.seecs.gradebook.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pk.edu.nust.seecs.gradebook.business.businessObject;
import pk.edu.nust.seecs.gradebook.entity.Clo;

public class testCloInsert {

	@Test
	public void test() {
        businessObject myBo = new businessObject();
    	
        Resource r = new ClassPathResource("applicationContext.xml");

        BeanFactory factory = new XmlBeanFactory(r);

        Clo clo = (Clo) factory.getBean("clo");
        
        assertTrue("Not added", myBo.addCLO(clo));
	}

}
