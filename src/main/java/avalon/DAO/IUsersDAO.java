package avalon.DAO;

        import avalon.Models.Users;
        import org.springframework.data.jpa.repository.JpaRepository;
        import java.util.List;

public interface IUsersDAO extends JpaRepository<Users, Long> {
    //List<Users> getUsersInGroup();
}
