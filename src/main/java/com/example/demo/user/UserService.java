package com.example.demo.user;

import com.example.demo.auth.model.UserPrinciple;
import com.example.demo.user.exception.UserBadRequestException;
import com.example.demo.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public User fetchById(int id) {
        return this.userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User add(User newUser) {
        try {
            newUser.setUsername(newUser.getEmail());
            newUser.setPassword("$2y$12$Zs4df65f6AbpJdsX6Dzjl.HemOQrndd6YWdsT.jONKhJMJz.JGb/y");
            return this.userRepository.save(newUser);
        } catch (Exception exception) {
            throw new UserBadRequestException();
        }
    }

//    public com.btpn.chip.user.User update(int idUser, com.btpn.chip.user.User modifiedUser) {
//        com.btpn.chip.user.User foundUser = this.userRepository.findById(idUser)
//                .orElseThrow(UserNotFoundException::new);
//        foundUser.setName(modifiedUser.getName());
//        return this.userRepository.save(foundUser);
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User applicationUser = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));

        return UserPrinciple.build(applicationUser);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
