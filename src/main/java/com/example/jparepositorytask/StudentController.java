package com.example.jparepositorytask;

import com.example.jparepositorytask.repos.MaterieRepository;
import com.example.jparepositorytask.repos.StudentRepository;
import com.example.jparepositorytask.tables.Adresa;
import com.example.jparepositorytask.tables.Materie;
import com.example.jparepositorytask.tables.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/st")
public class StudentController {

    private final StudentRepository _studentRepository;
    private final MaterieRepository _materieRepository;
    StudentController (StudentRepository studentRepository, MaterieRepository materieRepository){
        _studentRepository = studentRepository;
        _materieRepository = materieRepository;
    }
    @PostMapping("/student")
    public @ResponseBody Student addStudent(@RequestBody Student student){
        return  _studentRepository.save(student);
    }

    @PostMapping("/enroll")
    public @ResponseBody String enrollStudent (@RequestParam (name = "student_id") Integer studentId,@RequestParam (name = "materie_id") Integer materieId ){
        Optional<Student> student = _studentRepository.findById(studentId);
        Optional<Materie> materie = _materieRepository.findById(materieId);
        if(student.isEmpty() || materie.isEmpty()){
            return "Could not enroll student " + student.get().getNume() + " to course " + materie.get().getNume();
        }
        student.get().getMateriiAlese().add(materie.get());
        _studentRepository.save(student.get());
        return "enrolled";
    }

    @PutMapping("/student/{studentId}/adress")
    public @ResponseBody Optional<Student> updateAdress(@PathVariable Integer studentId, @RequestBody Adresa address){
        Optional<Student> student = _studentRepository.findById(studentId);
        if(!student.isPresent()){
            return Optional.empty();
        }
        student.get().setAdresa(address);
        _studentRepository.save(student.get());
        return student;
    }

    @DeleteMapping("/student/{studentId}")
    public @ResponseBody String deleteStudent(@PathVariable Integer studentId){
        Optional<Student> student  = _studentRepository.findById(studentId);
        if(!student.isPresent()){
            return "This student is not enrolled anywhere";
        }
        student.get().getInscrieri().clear();
        _studentRepository.delete(student.get());
        return "The student " + student.get().getNume() + " " + student.get().getPrenume() + " with ID: " + studentId + " has been unenrolled from all courses";
    }

}
