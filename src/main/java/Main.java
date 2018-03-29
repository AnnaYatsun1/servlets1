import models.Address;
import models.Auto;
import models.MusicTypes;
import models.User;
import services.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Alina", 28, "Lovelov");
        userService.saveUser(user);
        List<User> userList= new ArrayList<>();

        List<MusicTypes> musicTypes = (List<MusicTypes>) new MusicTypes("Pop");
        Auto role = new Auto("new User");
        role.setUser(user);
        user.addAuto(role);
        Address address = new Address("Kiev", "Kachalova");
        address.setUser(user);



//        Auto ford = new Auto("Ford", "black");
//        ford.setUser(user);
        //   user.addAuto(ford);
        //userService.updateUser(user);
    }
}
