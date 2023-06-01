package com.upc.simlacro1_1.business;

import com.upc.simlacro1_1.dtos.TouristDTO;
import com.upc.simlacro1_1.entity.Tourist;
import com.upc.simlacro1_1.repository.RepositoryTourist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessTourist {
    @Autowired
    private RepositoryTourist repositoryTourist;
    public Tourist register(Tourist tourist){return repositoryTourist.save(tourist);}

    public List<Tourist> listTourist() {return repositoryTourist.findAll();}

    public  List<Tourist> listTouristStatus(String status){return repositoryTourist.findAllByStatus(status);}

    private List<TouristDTO> convertToLisDto(List<Tourist> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private TouristDTO convertToDto(Tourist author) {
        ModelMapper modelMapper = new ModelMapper();
        TouristDTO touristDTO = modelMapper.map(author, TouristDTO.class);
        return touristDTO;
    }

    public  Tourist buscar(Long dni) throws Exception {
        return  repositoryTourist.findById(dni).
                orElseThrow(() -> new Exception("No Disponible"));
    }

    public List<Tourist> obtenerReportePorDescripcion(String status){
        return repositoryTourist.findByStatusStartingWith(status);
    }

    public Tourist actualizarTourist(Tourist tourist) throws Exception{
        repositoryTourist.findById(tourist.getId()).orElseThrow(()-> new Exception("No se encontró entidad"));
        return repositoryTourist.save(tourist);
    }

    public Tourist borrarProducto(Long codigo) throws Exception {
        Tourist tourist = repositoryTourist.findById(codigo).orElseThrow(()-> new Exception("No se encontró entidad"));
        repositoryTourist.delete(tourist);
        return tourist;
    }

}
