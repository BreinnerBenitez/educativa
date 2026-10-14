package plataforma.educativa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma.educativa.dto.ProfessorDTO;
import plataforma.educativa.model.Permission;
import plataforma.educativa.model.Professor;
import plataforma.educativa.repository.IProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService implements IProfessorService {

    private final IProfessorRepository professorRepository;

    @Override
    public ProfessorDTO save(ProfessorDTO professorDTO) {


        Professor professor = Professor.builder()
                .name(professorDTO.name())
                .email(professorDTO.email())
                .build();

        Professor savedProfessor = professorRepository.save(professor);

        return toRecord(savedProfessor);
    }

    @Override
    public List<ProfessorDTO> findAll() {

        return professorRepository.findAll()
                .stream()
                .map(this::toRecord)
                .toList();


    }

    @Override
    public ProfessorDTO findById(Long id) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        return toRecord(professor);

    }

    @Override
    public ProfessorDTO update(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        professor.setName(professorDTO.name());
        professor.setEmail(professorDTO.email());

        Professor updatedProfessor = professorRepository.save(professor);

        return toRecord(updatedProfessor);
    }


    @Override
    public void delete(Long id) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        professorRepository.delete(professor);
    }

    private ProfessorDTO toRecord(Professor professor) {

        return new ProfessorDTO(
                professor.getId(),
                professor.getName(),
                professor.getEmail()
        );
    }

}