package io.security.oauth2.springsecurityoauth2.converters;


import io.security.oauth2.springsecurityoauth2.model.FormUser;
import io.security.oauth2.springsecurityoauth2.model.ProviderUser;
import io.security.oauth2.springsecurityoauth2.model.User;

public final class UserDetailsProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {

    @Override
    public ProviderUser convert(ProviderUserRequest providerUserRequest) {

        if (providerUserRequest.user() == null) {
            return null;
        }

        User user = providerUserRequest.user();
        return FormUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .email(user.getEmail())
                .provider("none")
                .build();
    }
}