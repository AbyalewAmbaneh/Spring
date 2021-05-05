package miu.edu.com.example.springbootrestfulweb.repository;

import miu.edu.com.example.springbootrestfulweb.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
