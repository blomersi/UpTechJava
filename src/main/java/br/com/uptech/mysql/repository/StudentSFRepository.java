package br.com.uptech.mysql.repository;

import br.com.uptech.mysql.entity.StudentSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSFRepository extends JpaRepository<StudentSF, String> {

}
