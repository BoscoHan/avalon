package avalon.Controller;

import avalon.DAO.UsersDAO;
import avalon.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersDAO usersDAO;

    @GetMapping("/users")
    public Page<Users> getUserList(Pageable pageable){
        return usersDAO.findAll(pageable);
    }
}
