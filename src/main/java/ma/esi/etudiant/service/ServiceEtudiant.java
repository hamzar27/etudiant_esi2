package ma.esi.etudiant.service;


import ma.esi.etudiant.entites.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ServiceEtudiant {
    void saveEtudiant(Etudiant etudiant);
    Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable);
    Page<Etudiant> findByNomContains(String keyword, Pageable pageable);
    Page<Etudiant> findByPrenomContainsAndNomContains(String keywordPrenom,String KeywordNom, Pageable pageable);
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);

}
