package com.yanvelasco.bff_agendador_tarefas.infra.client;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.EnderecoDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.TelefoneDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario-service", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @RequestParam("email") String email);

    @PostMapping
    UsuarioDTO cadastrar(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @PathVariable String email
    );

    @PutMapping
    UsuarioDTO atualizarDadosDoUsuario(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioDTO usuarioDTO
    );

    @PutMapping("/endereco/{id}")
    EnderecoDTO atualizarEndereco(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody EnderecoDTO enderecoDTO
    );

    @PutMapping("/telefone/{id}")
    TelefoneDTO atualizarTelefone(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody TelefoneDTO telefoneDTO
    );

    @PostMapping("/endereco")
    EnderecoDTO cadastrarEndereco(
            @RequestHeader("Authorization") String token,
            @RequestBody EnderecoDTO enderecoDTO
    );


    @PostMapping("/telefone")
    TelefoneDTO cadastrarTelefone(
            @RequestHeader("Authorization") String token,
            @RequestBody TelefoneDTO telefoneDTO
    );

}
