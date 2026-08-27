package br.com.fiap.cryptoplanner.planner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PlannerController {

    private final PlannerService service;
    public record PlannerResponse(String result) {}

    @GetMapping
    public PlannerResponse getPlan(@RequestParam String activity) {
        return new PlannerResponse(service.getPlannerFromActivity(activity));
    }
}
