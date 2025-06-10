package it.epicode.U5W2D2practice.service;

import it.epicode.U5W2D2practice.exception.AutoreNotFoundException;
import it.epicode.U5W2D2practice.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();
    private int nextId = 1;

    public Autore saveAutore(Autore autore){
        autore.setId(nextId++);
        autore.setAvatar("https://www.google.com/url?q=https://ui-avatars.com/api/?name%3DMario%2BRossi&sa=D&source=editors&ust=1749560445102304&usg=AOvVaw1cbVa4xxrprdQr5bdWbxLC" + autore.getNome() + " " + autore.getCognome());
        autori.add(autore);
        return autore;
    }


    public Autore getAutore(int id) throws AutoreNotFoundException {
        return autori.stream().filter(autore -> autore.getId()==id).findFirst().orElseThrow(() -> new AutoreNotFoundException("Autore con id " + id));
    }

    public List<Autore> getAllAutori(){
        return autori;
    }

    public Autore updateAutore(int id, Autore autore) throws AutoreNotFoundException{
        Autore autoreToSearch = getAutore(id);

        autoreToSearch.setNome(autore.getNome());
        autoreToSearch.setCognome(autore.getCognome());
        autoreToSearch.setDataDiNascita(autore.getDataDiNascita());

        return autoreToSearch;
    }

    public void deleteAutore(int id) throws AutoreNotFoundException{
        Autore autoreToRemove = getAutore(id);

        autori.remove(autoreToRemove);
    }

}
