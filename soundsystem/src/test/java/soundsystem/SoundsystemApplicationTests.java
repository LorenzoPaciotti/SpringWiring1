package soundsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * the @Context-
Configuration annotation tells it to load its configuration from the CDPlayerConfig
class. Because that configuration class includes @ComponentScan , the resulting applica-
tion context should include the CompactDisc bean.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=CDPlayerConfig.class)
public class SoundsystemApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("test -- contextloaded");
	}
	
	@Autowired
	private CompactDisc cd;
	
	@Test
	public void cdShouldNotBeNull() {
	assertNotNull(cd);
	}

}
