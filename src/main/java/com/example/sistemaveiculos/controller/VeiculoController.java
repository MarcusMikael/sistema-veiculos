package com.example.sistemaveiculos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaveiculos.model.Veiculo;
import com.example.sistemaveiculos.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @PostMapping
    public Veiculo salvarveiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {

        Veiculo veiculo = veiculoService.buscarPorId(id);

        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(veiculo);
    }
}
