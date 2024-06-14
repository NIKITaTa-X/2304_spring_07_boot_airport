package by.itclass.fligth;

import by.itclass.airplane.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
    private FlightRepository repository;
    private AirplaneRepository airplaneRepository;

    @Autowired
    public void setRepository(FlightRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @GetMapping("/allFlights")
    public String getAllFights(Model model) {
        var flights = repository.findAll();
        model.addAttribute("flights", flights);
        return "flights";
    }

    @GetMapping("/addFlight")
    public String addFlight(Model model) {
        model.addAttribute("currentPlanes", airplaneRepository.findAll());
        return "add-flight";
    }

    @PostMapping("/saveFlight")
    public String saveFlight(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "number") String number,
            @RequestParam(name = "direction") String direction,
            @RequestParam(name = "planeId") int planeId) {
        var plane = airplaneRepository.findById(planeId).get();
        var flight = id == null
                ? new Flight(number, direction, plane)
                : new Flight(id, number, direction, plane);
        repository.save(flight);
        return "redirect:/allFlights";
    }

    @GetMapping("/viewFlight/{id}")
    public String viewFlight(
            @PathVariable(name = "id") int flightId,
            Model model) {
        model.addAttribute("flight", repository.findById(flightId).get());
        return "flight-info";
    }

    @GetMapping("/delFlight/{id}")
    public String delFlight(
            @PathVariable(name = "id") int id) {
        repository.deleteById(id);
        return "redirect:/allFlights";
    }

    @GetMapping("/updFlight/{id}")
    public String updFlight(
            @PathVariable(name = "id") int flightId,
            Model model) {
        var updatedFlight = repository.findById(flightId).get();
        model.addAttribute("updatedFlight", updatedFlight);
        model.addAttribute("currentPlanes", airplaneRepository.findAll());
        return "upd-flight";
    }


}
