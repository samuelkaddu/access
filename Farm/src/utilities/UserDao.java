package utilities;

import java.io.Serializable;

import org.skife.jdbi.v2.Handle;

import com.neptunesoftware.supernova.util.security.encryption.Encrypter;
import com.neptunesoftwaregroup.main.MainClass;

@SuppressWarnings("serial")
public class UserDao implements Serializable {

	public String isAuthenticated(String username, String password) {
		try (Handle handle = MainClass.jdbi.open()) {
			String login_id = handle
					.createQuery("SELECT login_id FROM SYSUSER where   login_id=:LOGIN_ID and passwd=:PASSWD")
					.bind("LOGIN_ID", username.toUpperCase().trim())
					.bind("PASSWD", Encrypter.getEncrypter().encrypt(password).trim()).mapTo(String.class).first();

			return login_id != null ? login_id : "Login Failed. Invalid Credentials";
		} catch (Exception e) {
			XAPILogger.getLogger().error(e);
			return e.getLocalizedMessage();
		}
	}

}
