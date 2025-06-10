package it.epicode.U5W2D2practice.controller;

import it.epicode.U5W2D2practice.exception.AutoreNotFoundException;
import it.epicode.U5W2D2practice.model.Autore;
import it.epicode.U5W2D2practice.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/autori/{id}")
    public Autore getAutore(int id) throws AutoreNotFoundException {
        return autoreService.getAutore(id);
    }

    @GetMapping("/autori")
    public List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore) throws AutoreNotFoundException{
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/autori/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutori(@PathVariable int id) throws AutoreNotFoundException{
        autoreService.deleteAutore(id);
    }


}
