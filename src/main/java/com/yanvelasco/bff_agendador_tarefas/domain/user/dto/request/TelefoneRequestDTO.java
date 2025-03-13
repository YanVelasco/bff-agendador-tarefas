package com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneRequestDTO {
    private String numero;
    private String ddd;
}
