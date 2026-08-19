package com.example.sistemaveiculos.service;

import org.springframework.stereotype.Service;
import com.example.sistemaveiculos.model.Veiculo;
import com.example.sistemaveiculos.repository.VeiculoRepository;
import java.time.Year;

import java.util.List;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    
    public Veiculo salvar(Veiculo veiculo) {

        // Preço tem que ser maior que 0
        if (veiculo.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do veículo deve ser maior que zero.");
        }

        // Ano atual
        int anoAtual = Year.now().getValue();

        if (veiculo.getAno() > anoAtual) {
            throw new IllegalArgumentException("O ano do veículo não pode ser maior que o ano atual.");
        }

        return veiculoRepository.salvar(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.listarVeiculos();
    }

}
