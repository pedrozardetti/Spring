package br.com.gestao_vagas.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Usuário Inválido! Seu usuário não pode ser nulo")
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo username não deve conter espaços!")
    private String username;

    @Email(message = "E-mail Inválido!")
    private String email;

    @Length(min = 10, max = 100, message = "Senha inválida! Ela deve conter entre (10) e (100) caracteres.")
    private String password;
    private String description;
    private String curriculum;
    @CreationTimestamp
    private LocalDateTime createdAt;
}