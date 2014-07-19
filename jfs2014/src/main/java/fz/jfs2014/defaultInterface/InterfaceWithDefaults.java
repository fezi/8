package fz.jfs2014.defaultInterface;

public interface InterfaceWithDefaults {

	boolean op();

	default boolean opComplement() {
		return !op();
	}
}
