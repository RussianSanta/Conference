//package ru.russun.conference.service.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import org.springframework.stereotype.Component;
//import ru.russun.conference.dto.UserDto;
//import ru.russun.conference.entity.Users;
//import ru.russun.conference.repos.UserRepos;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class ConferenceUserDetailService implements UserDetailsService {
//    @Autowired
//    private UserRepos userRepos;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepos.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole().getRoleName()));
//
//        return new User(user.getUsername(), user.getPassword(), authorities);
//    }
//}
