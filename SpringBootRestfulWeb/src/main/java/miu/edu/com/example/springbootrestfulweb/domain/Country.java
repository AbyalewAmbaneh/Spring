package miu.edu.com.example.springbootrestfulweb.domain;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "city")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Transactional
public class Country {
    @Id
    private Integer Id;

    private String Name;

    private String District;

}

