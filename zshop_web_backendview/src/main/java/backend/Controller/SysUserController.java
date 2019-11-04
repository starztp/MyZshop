package backend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {

    @RequestMapping("/login")
    public String login(){
        return "main";
    }
}
