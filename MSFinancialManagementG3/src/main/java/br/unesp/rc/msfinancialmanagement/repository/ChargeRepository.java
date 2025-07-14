package br.unesp.rc.msfinancialmanagement.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.unesp.rc.msfinancialmanagement.entity.Charge;

import java.util.List;

public interface ChargeRepository extends MongoRepository<Charge, String> {
    @Cacheable("charges")
    public List<Charge> findAllByResidentResidentId(String residentId);
}
