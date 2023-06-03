package com.proyecto.devAlejandro.proyecto.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity          @ToString @EqualsAndHashCode
@Table(name ="usuarios")
public class Usuario {

    @GeneratedValue(strategy=GenerationType.IDENTITY) //
    @Id //indica la llave primaria
    @Getter @Setter @Column(name ="id") // Hace referencia con las columna en la Database
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name =" email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "password")
    private String password;


}
