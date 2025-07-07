package de.klettermaterial.seil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeilService {
    @Autowired //dem Seilservice wird automatisch eine passende Implementation des SeilRepos reininjiziert.
    private SeilRepository seilRepository;

    public void addSeil(Seil seil) {
        seilRepository.save(seil);
    }

    public long numberOfSeile() {
        return seilRepository.count();
    }

    public List<Seil> seileVomHersteller(String hersteller){
        return StreamSupport.stream(seilRepository.findAll().spliterator(),false)
                .filter(seil -> seil.getName().equals(hersteller))
                .collect(Collectors.toList());
    }


}
