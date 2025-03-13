package com.yanvelasco.bff_agendador_tarefas.domain.user.service;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.EnderecoDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.TelefoneDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO cadastrar(UsuarioDTO usuarioDTO);

    String login(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarUsuarioPorEmail(String token,String email);

    void deletaUsuarioPorEmail(String token, String email);

    UsuarioDTO atualizarDadosDoUsuario(String token, UsuarioDTO usuarioDTO);

    EnderecoDTO atualizarEndereco(String token, Long id, EnderecoDTO enderecoDTO);

    TelefoneDTO atualizarTelefone(String token, Long id, TelefoneDTO telefoneDTO);

    EnderecoDTO cadastrarEndereco(String token, EnderecoDTO enderecoDTO);

    TelefoneDTO cadastrarTelefone(String token, TelefoneDTO telefoneDTO);
}