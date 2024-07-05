package edu.utvt.teacher.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.teacher.persistence.entities.Teacher;
import edu.utvt.teacher.persistence.repositories.TeacherRepository;


@Service 
@Transactional
public class TeacherServiceImplementation implements TeacherService{
	@Autowired
	private TeacherRepository repository;
	
	@Transactional(readOnly = false)
	@Override
	public Teacher save(Teacher teacher) {
		return this.repository.save(teacher);
	}
	
	@Transactional(readOnly = false)
	@Override
	public Teacher update(String id,Teacher teacher) {
		Optional<Teacher> teacherOptional = null;
		 teacherOptional = this.findById(id);
		 
		 if(teacherOptional.isPresent()) {
			 teacherOptional.get().setLastName(teacher.getLastName());
			 teacherOptional.get().setFirstName(teacher.getFirstName());
			 teacherOptional.get().setEmail(teacher.getEmail());
			 teacherOptional.get().setStatus(teacher.getStatus());
			 teacherOptional.get().setBirthDate(teacher.getBirthDate());
			 this.repository.save(teacher);
		 }
		 
		 return teacherOptional.orElseThrow();
	}
	
	@Override
	public List<Teacher> findAll(){
		return this.repository.findAll();		
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Teacher> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ResponseEntity<Teacher> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Teacher> get(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Teacher> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}
}
