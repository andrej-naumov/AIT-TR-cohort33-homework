package lv.naumov.lesson36.superhero;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SuperheroManager {

	private List<Superhero> superheroes = new ArrayList<>();

	public boolean addSuperhero(Superhero superhero) {
		// Проверка на наличие супергероя с таким именем
		if (!containsSuperhero(superhero.getName())) {
			return superheroes.add(superhero);
		}
		return false;
	}

	public void updateSuperhero(String name, Superhero newSuperhero) {
		for (int i = 0; i < superheroes.size(); i++) {
			Superhero superhero = superheroes.get(i);
			if (superhero.getName().equals(name)) {
				superheroes.set(i, newSuperhero);
				return;
			}
		}
	}

	public boolean removeSuperhero(String name) {
		Superhero superheroToRemove = null;

		for (Superhero superhero : superheroes) {
			if (superhero.getName().equals(name)) {
				superheroToRemove = superhero;
				break;
			}
		}

		if (superheroToRemove != null) {
			return superheroes.remove(superheroToRemove);
		}

		return false;
	}

	public Superhero getSuperhero(String name) {
		for (Superhero superhero : superheroes) {
			if (superhero.getName().equals(name)) {
				return superhero;
			}
		}
		return null;
	}

	public List<Superhero> getAllSuperheroes() {
		return new ArrayList<>(superheroes);
	}

	private boolean containsSuperhero(String name) {
		for (Superhero superhero : superheroes) {
			if (superhero.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
