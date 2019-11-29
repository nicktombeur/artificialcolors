package info.naturalcolors.features.number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberRepository extends JpaRepository<info.naturalcolors.database.Number, Long> {

    @Query("SELECT new info.naturalcolors.features.number.Number(n.code, n.artificial, COALESCE(nt.name, def.name)) " +
            "FROM info.naturalcolors.database.Number n " +
            "left outer join info.naturalcolors.database.NumberTranslation nt on n.id = nt.number.id and nt.language = :language " +
            "left outer join info.naturalcolors.database.NumberTranslation def on n.id = def.number.id and def.isDefault = true")
    List<Number> getAllTranslated(@Param("language") String language);

}
