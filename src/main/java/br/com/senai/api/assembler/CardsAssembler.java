package br.com.senai.api.assembler;

import br.com.senai.api.model.CardsDTO;
import br.com.senai.api.model.input.CardsInputDTO;
import br.com.senai.domain.model.Cards;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
@AllArgsConstructor
public class CardsAssembler {

    private ModelMapper modelMapper;

    public CardsDTO toModel(Cards cards) {
        return modelMapper.map(cards, CardsDTO.class);
    }

    public List<CardsDTO> toCollectionModel(List<Cards> cards) {
        return cards.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Cards toEntity(CardsInputDTO cardsInputDTO) {
        return modelMapper.map(cardsInputDTO, Cards.class);
    }
}