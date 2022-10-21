package pl.sebastian.zadanie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUpdateUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        if(!userRepository.existsById(userId)){
            throw new IllegalStateException("uzytkownik z id " + userId + " nie istnieje");
        }
        userRepository.deleteById(userId);
    }

    public void updateUser(Long userId, User userParams) {

        User updateUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User z id " + userId + " nie istnieje"));

        updateUser.setName(userParams.getName());
        updateUser.setSurname(userParams.getSurname());

        userRepository.save(updateUser);


    }
}
