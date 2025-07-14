package br.unesp.rc.msaccesscontrol.repository;

import br.unesp.rc.msaccesscontrol.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
