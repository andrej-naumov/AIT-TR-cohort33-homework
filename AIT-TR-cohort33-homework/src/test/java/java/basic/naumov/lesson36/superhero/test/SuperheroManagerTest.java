package java.basic.naumov.lesson36.superhero.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import basic.naumov.lesson36.superhero.Superhero;
import basic.naumov.lesson36.superhero.SuperheroManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuperheroManager.class) 
public class SuperheroManagerTest {

	private SuperheroManager superheroManager;

	@BeforeEach
	public void setUp() {
		superheroManager = new SuperheroManager();
	}

	@Test
	public void testAddSuperhero() {
		Superhero superhero = new Superhero("Superman", 9, 35);
		assertTrue(superheroManager.addSuperhero(superhero));
	}

	@Test
	public void testAddSuperheroWithDuplicateName() {
		Superhero superhero1 = new Superhero("Batman", 7, 40);
		Superhero superhero2 = new Superhero("Batman", 8, 38);
		assertTrue(superheroManager.addSuperhero(superhero1));
		assertFalse(superheroManager.addSuperhero(superhero2));
	}

	@Test
	public void testRemoveSuperhero() {
		Superhero superhero = new Superhero("Wonder Woman", 8, 30);
		superheroManager.addSuperhero(superhero);
		assertTrue(superheroManager.removeSuperhero("Wonder Woman"));
	}

	@Test
	public void testRemoveNonexistentSuperhero() {
		assertFalse(superheroManager.removeSuperhero("Flash"));
	}

	@Test
	public void testGetSuperhero() {
		Superhero superhero = new Superhero("Aquaman", 6, 45);
		superheroManager.addSuperhero(superhero);
		Superhero retrievedSuperhero = superheroManager.getSuperhero("Aquaman");
		assertNotNull(retrievedSuperhero);
		assertEquals(superhero, retrievedSuperhero);
	}

	@Test
	public void testGetNonexistentSuperhero() {
		assertNull(superheroManager.getSuperhero("Green Lantern"));
	}

	@Test
	public void testGetAllSuperheroes() {
		Superhero superhero1 = new Superhero("Flash", 5, 28);
		Superhero superhero2 = new Superhero("Green Lantern", 7, 33);
		superheroManager.addSuperhero(superhero1);
		superheroManager.addSuperhero(superhero2);
		List<Superhero> allSuperheroes = superheroManager.getAllSuperheroes();
		assertEquals(2, allSuperheroes.size());
	}

	@Test
	public void testUpdateSuperhero() {
		Superhero oldSuperhero = new Superhero("Hulk", 9, 40);
		Superhero newSuperhero = new Superhero("Thor", 8, 35);
		superheroManager.addSuperhero(oldSuperhero);
		superheroManager.updateSuperhero("Hulk", newSuperhero);
		assertEquals(newSuperhero, superheroManager.getSuperhero("Thor"));
	}



	@Test
	public void testPrivateContainsSuperhero() throws Exception {
	    // инстанцируем SuperheroManager
	    SuperheroManager manager = new SuperheroManager();
	    Superhero superhero = new Superhero("Tomb Rider", 9, 25);
	    manager.addSuperhero(superhero);

	    // получаем приватный метод
	    Method containsSuperheroPrivateMethod = SuperheroManager.class.getDeclaredMethod("containsSuperhero", String.class);

	    // меняем доступность метода
	    containsSuperheroPrivateMethod.setAccessible(true);

	    // теперь можем вызывать приватный метод
	    boolean result = (boolean) containsSuperheroPrivateMethod.invoke(manager, "Superman");

	    // У нас нет Томб Райдера, у нас Супермэн
	    assertFalse(result);
	    
	    // добавляем супермэна
	    Superhero superhero2 = new Superhero("Superman", 9, 40);
	    manager.addSuperhero(superhero2);
	    boolean result2 = (boolean) containsSuperheroPrivateMethod.invoke(manager, "Superman");
	    assertTrue(result2);
	    
	    
	    
	}
}
