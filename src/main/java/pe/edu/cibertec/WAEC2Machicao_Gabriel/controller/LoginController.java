package pe.edu.cibertec.WAEC2Machicao_Gabriel.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.dto.security.UsuarioSecurity;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")

public class LoginController {
    private IUsuarioService iUsuarioService;

    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/frmlogin";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "backoffice/auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        iUsuarioService.guardarUsuario(usuario);
        return "backoffice/auth/frmLogin";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UsuarioSecurity usuario = (UsuarioSecurity) userDetails;
        String nombre = usuario.getUsername();

        session.setAttribute("usuario", nombre);
        return "backoffice/auth/home";
    }

    @GetMapping("/changepassword")
    public String changePassword(HttpServletRequest request, Model model){
        model.addAttribute("mostrarMensaje", false);
        return "backoffice/auth/frmchangepassword";
    }

    @PostMapping("/changepassword")
    public String cambiarContraseña(@RequestParam("password") String password,
                                    @RequestParam("nuevo-password") String nuevoPassword,
                                    @RequestParam("usuario") String usuario,
                                    Model model) {
        if (!password.equals(nuevoPassword)) {
            model.addAttribute("mostrarMensaje", true);
            model.addAttribute("error", "Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
            return "backoffice/auth/frmchangepassword";
        }
        iUsuarioService.actualizarPassword(password, usuario);
        return "backoffice/auth/msgconfirmation";
    }
}