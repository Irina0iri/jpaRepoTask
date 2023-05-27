package com.example.jparepositorytask.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

//@Entity
//@Table(name = "materii")
//public class Materie {
//    @Id
//    int id;
//    @Column
//    String nume;
//    @ManyToOne
//    @JoinColumn(name = "id_profesor")
//    @JsonBackReference
//    private Profesor profesor;
//
//}


@Entity
@Table(name = "materii")
@Data
public class Materie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

//    @ManyToMany(mappedBy = "cursuriAlese", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Student> studentiInrolati;

//    @OneToMany(mappedBy = "materie")
//    @JsonIgnore
//    private Set<StudentiToMaterie> inscrieri;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonBackReference
    private Profesor profesor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materie materie = (Materie) o;
        return id.equals(materie.id) && nume.equals(materie.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }
}
