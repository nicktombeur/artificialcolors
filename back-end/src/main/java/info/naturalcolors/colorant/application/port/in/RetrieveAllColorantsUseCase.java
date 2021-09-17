package info.naturalcolors.colorant.application.port.in;

import info.naturalcolors.colorant.domain.Colorant;

import java.util.List;

public interface RetrieveAllColorantsUseCase {
    List<Colorant> retrieveAll(final RetrieveAllColorantsCommand command);
}
