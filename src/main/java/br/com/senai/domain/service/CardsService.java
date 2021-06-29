package br.com.senai.domain.service;

import br.com.senai.api.assembler.CardsAssembler;
import br.com.senai.api.model.CardsDTO;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Cards;
import br.com.senai.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class CardsService {

    private CardsRepository cardsRepository;
    private CardsAssembler cardsAssembler;

    public Cards buscar(Long cardId) {
        return cardsRepository.findById(cardId)
                .orElseThrow(() -> new NegocioException("Card não encontrado."));
    }
    public List<Cards> listar() {
        return cardsRepository.findAll();
    }
    public List<Cards> listarNomeContaining( String nomeContaining) {
        return cardsRepository.findByNomeContaining(nomeContaining);
       }
}