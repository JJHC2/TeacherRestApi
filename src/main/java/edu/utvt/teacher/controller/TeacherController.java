package edu.utvt.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.teacher.persistence.entities.Teacher;
import edu.utvt.teacher.persistence.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/all")
	public List<Teacher> get(){
		return this.teacherService.findAll();
	}
	
	@GetMapping
	public Page<Teacher> findAll(@RequestParam(defaultValue = "1",value= "page")Integer page,Integer size){
		return this.teacherService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Teacher>save(@RequestBody Teacher teacher){
		return ResponseEntity.created(null).body(this.teacherService.save(teacher));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> update(@PathVariable("id") String id,@RequestBody Teacher teacher){
		return ResponseEntity.ok(this.teacherService.update(id,teacher));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable("id") String id){
		return ResponseEntity.of(this.teacherService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
		this.teacherService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
