package ma.enset.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepositories patientRepositories;
   @GetMapping(path = "/user/index")
    public java.lang.String patients(Model model,
                                     @RequestParam(name = "page",defaultValue = "0") int page ,
                                     @RequestParam(name = "size" ,defaultValue = "5") int size,
                                     @RequestParam(name = "keyword" ,defaultValue = "") String keyword)
    {

       Page<Patient> pagePatients=patientRepositories.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
       return  "patients";
    }
    @GetMapping("/admin/delete")
   public String delete(Long id,String keyword,int page)
   {
       patientRepositories.deleteById(id);
       return "redirect:/user/index?page="+page+"&keyword="+keyword;
   }
   @GetMapping("/")
    public String home()
   {
       return "home";
   }

   @GetMapping("/user/patients")
   @ResponseBody
   public List<Patient>lisPatients()
   {
       return patientRepositories.findAll();
   }

   @GetMapping("/admin/formPatients")
    public String formPatients(Model model)
   {
       model.addAttribute("patient",new Patient());
       return "formPatients";
   }
   @PostMapping(path = "/admin/save")
   public String save(Model model , @Valid Patient patient , BindingResult bindingResult ,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keyword)
   {
       if (bindingResult.hasErrors())
           return "formPatients";
       patientRepositories.save(patient);
       return "redirect:/user/index?page="+page+"&keyword="+keyword;
   }
    @GetMapping("/admin/editPatient")
    public String editPatients(Model model ,long id ,String keyword,int page)
    {
       Patient patient=patientRepositories.findById(id).orElse(null);
       if (patient==null)
           throw new RuntimeException("patient introuvable");
       model.addAttribute("patient",patient);
       model.addAttribute("page",page);
       model.addAttribute("keyword",keyword);
        return "editPatient";
    }



}
