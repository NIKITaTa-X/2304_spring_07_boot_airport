package by.itclass.airplane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirplaneController {
    private AirplaneRepository repository;

    @Autowired
    public void setRepository(AirplaneRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String main() {
        return "airport";
    }

    @GetMapping("/allPlanes")
    public String getAllPlanes(Model model) {
        var planes = repository.findAll();
        model.addAttribute("planes", planes);
        return "airplanes";
    }

    @PostMapping("/addPlane")
    public String addPlane(
            @RequestParam(name = "model") String model,
            @RequestParam(name = "places") int places){
        repository.save(new Airplane(model, places));
        return "redirect:/allPlanes";
    }

    @GetMapping("/delPlane/{id}")
    public String delPlane(
            @PathVariable(name = "id") int planeId) {
        repository.deleteById(planeId);
        return "redirect:/allPlanes";
    }
}
