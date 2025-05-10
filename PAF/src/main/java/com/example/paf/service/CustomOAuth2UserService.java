package com.example.paf.service;

import com.example.paf.model.User;
import com.example.paf.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service

public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();
        String providerId = oAuth2User.getAttribute("sub");
        String provider = userRequest.getClientRegistration().getRegistrationId();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String pictureUrl = oAuth2User.getAttribute("picture");

        // Save or update user in the database
        saveOrUpdateUser(provider, providerId, name, email, pictureUrl);

        return oAuth2User;
    }
    private void saveOrUpdateUser(String provider, String providerId, String name, String email, String imageUrl) {
        Optional<User> userOptional = userRepo.findByProviderAndProviderId(provider, providerId);

        if (userOptional.isPresent()) {
            // Update existing user
            User existingUser = userOptional.get();
            existingUser.setName(name);
            existingUser.setEmail(email);
            existingUser.setImageUrl(imageUrl);
            userRepo.save(existingUser);
        } else {
            // Create new user
            User newUser = new User(name, email, imageUrl, providerId, provider);
            userRepo.save(newUser);
        }
    }
}
