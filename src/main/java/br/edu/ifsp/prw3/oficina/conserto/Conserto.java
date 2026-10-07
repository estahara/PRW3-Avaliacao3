package br.edu.ifsp.prw3.oficina.conserto;

import br.edu.ifsp.prw3.oficina.mecanico.Mecanico;
import br.edu.ifsp.prw3.oficina.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }


    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {

        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }

        if (dados.nomeMecanico() != null || dados.anosExperienciaMecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.nomeMecanico(), dados.anosExperienciaMecanico());
        }
    }


    public void excluir() { this.ativo = false; }

}






