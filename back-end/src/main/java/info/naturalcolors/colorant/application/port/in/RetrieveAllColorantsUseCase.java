package info.naturalcolors.colorant.application.port.in;

import info.naturalcolors.colorant.domain.Colorant;
import info.naturalcolors.colorant.domain.Language;

import java.util.List;

public interface RetrieveAllColorantsUseCase {
    List<Colorant> retrieveAll(final Language language);
}
