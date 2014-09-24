/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author pablo.ferreira
 */
@Controller
public class HelloControler {
    @RequestMapping("/view")
 public ModelAndView hello() {
 		String message = "Welcome to Spring MVC 4.0!";
 		return new ModelAndView("view", "message", message);
 	}
}
