package info.naturalcolors.colorant.adapter.in.web;

import info.naturalcolors.colorant.application.port.in.RetrieveAllColorantsCommand;
import info.naturalcolors.colorant.application.port.in.RetrieveAllColorantsUseCase;
import info.naturalcolors.colorant.domain.Colorant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/colorant")
public class ColorantController {

    private final RetrieveAllColorantsUseCase retrieveAllColorants;

    @GetMapping
    public List<Colorant> getAll(@RequestParam(value = "lang", required = false) String language) {
        return retrieveAllColorants.retrieveAll(new RetrieveAllColorantsCommand(null));
    }

}
