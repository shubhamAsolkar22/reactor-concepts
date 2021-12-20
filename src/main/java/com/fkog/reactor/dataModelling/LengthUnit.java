package com.fkog.reactor.dataModelling;

public enum LengthUnit {
	/**
	 * default unit is meter which is used as intermediate unit for conversion
	 */
	METER {
		@Override
		double fromMeters(double valueInMeters) {
			return round(valueInMeters);
		}

		@Override
		double toMeters(double value) {
			return round(value);
		}
	},
	INCH {
		@Override
		double fromMeters(double valueInMeters) {
			return round(valueInMeters*39.3701);
		}

		@Override
		double toMeters(double value) {
			return round(value/39.3701);
		}
	},
	FOOT {
		@Override
		double fromMeters(double valueInMeters) {
			return round(valueInMeters*3.280841666667);
		}

		@Override
		double toMeters(double value) {
			return round(value/3.280841666667);
		}
	};

	abstract double toMeters(double value);

	abstract double fromMeters(double valueInMeters);

	private static double round(double value) {
		return (double)Math.round(value * 100000d) / 100000d;
	}
}
