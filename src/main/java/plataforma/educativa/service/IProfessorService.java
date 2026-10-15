package plataforma.educativa.service;

import plataforma.educativa.dto.CourseDTO;
import plataforma.educativa.dto.ProfessorDTO;
import plataforma.educativa.model.Professor;

import java.util.List;

public interface IProfessorService {

    ProfessorDTO save(ProfessorDTO professorDTO);

    List<ProfessorDTO> findAll();

    ProfessorDTO findById(Long id);

    ProfessorDTO update(Long id, ProfessorDTO professorDTO);

    void delete(Long id);


}
