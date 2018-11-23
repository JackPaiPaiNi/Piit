package com.ey.piit.test.sdo.deliver;

import org.junit.Test;

import com.ey.piit.test.core.BaseTest;

public class DeliverControllerTest extends BaseTest {

	@Test
	public void pushSAP() throws Exception {
		toDoPost("/deliver/deliver/pushSAP", "id:3C0B725988546B87E0530200007F971F,sjc:20160922172100741387,chdh:SA16090047");
	}

}
