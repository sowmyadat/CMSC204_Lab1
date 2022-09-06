import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook test1;
	GradeBook test2;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new GradeBook(5);
		test2 = new GradeBook(5);
		test1.addScore(65.0);
		test1.addScore(54.0);
		
		test2.addScore(57.0);
		test2.addScore(90.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
		test2 = null;
	}

	@Test
	void testAddScore() {
		assertEquals(2.0, test1.getScoresSize(), 0.01);
		assertEquals(2.0, test2.getScoresSize(), 0.01);
		
		assertTrue(test1.toString().equals("65.0 54.0 "));
		assertTrue(test2.toString().equals("57.0 90.0 "));
	}

	@Test
	void testSum() {
		assertEquals(119.0, test1.sum(), 0.0001);
		assertEquals(147.0, test2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(54.0, test1.minimum(), 0.0001);
		assertEquals(57.0, test2.minimum(), 0.0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(65.0, test1.finalScore(), 0.0001);
		assertEquals(90.0, test2.finalScore(), 0.0001);
	}

}
