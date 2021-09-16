package com.wildcodeschool.blog.service;

import com.wildcodeschool.blog.entity.ERole;
import com.wildcodeschool.blog.entity.Role;
import com.wildcodeschool.blog.entity.User;
import com.wildcodeschool.blog.payload.request.RegisterRequest;
import com.wildcodeschool.blog.repository.RoleRepository;
import com.wildcodeschool.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean register(RegisterRequest registerRequest) {

        /* je verifie que le mail n'est pas existant */
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            // je renvoie une erreur
            return false;
        }
        /* je verifie que le pseudo n'est pas existant */
        if (userRepository.existsByPseudo(registerRequest.getPseudo())) {
            // je renvoie une erreur
            return false;
        }
        /* si tout est ok, j'enregistre l'utilisateur */
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPseudo(registerRequest.getPseudo());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        // on crée une liste de roles vides
        Set<Role> roles = new HashSet<>();
        // on va chercher le role ROLE_USER qu'on met dans une variable
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé"));
        // on met ce role dans la liste vide
        roles.add(userRole);
        // on attribue la liste à l'user via le setRoles
        user.setRoles(roles);
                // je rajoute un role par default user
        userRepository.save(user);
        return true;
    }


}
