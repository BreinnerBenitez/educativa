package plataforma.educativa.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "email"})
public record ProfessorDTO( Long id,
                            String name,
                            String email) {
}
