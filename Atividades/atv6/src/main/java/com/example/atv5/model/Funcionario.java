package com.example.atv5.model;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@NamedQuery(name="Funcionario.findAll", query="select f from Funcionario as f")
@NamedQuery(name="Funcionario.findByIniciadosPorId", query="select f from Funcionario as f where f.id like :id")
@Table(name = "funcionarios")

public class Funcionario {
    //@Id
    @Id
    @NonNull @Getter @Setter private int id;
    @NonNull @Getter @Setter private String cpf;
    @Getter @Setter private String matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;
}