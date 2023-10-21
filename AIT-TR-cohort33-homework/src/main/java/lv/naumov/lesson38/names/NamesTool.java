package lv.naumov.lesson38.names;

import java.util.Locale;

import com.github.javafaker.Faker;

public class NamesTool {

	static String[] generateNames(Locale locale, int count){
		Faker faker = Faker.instance(locale);
		String[] names = new String[count];
		for (int i = 0; i < count; i++) {
			names[i]= faker.name().firstName();
		}
		
		return names;
	}
}
