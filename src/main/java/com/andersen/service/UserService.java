package com.andersen.service;

import com.andersen.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {

//        User user = userRepository.findOne("user");
//        user.setPassword(new BCryptPasswordEncoder().encode("user"));
//        userRepository.save(user);

//        User admin = userRepository.findOne("admin");
//        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
//        userRepository.save(admin);

//        if (userRepository.findOne("user") == null) {
//            userRepository.save(User.builder()
//                    .username("user")
//                    .password("user")
//                    .authorities(Collections.singletonList(UserRole.ROLE_USER))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build());
//        }
//        if (userRepository.findOne("admin") == null) {
//            userRepository.save(User.builder()
//                    .username("admin")
//                    .password("admin")
//                    .authorities(Collections.singletonList(UserRole.ROLE_ADMIN))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build());
//        }
//        System.out.println(userRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findOne(username);
    }
}
