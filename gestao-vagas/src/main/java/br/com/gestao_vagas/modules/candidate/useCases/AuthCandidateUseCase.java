package br.com.gestao_vagas.modules.candidate.useCases;


import br.com.gestao_vagas.exceptions.AuthenticationException;
import br.com.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCandidateRequestDTO authCandidateRequestDTO) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.username())
                .orElseThrow(() -> {
                            throw new UsernameNotFoundException("Username/password incorrect");
                        });

        var passwordMatches = this.passwordEncoder
                .matches(authCandidateRequestDTO.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Username/password incorrect");
        }
    }

}
