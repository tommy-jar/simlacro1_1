package com.upc.simlacro1_1.controller;

import com.upc.simlacro1_1.business.BusinessTourist;
import com.upc.simlacro1_1.dtos.TouristDTO;
import com.upc.simlacro1_1.entity.Tourist;
import com.upc.simlacro1_1.repository.RepositoryTourist;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ControllerTourist {
    @Autowired
    private BusinessTourist businessTourist;
    Logger logger = LoggerFactory.getLogger(TouristDTO.class);
    @PostMapping("/tourist")
    public ResponseEntity<TouristDTO> register(@RequestBody TouristDTO touristDTO){
        Tourist tourist = convertToEntity(touristDTO);
        tourist = businessTourist.register(tourist);
        touristDTO = convertToDto(tourist);
        return  new ResponseEntity<TouristDTO>(touristDTO, HttpStatus.OK);
    }

    private TouristDTO convertToDto(Tourist tourist) {
        ModelMapper modelMapper = new ModelMapper();
        TouristDTO touristDTO = modelMapper.map(tourist, TouristDTO.class);
        return touristDTO;
    }

    private Tourist convertToEntity(TouristDTO touristDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tourist post = modelMapper.map(touristDTO, Tourist.class);
        return post;
    }

    private List<TouristDTO> convertToLisDto(List<Tourist> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/tourists")
    public ResponseEntity<List<TouristDTO>> obtenerTuristas(){
        List<Tourist> list = businessTourist.listTourist();
        List<TouristDTO> listDTO = convertToLisDto(list);
        return  new ResponseEntity<List<TouristDTO>>(listDTO, HttpStatus.OK);
    }


    @GetMapping("/tourists/{status}")
    public ResponseEntity<List<TouristDTO>> obtenerStatusTouristas(@PathVariable(value = "status") String status){
        List<Tourist> list = businessTourist.obtenerReportePorDescripcion(status);
        List<TouristDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<TouristDTO>>(listDto, HttpStatus.OK);

    }

    @PutMapping("/tourist")
    public ResponseEntity<TouristDTO> actualizarTuristas(@RequestBody TouristDTO touristDetalle) {
        TouristDTO touristDTO;
        Tourist tourist;
        try{
            tourist = convertToEntity(touristDetalle);
            logger.debug("Actualizando lista");
            tourist = businessTourist.actualizarTourist(tourist);
            logger.debug("Turista Actualizado");
            touristDTO = convertToDto(tourist);
            return new ResponseEntity<TouristDTO>(touristDTO, HttpStatus.OK);

        }catch (Exception e){
            logger.error("Error de Actualización", e);
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "no se pudo actualizar, sorry");
        }
    }








}
