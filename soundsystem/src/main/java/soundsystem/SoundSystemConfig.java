package soundsystem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Or, if you’d rather it be clear that you’re setting the base package, you can do so with
the basePackages attribute
You probably noticed that basePackages is plural. If you’re wondering whether that
means you can specify multiple base packages, you can. All you need to do is set
basePackages to an array of packages to be scanned.
The one thing about setting the base packages as shown here is that they’re expressed
as String values. That’s fine, I suppose, but it’s not very type-safe. If you were to refac-
tor the package names, the specified base packages would be wrong.
Rather than specify the packages as simple String values, @ComponentScan also
offers you the option of specifying them via classes or interfaces that are in the
packages.
As you can see, the basePackages attribute has been replaced with basePackage-
Classes . And instead of identifying the packages with String names, the array given
to basePackageClasses includes classes. Whatever packages those classes are in will
be used as the base package for component scanning.
Although I’ve specified component classes for basePackageClasses , you might
consider creating an empty marker interface in the packages to be scanned. With a
marker interface, you can still have a refactor-friendly reference to an interface, but
without references to any actual application code (that could later be refactored out
of the package you intended to component-scan).
 */

@Configuration
@ComponentScan(basePackageClasses={CompactDisc.class})
public class SoundSystemConfig {

}
