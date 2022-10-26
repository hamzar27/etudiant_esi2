package ma.esi.etudiant.security.repositories;


import ma.esi.etudiant.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findAppUserByUserName(String username);
}
