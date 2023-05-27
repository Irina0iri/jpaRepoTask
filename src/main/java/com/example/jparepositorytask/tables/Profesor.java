package com.example.jparepositorytask.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//@Data
//@Entity
//@Table(name = "profesori")
//public class Profesor {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//    String nume;
//    @OneToMany(mappedBy = "profesor")
//    @JsonIgnore
//    private List<Materie> materiiPredate;
//
//    public List<Materie> getMateriiPredate() {
//        return materiiPredate;
//    }
//
//    public void setMateriiPredate(List<Materie> materiiPredate) {
//        this.materiiPredate = materiiPredate;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//}

@Entity
@Table(name = "profesori")
@Data
public class Profesor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "profesor")
    private Set<Materie> materiiPredate;
}
