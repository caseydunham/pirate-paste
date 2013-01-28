package net.caseydunham.pirate;

import net.caseydunham.pirate.services.TestPasteService;
import net.caseydunham.pirate.stripes.TestHomeActionBean;
import net.caseydunham.pirate.stripes.TestViewPasteActionBean;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestPasteService.class, TestHomeActionBean.class, TestViewPasteActionBean.class})
public class AllTests {
}
