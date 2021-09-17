package info.naturalcolors.colorant.adapter.out.persistence;

import info.naturalcolors.colorant.domain.Colorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorantRepository extends JpaRepository<info.naturalcolors.colorant.adapter.out.persistence.model.Colorant, Long> {

    @Query("""
            SELECT new info.naturalcolors.colorant.domain.Colorant(c.code, c.artificial, ct.name)
            FROM info.naturalcolors.colorant.adapter.out.persistence.model.Colorant c
            left outer join info.naturalcolors.colorant.adapter.out.persistence.model.ColorantTranslation ct
            on c.id = ct.colorant.id
            and ct.language = :language
            """)
    List<Colorant> getAllTranslated(@Param("language") String language);

}
