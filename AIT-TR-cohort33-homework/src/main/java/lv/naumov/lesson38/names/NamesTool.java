package lv.naumov.lesson38.names;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

public class NamesTool {

	static List<String> generateNames(Locale locale, int count){
		Faker faker = Faker.instance(locale);
		List<String> names = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			names.add(faker.name().firstName());
		}
		
		return names;
	}
}
