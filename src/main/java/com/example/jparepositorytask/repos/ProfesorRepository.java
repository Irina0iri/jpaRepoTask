package com.example.jparepositorytask.repos;

import com.example.jparepositorytask.tables.Materie;
import com.example.jparepositorytask.tables.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
@Query( "select p from Materie p where p.id =?1")
    List<Optional<Materie>> getMateriiPredateByProfesor(String id);

}
