package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
	private CompactDisc cd;

	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	//non funziona
	/*@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
	return new CDPlayer(compactDisc);
	}*/

	@Override
	public void play() {
		cd.play();
	}

}

/*
 * autowiring is a means of letting Spring automatically satisfy a bean’s
 * dependencies by finding other beans in the application context that are a
 * match to the bean’s needs. To indicate that autowiring should be performed,
 * you can use Spring’s @Autowired annotation. For example, consider the
 * CDPlayer class in the following listing. Its constructor is annotated
 * with @Autowired , indicating that when Spring creates the CDPlayer bean, it
 * should instantiate it via that constructor and pass in a bean that is
 * assignable to CompactDisc .
 */