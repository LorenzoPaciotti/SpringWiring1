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
@ContextConfiguration(classes=SoundSystemConfig.class)
public class SoundsystemApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("test -- contextloaded");
	}
	/*autowiring is a means of letting Spring automatically satisfy a bean’s
dependencies by finding other beans in the application context that are a match to
the bean’s needs. To indicate that autowiring should be performed, you can use
Spring’s @Autowired annotation.
For example, consider the CDPlayer class in the following listing. Its constructor
is annotated with @Autowired , indicating that when Spring creates the CDPlayer bean,
it should instantiate it via that constructor and pass in a bean that is assignable to
CompactDisc .*/
	@Autowired
	private CompactDisc cd;
	
	@Test
	public void cdShouldNotBeNull() {
	assertNotNull(cd);
	}

}
