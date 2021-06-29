package br.com.senai.domain.model;

import br.com.senai.domain.service.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Cards {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(groups = ValidationGroups.ClienteId.class)
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 60)
    String secao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 60)
    String nome;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 30)
    String status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 50)
    String dataInicio;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 50)
    String dataEstimada;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Size(max = 50)
    String horasEstimadas;

    @NotBlank
    @Size(max = 50)
    String horasApontadas;

}
