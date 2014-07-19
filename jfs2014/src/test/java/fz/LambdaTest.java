package fz;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LambdaTest {

	@Test
	public void test() {
		List<String> list = Arrays.asList("a", "b", "c", "a", "");
		System.err.println(list.stream().distinct().allMatch(a -> !a.isEmpty()));
	}
}
