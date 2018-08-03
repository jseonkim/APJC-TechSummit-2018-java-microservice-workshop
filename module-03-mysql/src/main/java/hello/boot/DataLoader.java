package hello.boot;

import hello.model.Image;
import hello.model.User;
import hello.repository.ImageRepository;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private UserRepository userRepository;
    private ImageRepository imageRepository;
    
    @Autowired
    public void setProductRepository(UserRepository userRepository, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        // create users
        System.out.println("#### create users #######");
        User user1 = new User();
        user1.setName("Jeff Bar");
        user1.setEmail("bar@gmail.com");

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("John Bell");
        user2.setEmail("bell@gmail.com");

        userRepository.save(user2);
        
        // create images
        Integer user_id = user1.getId();
        
        Image img1 = new Image();
        img1.setUser_id(user_id);
        img1.setBucket("seon-sigapore");
        img1.setPrefix("/outout");
        img1.setFileName("hello.PNG");
        
        imageRepository.save(img1);
      
    }
}
