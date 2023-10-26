package lv.naumov.lesson34.string.processor;



public class StringProcessorPlus extends StringProcessor {

	@Override
	public boolean isPalindrome(String str) {
		// Удаление пробелов и преобразование в нижний (нижний регистр лучше, так как не
		// все маленькие буквы имеют заглавные) регистр
		String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();

		int left = 0;
		int right = cleanedStr.length() - 1;

		while (left < right) {
			if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
				return false; // Если символы не совпадают, строка не палиндром
			}
			left++;
			right--;
		}

		return true; // Если символы совпали во всех парах, строка палиндром
	}

}