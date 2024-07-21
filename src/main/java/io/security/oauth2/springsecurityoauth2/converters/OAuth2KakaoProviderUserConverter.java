package io.security.oauth2.springsecurityoauth2.converters;

import io.security.oauth2.springsecurityoauth2.enums.OAuth2Config;
import io.security.oauth2.springsecurityoauth2.model.ProviderUser;
import io.security.oauth2.springsecurityoauth2.model.social.KakaoUser;
import io.security.oauth2.springsecurityoauth2.model.social.NaverUser;
import io.security.oauth2.springsecurityoauth2.util.OAuth2Utils;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class OAuth2KakaoProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser convert(ProviderUserRequest providerUserRequest) {

        if (!providerUserRequest.clientRegistration().getRegistrationId().equals(OAuth2Config.SocialType.KAKAO.getSocialName())) {
            return null;
        }

        if (providerUserRequest.oAuth2User() instanceof OidcUser) {
            return null;
        }

        return new KakaoUser(OAuth2Utils.getOtherAttributes(
                providerUserRequest.oAuth2User(), "kakao_account", "profile"),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
