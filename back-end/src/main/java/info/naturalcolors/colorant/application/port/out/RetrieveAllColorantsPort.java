package info.naturalcolors.colorant.application.port.out;

import info.naturalcolors.colorant.domain.Colorant;

import java.util.List;

public interface RetrieveAllColorantsPort {
    List<Colorant> getAllTranslated(final String language);
}
