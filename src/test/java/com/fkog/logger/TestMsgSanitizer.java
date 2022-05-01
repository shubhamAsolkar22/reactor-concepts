package com.fkog.logger;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMsgSanitizer {
	@Test
	public void t1() {
		MsgSanitizer jsSanitizer = JsMsgSanitizer.getInstance();
		assertThat(jsSanitizer.sanitize("< script>")).isEqualTo("&lt; script&gt;");
	}
}
