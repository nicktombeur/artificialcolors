package info.naturalcolors.colorant.application.service;

import info.naturalcolors.colorant.application.port.in.RetrieveAllColorantsUseCase;
import info.naturalcolors.colorant.application.port.out.RetrieveAllColorantsPort;
import info.naturalcolors.colorant.domain.Colorant;
import info.naturalcolors.colorant.domain.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorantService implements RetrieveAllColorantsUseCase {

    private final RetrieveAllColorantsPort retrieveAllColorantsPort;

    @Override
    public List<Colorant> retrieveAll(final Language language) {
        final String iso = Language.toIso(language);
        return retrieveAllColorantsPort.getAllTranslated(iso);
    }
}
