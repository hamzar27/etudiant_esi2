package ma.esi.etudiant.repositories;


import ma.esi.etudiant.entites.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable);
    Page<Etudiant> findByNomContains(String keyword, Pageable pageable);
    Page<Etudiant> findByPrenomContainsAndNomContains(String keywordPrenom,String keywordNom, Pageable pageable);
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);

}
