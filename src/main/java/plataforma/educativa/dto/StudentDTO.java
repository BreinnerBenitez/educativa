package plataforma.educativa.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "email"})
public record StudentDTO(Long id,
                         String name,
                         String email) {
}
