package ma.esi.etudiant.web;


import lombok.AllArgsConstructor;
import ma.esi.etudiant.entites.Etudiant;
import ma.esi.etudiant.service.ServiceEtudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class EtudiantController {
    ServiceEtudiant service;

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping(path = "/index")
    public String etudiants(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Etudiant> etudiants = service.findByPrenomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants", etudiants.getContent());
        model.addAttribute("Pages", new int[etudiants.getTotalPages()]);
        model.addAttribute("pageCourant", page);
        model.addAttribute("keyword", keyword);
        return "etudiants";
    }

    /*
        @DeleteMapping("/admin/delete/{id}")
        public String supprimerEtudiant(@PathVariable("id") Long id) {
            service.deleteEtudiantById(id);
            return "redirect:/index";
        }
    */

    @GetMapping(path = "/admin/delete")
    public String deleteEtudiant(Long id) {
        service.deleteEtudiantById(id);
        return "redirect:/index";
    }

    @GetMapping(path = "/admin/add")
    public String newEtudiant(Model model) {
        model.addAttribute("etudiant",new Etudiant());
        return "add";
    }



    @PostMapping(path = "/admin/create")
    public String newAdd(Model model, @Valid Etudiant e, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  "add";
        }
        service.saveEtudiant(e);
        return "redirect:/index";
    }

    @PostMapping(path = "/admin/updateEtudiant")
    public String updateEtudiant(Model model, @Valid Etudiant e, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "modification";
        }
        service.saveEtudiant(e);
        return "redirect:/index";
    }

    @GetMapping(path = "/admin/update")
    public String update(Model model, Long id) {
        Etudiant e = service.findEtudiantById(id);
        model.addAttribute("etudiant",e);
        return "modification";
    }
}
