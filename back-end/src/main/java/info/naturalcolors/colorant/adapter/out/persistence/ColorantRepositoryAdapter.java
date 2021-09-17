package info.naturalcolors.colorant.adapter.out.persistence;

import info.naturalcolors.colorant.application.port.out.RetrieveAllColorantsPort;
import info.naturalcolors.colorant.domain.Colorant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ColorantRepositoryAdapter implements RetrieveAllColorantsPort {

    private final ColorantRepository colorantRepository;

    @Override
    public List<Colorant> getAllTranslated(String language) {
        return colorantRepository.getAllTranslated(language);
    }
}
