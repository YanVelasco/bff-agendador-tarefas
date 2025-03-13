package com.yanvelasco.bff_agendador_tarefas.domain.user.service;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.EnderecoRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.LoginRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.TelefoneRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.UsuarioRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.EnderecoResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.TelefoneResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.UsuarioResponseDTO;

public interface UsuarioService {
    UsuarioResponseDTO cadastrar(UsuarioRequestDTO usuarioRequestDTO);

    String login(LoginRequestDTO loginRequestDTO);

    UsuarioResponseDTO buscarUsuarioPorEmail(String token, String email);

    void deletaUsuarioPorEmail(String token, String email);

    UsuarioResponseDTO atualizarDadosDoUsuario(String token, UsuarioRequestDTO usuarioRequestDTO);

    EnderecoResponseDTO atualizarEndereco(String token, Long id, EnderecoRequestDTO enderecoRequestDTO);

    TelefoneResponseDTO atualizarTelefone(String token, Long id, TelefoneRequestDTO telefoneRequestDTO);

    EnderecoResponseDTO cadastrarEndereco(String token, EnderecoRequestDTO enderecoRequestDTO);

    TelefoneResponseDTO cadastrarTelefone(String token, TelefoneRequestDTO telefoneRequestDTO);
}