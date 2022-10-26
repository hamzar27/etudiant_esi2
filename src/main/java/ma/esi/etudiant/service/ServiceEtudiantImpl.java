package ma.esi.etudiant.service;



import lombok.AllArgsConstructor;
import ma.esi.etudiant.entites.Etudiant;
import ma.esi.etudiant.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ServiceEtudiantImpl implements ServiceEtudiant {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public void saveEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    @Override
    public Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable) {
        return etudiantRepository.findByPrenomContains(keyword,pageable);
    }

    @Override
    public Page<Etudiant> findByNomContains(String keyword, Pageable pageable) {
        return etudiantRepository.findByNomContains(keyword, pageable);
    }

    @Override
    public Page<Etudiant> findByPrenomContainsAndNomContains(String keywordPrenom, String KeywordNom, Pageable pageable) {
        return etudiantRepository.findByPrenomContainsAndNomContains(keywordPrenom, KeywordNom, pageable);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteEtudiantById(id);
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return etudiantRepository.findEtudiantById(id);
    }
}
