package br.edu.ifsp.prw3.oficina.conserto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(

        @NotNull
        Long id,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,
        String nomeMecanico,
        Integer anosExperienciaMecanico) { }

