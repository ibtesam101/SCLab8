package pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.*;

import pk.edu.nust.seecs.gradebook.business.*;


/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) {
        /*CloDao clodao = new CloDao();

        // Add new clo
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("Design efficient solutions for algorithmic problems");
        clo.setPlo("2");
        clodao.addClo(clo);

        clodao.updateClo(clo);

        // Delete an existing clo
        //dao.deleteClo(1);

        // Get all clos
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }

        // Get clo by id
        System.out.println(clodao.getCloById(1));
*/
    	
        Resource r = new ClassPathResource("applicationContext.xml");

        BeanFactory factory = new XmlBeanFactory(r);
        
        businessObject myBo = (businessObject) factory.getBean("bo");
        
//        Clo clo = (Clo) factory.getBean("clo");
        
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("This is for testing");
        clo.setPlo("3");
        
        
        
        
        Content cont = new Content();
        ArrayList<Clo> a=new ArrayList<Clo>();
        a.add(clo);
        cont.setClo(a);
        Date d=new Date();
        cont.setDescription("This is stuff");
        cont.setStarttime(d);
        cont.setEndtime(d);
        cont.setTitle("Content Title");
        
        myBo.addCLO(clo);
        
        System.out.println(myBo.getClo(11));
    }

} 