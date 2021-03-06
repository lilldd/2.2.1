package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User usr;
      usr = new User("Ryan","Gosling","email@mail.com");
      usr.setCar(new Car("bmw",3));
      userService.add(usr);
      usr = new User("Zlodey","Vzlomov","email2@mail.com");
      usr.setCar(new Car("dodge",4));
      userService.add(usr);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Сar = "+user.getCar());
         System.out.println();
      }



      context.close();
   }
}
