package com.trabalho.trabalho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestParam("peso") String pesoTexto, @RequestParam("altura") String alturaTexto) {
        double peso = Double.parseDouble(pesoTexto);
        double altura = Double.parseDouble(alturaTexto);
        double imc = peso / (altura * altura);
        Usuario usuario = new Usuario();
        usuario.setPeso(peso);
        usuario.setAltura(altura);
        usuario.setImc(imc);
        return repository.save(usuario);
    }
    @GetMapping("/lista")
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }
}
