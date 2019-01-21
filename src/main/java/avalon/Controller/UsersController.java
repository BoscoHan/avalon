package avalon.Controller;


import avalon.DAO.UsersDAO;
import avalon.Models.Users;
import avalon.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    private UsersDAO usersDAO;

    @GetMapping("/users")
    public Page<Users> getUsers(Pageable pageable) {
        return usersDAO.findAll(pageable);
    }

    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users users) {
        return usersDAO.save(users);
    }

    @PutMapping("/users/{userID}")
    public Users updateUser(@PathVariable Long userID,
                                   @Valid @RequestBody Users userRequest) {
        return usersDAO.findById(userID)
                .map(users -> {
                    users.setDisplayName(userRequest.getDisplayName());
                    users.setEmail(userRequest.getEmail());
                    return usersDAO.save(users);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userID));
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userID) {
        return usersDAO.findById(userID)
                .map(users -> {
                    usersDAO.delete(users);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userID));
    }
}
