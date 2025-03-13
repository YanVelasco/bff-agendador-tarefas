package com.yanvelasco.bff_agendador_tarefas.infra.client;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.EnderecoRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.LoginRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.TelefoneRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.UsuarioRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.EnderecoResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.TelefoneResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario-service", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioResponseDTO buscaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @RequestParam("email") String email);

    @PostMapping
    UsuarioResponseDTO cadastrar(@RequestBody UsuarioRequestDTO usuarioRequestDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @PathVariable String email
    );

    @PutMapping
    UsuarioResponseDTO atualizarDadosDoUsuario(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioRequestDTO usuarioRequestDTO
    );

    @PutMapping("/endereco/{id}")
    EnderecoResponseDTO atualizarEndereco(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody EnderecoRequestDTO enderecoRequestDTO
    );

    @PutMapping("/telefone/{id}")
    TelefoneResponseDTO atualizarTelefone(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody TelefoneRequestDTO telefoneRequestDTO
    );

    @PostMapping("/endereco")
    EnderecoResponseDTO cadastrarEndereco(
            @RequestHeader("Authorization") String token,
            @RequestBody EnderecoRequestDTO enderecoRequestDTO
    );


    @PostMapping("/telefone")
    TelefoneResponseDTO cadastrarTelefone(
            @RequestHeader("Authorization") String token,
            @RequestBody TelefoneRequestDTO telefoneRequestDTO
    );

}
