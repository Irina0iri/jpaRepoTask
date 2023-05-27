package com.example.jparepositorytask;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping(path = "/demo")
//public class ProfesorController {
//
//    private final ProfesorRepository _profesorRepository;
//    @Autowired
//    public ProfesorControler(ProfesorRepository profesorRepository) {
//        _profesorRepository = profesorRepository;
//    }
//    @GetMapping("/profesor/{id}")
//    public @ResponseBody Profesor getProfesor (@PathVariable int id){
//        return _profesorRepository.findById(id);
//    }
//
//    @GetMapping(path = "/profesor/materii/{id}")
//    public ResponseEntity<List<Materie>> getMateriiByProfesor(@PathVariable Integer id){
//        return ResponseEntity.ok(_profesorRepository.getMateriiPredateByProf(id));
//    }
//}


        import com.example.jparepositorytask.repos.ProfesorRepository;
        import com.example.jparepositorytask.tables.Materie;
        import com.example.jparepositorytask.tables.Profesor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping(path="/prof")
public class ProfesorController {

    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorController(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }

    @GetMapping(path = "/profesor/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesor(@PathVariable Integer id){
        return ResponseEntity.ok(profesorRepository.findById(id));
    }

    @GetMapping(path = "/profesor/materii/{id}")
    public ResponseEntity<List<Optional<Materie>>> getMateriiByProfesor(@PathVariable String id){
        return ResponseEntity.ok(profesorRepository.getMateriiPredateByProfesor(id));
    }
}
