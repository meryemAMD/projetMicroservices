package org.sid.security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="SECRET_2019@";
    public static final long EXPIRATION=10*24*3600*10;// expires dans 10 jours
}
