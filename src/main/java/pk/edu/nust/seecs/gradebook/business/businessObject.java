package pk.edu.nust.seecs.gradebook.business;

import pk.edu.nust.seecs.gradebook.entity.*;
import pk.edu.nust.seecs.gradebook.util.HibernateUtil;
import pk.edu.nust.seecs.gradebook.dao.*;

public class businessObject {
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
		CloDao cDao = new CloDao();
		cDao.addClo(t);
		return true;
	}
}
