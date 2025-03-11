package br.com.uptech.postgres.service;

import br.com.uptech.postgres.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

//  public void teste() {
//    userRepository.findAll();
//  }

}
