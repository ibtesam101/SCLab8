package pk.edu.nust.seecs.gradebook.business;

import pk.edu.nust.seecs.gradebook.entity.*;
import pk.edu.nust.seecs.gradebook.util.HibernateUtil;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pk.edu.nust.seecs.gradebook.dao.*;

public class businessObject {

    Resource r = new ClassPathResource("applicationContext.xml");

    BeanFactory factory = new XmlBeanFactory(r);

	public void addTeacher(Teacher t){
		TeacherDao tDao = new TeacherDao();
		
		tDao.addTeacher(t);
	}
	
	public void addCourse(Course t){
		CourseDao cDao = new CourseDao();
		
		cDao.addCourse(t);
		
	}
	
	public void addStudent(Student t){
		StudentDao sDao = new StudentDao();
		
		sDao.addStudent(t);
	}
	
	public void addContent(Content t){
		ContentDao cDao = new ContentDao();
		
		cDao.addContent(t);
	}
	
	public void addGrade(Grade t){
		GradeDao gDao = new GradeDao();
		
		gDao.addGrade(t);
	}
	
	public boolean addCLO(Clo t){
       
        CloDao cDao = (CloDao) factory.getBean("clodao");
        
		cDao.addClo(t);
		return true;
	}
	
	public Clo getClo(int id){
        CloDao cDao = (CloDao) factory.getBean("clodao");
        
        Clo wut=cDao.getCloById(id);
        
		return wut;
	}
	
}
