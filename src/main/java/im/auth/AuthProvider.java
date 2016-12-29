package im.auth;

/**
 * Created by tianxing on 16/12/29.
 */
public class AuthProvider {


    public void authenticate(String username, String password) throws UnauthorizedException {

        if (username == null || password == null){
            throw new UnauthorizedException();
        }
        username = username.trim().toLowerCase();

    }
}
