package com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoRequestDTO> enderecoRequestDTO;
    private List<TelefoneRequestDTO> telefoneRequestDTO;
}
