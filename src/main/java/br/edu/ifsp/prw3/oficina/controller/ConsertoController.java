package br.edu.ifsp.prw3.oficina.controller;

import br.edu.ifsp.prw3.oficina.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    private final ConsertoRepository repository;

    public ConsertoController(ConsertoRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados,
                                    UriComponentsBuilder uriBuilder) {

        var conserto = new Conserto(dados);

        repository.save(conserto);


        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }




    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {

        var pagina = repository.findAll(paginacao).map(DadosDetalhamentoConserto::new);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/algunsdados")
    public ResponseEntity listarAlgunsDados() {

        var lista = repository.findAllByAtivoTrue().stream()
                .map(DadosListagemConserto::new)
                .toList();

        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {

        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoConserto(consertoOptional.get()));
        }

        else {
            return ResponseEntity.notFound().build();
        }

    }



    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {

        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();
        return ResponseEntity.noContent().build();
    }

}






