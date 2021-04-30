import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class Testnom {

	@Test
	void test() {

		try (Scanner Scan = new Scanner(System.in)) {
			final String NOM_REGEX = "^[A-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
			final Pattern NOM_PATTERN = Pattern.compile(NOM_REGEX);
			String nom;

			do {
				System.out.print("Saississez un nom (Xxx) : ");
				nom = Scan.next();
			} while (NOM_PATTERN.matcher(nom).matches() == false || nom.equalsIgnoreCase(""));

			String test = vendeur_client.testPrenom(nom);
			assertEquals("Sujeebun", test);
		}
	}

}
