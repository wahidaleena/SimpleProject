package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	public static Faker faker;

	public static String getFirstName() {
		
		faker=new Faker(new Locale("en-IND"));
		return faker.name().firstName();
		
	}
	
	public static String getLastName() {
		
		faker=new Faker(new Locale("en-IND"));
		return faker.name().lastName();
		
		
	}
	public static String getPassword() {
		Faker faker = new Faker();
		Random random = new Random();

		String upper = faker.lorem().characters(2).toUpperCase();
		String lower = faker.lorem().characters(4).toLowerCase();
		String digits = String.valueOf(100 + random.nextInt(900)); // 3-digit number
		String symbols = "!@#$%^&*";
		char special = symbols.charAt(random.nextInt(symbols.length()));

		String password = upper + lower + digits + special;
		System.out.println("Generated Password: " + password);
		return password;
	}
	public static String getEmail() {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomStringEmail = sb.toString() + "@gmail.com";
		System.out.println("Generated e-mail: "+randomStringEmail);
		return randomStringEmail;

	}
	public static String getDateOfBirth() {

		// for getting date in 'dd-mm-yyyy' format
		SimpleDateFormat simpledate = new SimpleDateFormat("MM/dd/yyyy");
		faker = new Faker();
		Date date = faker.date().birthday(18, 60);
		return simpledate.format(date);

	}
}
