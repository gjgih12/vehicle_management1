package com.gj.utils;

/**
 * Created by ace on 2017/8/11.
 */
public class Sha256PasswordEncoder /*implements PasswordEncoder*/ {

    /*@Override
    public String encode(CharSequence charSequence) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte digest[] = md.digest(charSequence.toString().getBytes("UTF-8"));
            return new String(Base64.encodeBase64(digest));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return this.encode(charSequence.toString()).equals(s);
    }*/
}
