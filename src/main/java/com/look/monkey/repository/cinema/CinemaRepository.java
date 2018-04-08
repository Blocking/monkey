package com.look.monkey.repository.cinema;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.look.monkey.entity.cinema.Cinema;

/**
 * CinemaRepository
 */
public interface CinemaRepository extends Repository<Cinema, Long> {

    Page<Cinema> findAll(Pageable pageable);

    Cinema findOne(Long id);

    Cinema save(Cinema model);

    void delete(Long id);
    
    List<Cinema> findAll();
    
    Cinema findByCode(String code);


    List<Cinema> findAllByCinemaChainCode(String cinemaChainCode);

    List<Cinema> findAllByCinemaChainCode(String cinemaChainCode,Pageable pageable);

}
