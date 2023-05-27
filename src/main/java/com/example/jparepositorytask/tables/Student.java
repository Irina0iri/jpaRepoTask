package com.example.jparepositorytask.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "studenti")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "CNP")
    private String cnp;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresa")
    Adresa adresa;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "studenti_to_materii"
            ,joinColumns = @JoinColumn(name = "id_student")
            ,inverseJoinColumns = @JoinColumn(name = "id_materie"))
    private Set<Materie> materiiAlese;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    //@ToString.Exclude
    private Set<StudentiToMaterie> inscrieri;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && nume.equals(student.nume) && prenume.equals(student.prenume) && cnp.equals(student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, cnp);
    }
}
