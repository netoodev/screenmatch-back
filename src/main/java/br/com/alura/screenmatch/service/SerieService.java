package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obterTodasAsSeries() {
        return repository.findAll().stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(),
                        s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }
}