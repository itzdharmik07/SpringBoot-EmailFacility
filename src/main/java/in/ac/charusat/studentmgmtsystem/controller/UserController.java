package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.User;
import in.ac.charusat.studentmgmtsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

   @PostMapping("/register")
    public String adduser(@RequestBody User user){
       userRepository.save(user);
       SimpleMailMessage msg = new SimpleMailMessage();
       msg.setTo("20it011@charusat.edu.in", "20it023@charusat.edu.in","20it003@charusat.edu.in");

       msg.setSubject("Testing from Spring Boot");
       msg.setText("Hello World \n Spring Boot Email");

       javaMailSender.send(msg);

       return "Register Successfully";
   }

}
