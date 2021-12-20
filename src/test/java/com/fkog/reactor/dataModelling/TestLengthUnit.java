package com.fkog.reactor.dataModelling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLengthUnit {

	@Test
	public void testMeterToMeterConversion() {
		Assertions.assertEquals(1, LengthUnit.METER.fromMeters(1));
		Assertions.assertEquals(1, LengthUnit.METER.toMeters(1));
	}

	@Test
	public void testMeterToInchConversion() {
		Assertions.assertEquals(1, LengthUnit.INCH.toMeters(39.3701));
		Assertions.assertEquals(0.0254, LengthUnit.INCH.toMeters(1));
	}
}
