package ma.esi.etudiant.security.service;


import ma.esi.etudiant.security.entities.AppRole;
import ma.esi.etudiant.security.entities.AppUser;

public interface ServiceSecurity {
    AppUser saveNewUser(String username, String password, String verifyPassword);
    AppRole saveNewRole(String rolename, String Desciption);

    void addRoleToUser(String username,String rolename);
    void delRoleFromUser(String username,String rolename);

    AppUser loadByUserName(String username);
    AppRole loadByRoleName(String rolename);
}
