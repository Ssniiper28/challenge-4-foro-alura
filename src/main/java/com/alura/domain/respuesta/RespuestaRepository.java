package com.alura.domain.respuesta;

import com.alura.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    @Query("""
            SELECT r FROM Respuesta r
            WHERE r.topico=:topico
            """)
    List<Respuesta> findAllByTopico(Topico topico);

}
