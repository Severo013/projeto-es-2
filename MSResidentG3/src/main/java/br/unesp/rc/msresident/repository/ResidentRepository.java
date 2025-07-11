package br.unesp.rc.msresident.repository;

import br.unesp.rc.msresident.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
     Resident findByCpf(String cpf);
}
