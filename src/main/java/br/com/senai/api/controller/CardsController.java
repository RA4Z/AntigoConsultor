package br.com.senai.api.controller;

import br.com.senai.domain.model.Cards;
import br.com.senai.domain.repository.CardsRepository;
import br.com.senai.domain.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class
CardsController {

    private final CardsRepository cardsRepository;
    private final CardsService cardsService;

    @GetMapping()
    public List<Cards> listar() {
        return cardsService.listar();
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<Cards> listarNomeContaining(@PathVariable String nomeContaining) {
        return cardsService.listarNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public Cards buscar(@PathVariable Long pessoaId) {
        return cardsService.buscar(pessoaId);
    }

    @JoinColumn(name = "horas_apontadas")
    @PutMapping("/{pessoaId}")
    public ResponseEntity<Cards> editar(
            @Valid @PathVariable Long pessoaId,
            @RequestBody Cards cards
    ){
        if(!cardsRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        Optional<Cards> cardzin;
        cardzin = cardsRepository.findById(pessoaId);
        cards.setStatus(cardzin.get().getStatus());
        cards.setSecao(cardzin.get().getSecao());
        cards.setNome(cardzin.get().getNome());
        cards.setDataInicio(cardzin.get().getDataInicio());
        cards.setDataEstimada(cardzin.get().getDataEstimada());

        cards.setId(pessoaId);
        cards = cardsRepository.save(cards);

        return ResponseEntity.ok(cards);
    }
}
