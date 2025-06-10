package it.epicode.U5W2D2practice.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
