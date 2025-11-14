package com.example.StudentManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentManagerRessource {
	
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	// INSTITUTE
	

	@Autowired
	private InstitutRepository institutRepo;
	
	@PostMapping("/addInstitut/{id}/{name}")
	public void addInstitute(@PathVariable Integer id, @PathVariable String name) {
		institutRepo.save(new Institute(id, name));
	}

	@DeleteMapping("/delInstitut/{id}")
	public void delInstitute(@PathVariable Integer id) {
		institutRepo.deleteById(id);
	}
	
	@GetMapping("/getAllInstitutes")
    public List<Institute> getAllInstitutes() {
        return institutRepo.findAll();
    }
	
	@GetMapping("/getInstituteById/{id}")
    public Institute getInstituteById(@PathVariable Integer id) {
        return institutRepo.findById(id).orElse(null);
    }
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	// CURSUS
	

	@Autowired
	private CursusRepo cursusRepo;
	
	@PostMapping("/addCursus/{id}/{name}")
	public void addCursus(@PathVariable Integer id, @PathVariable String name) {
		System.out.println("in 'addCursus'");
		cursusRepo.save(new Cursus(id, name));
	}

	@DeleteMapping("/delCursus/{id}")
	public void delCursus(@PathVariable Integer id) {
		cursusRepo.deleteById(id);
	}
	
	@GetMapping("/getAllCursus")
    public List<Cursus> getAllCursus() {
        return cursusRepo.findAll();
    }
	
	@GetMapping("/getCursusById/{id}")
    public Cursus getCursusById(@PathVariable Integer id) {
        return cursusRepo.findById(id).orElse(null);
    }
		
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	// COMPETENCE
	

	@Autowired
	private CompetenceRepository competenceRepo;
	
	@PostMapping("/addCompetence/{id}/{name}")
	public void addCompetence(@PathVariable Integer id, @PathVariable String name) {
		competenceRepo.save(new Competence(id, name));
	}

	@DeleteMapping("/delCompetence/{id}")
	public void delCompetence (@PathVariable Integer id) {
		competenceRepo.deleteById(id);
	}
	
	@GetMapping("/getAllCompetences")
    public List<Competence> getAllCompetences() {
        return competenceRepo.findAll();
    }
	
	@GetMapping("/getCompetenceById/{id}")
    public Competence getCompetenceById(@PathVariable Integer id) {
        return competenceRepo.findById(id).orElse(null);
    }
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	// COMPETENCE
	

	@Autowired
	private StudentRepository studentRepo;
	
	@PostMapping("/addStudent/{id}/{name}/{surname}/{email}/{idCursus}/{idInstitute}")
	public void addCompetence(@PathVariable Integer id, @PathVariable String name, @PathVariable String surname, @PathVariable String email, @PathVariable Integer idCursus, @PathVariable Integer idInstitute) {
		studentRepo.save(new Student(id, name,surname, email, idInstitute, idCursus));
	}

	@DeleteMapping("/delStudent/{id}")
	public void delStudent(@PathVariable Integer id) {
		studentRepo.deleteById(id);
	}
	
	@GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
	
	@GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepo.findById(id).orElse(null);
    }
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	
}
