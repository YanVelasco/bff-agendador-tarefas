package com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoResponseDTO> enderecoResponseDTO;
    private List<TelefoneResponseDTO> telefoneResponseDTO;
}
