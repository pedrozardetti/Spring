package br.com.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {

    private UUID id;
    @NotNull(message = "Usuário Inválido! Seu usuário não pode ser nulo")
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo username não deve conter espaços!")
    private String username;

    @Email(message = "E-mail Inválido!")
    private String email;

    @Size(min = 3, max = 12, message = "Senha inválida! Ela deve conter entre 3 a 12 caracteres.")
    private String password;
    private String description;
    private String curriculum;
}