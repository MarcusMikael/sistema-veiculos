package com.example.sistemaveiculos.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.sistemaveiculos.model.Veiculo;

@Repository // O Spring passa a reconhecer essa classe e poderá disponibilizá-la para outras partes da aplicação.
public class VeiculoRepository {

    private List<Veiculo> veiculos = new ArrayList<>();

    private Long proximoId = 1L;

    public Veiculo salvar(Veiculo veiculo) {
    veiculo.setId(proximoId);
    proximoId++;

    veiculos.add(veiculo);

    return veiculo;
}

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Veiculo buscarPorId(long id) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        return null;
    }
    
}
