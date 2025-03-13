package com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneResponseDTO {
    private Long id;
    private String numero;
    private String ddd;
}
