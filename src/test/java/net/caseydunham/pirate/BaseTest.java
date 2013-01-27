package net.caseydunham.pirate;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

}
