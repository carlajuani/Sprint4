package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t01.n01.S04T01N01.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping({"/HelloWorld", "/HelloWorld?nom=Carla Blasco Vidal"})
    @ResponseBody
    public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }

    @RequestMapping({"/HelloWorld2", "/HelloWorld2/{nom}"})
    @ResponseBody
    public String saluda2(@PathVariable(required = false) String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }


}
