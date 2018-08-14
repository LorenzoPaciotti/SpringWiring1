package soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.contrib.java.lang.system.SystemOutRule;



@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = SoundSystemConfig.class)//UTILIZZA CONFIG JAVA IN QUESTA CLASSE
@ContextConfiguration("SoundSystemConfig.xml")//UTILIZZA CONFIG XML SPECIFICATA PER I TEST, ALTERNATIVO A CFG JAVA
public class SoundsystemApplicationTests {

	/* questa rule di junit serve per confrontare l'output console con il test*/
	@Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private CompactDisc cd;
	
	@Autowired//istanzia una classe che implementi MediaPlayer e che abbia un wiring (automatico o manuale) e la assegna
	private MediaPlayer player;
	
	@Test
	public void contextLoads() {
		System.out.println("test -- contextloaded");
	}

	@Test
	public void controlloNull() {
		assertNotNull(cd);
		assertNotNull(player);
	}

	@Test
	public void play() {
		player.play();
		assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band" + " by The Beatles\n", log.getLog());
	}

}



/*
 * the @Context-
Configuration annotation tells it to load its configuration from the CDPlayerConfig
class. Because that configuration class includes @ComponentScan , the resulting applica-
tion context should include the CompactDisc bean.
 */
/*in addition to injecting CompactDisc , you’re injecting the CDPlayer bean into
the test’s player member variable (as the more generic MediaPlayer type). In the
play() test method, you call the play() method on the CDPlayer and assert that it
does what you expect.*/
