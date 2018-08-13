package soundsystem;

import org.springframework.stereotype.Component;

/*
 * What you should take note of is that SgtPeppers is annotated with
@Component . This simple annotation identifies this class as a component class and
serves as a clue to Spring that a bean should be created for the class. There’s no need
to explicitly configure a SgtPeppers bean; Spring will do it for you because this class is
annotated with @Component .
 * 
 */


@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
