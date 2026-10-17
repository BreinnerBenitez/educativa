package plataforma.educativa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import plataforma.educativa.dto.ProfessorDTO;
import plataforma.educativa.service.IProfessorService;
import plataforma.educativa.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping ("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProfessorDTO> save(
            @RequestBody ProfessorDTO professorDTO) {

        return ResponseEntity.ok(professorService.save(professorDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> findAll() {

        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(professorService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> update(
            @PathVariable Long id,
            @RequestBody ProfessorDTO professorDTO) {

        return ResponseEntity.ok(
                professorService.update(id, professorDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        professorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
