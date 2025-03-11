package br.com.uptech.mysql.service;

import br.com.uptech.mysql.repository.StudentSFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentSFService {

  private final StudentSFRepository userRepository;

  public void teste() {
    userRepository.findAll();
  }

}
