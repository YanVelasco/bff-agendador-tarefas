package com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.enums.StatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaResponseDTO {

    private String id;

    private String nomeDaTarefa;

    private String descricao;

    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;

    private String emailDoUsuario;

    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataUltimaAtualizacao;

    private StatusEnum status;

}