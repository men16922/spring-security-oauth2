package io.security.oauth2.springsecurityoauth2.converters;

public interface ProviderUserConverter<T, R> {

    R convert(T t);
}
