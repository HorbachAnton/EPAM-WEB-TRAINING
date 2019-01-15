package by.tc.task01.entity.criteria;

public final class SearchCriteria {

    public enum Oven {
	POWER_CONSUMPTION("POWER_CONSUMPTION"), WEIGHT("WEIGHT"), CAPACITY("CAPACITY"), DEPTH("DEPTH"),
	HEIGHT("HEIGHT"), WIDTH("WIDTH");

	private final String name;

	Oven(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    public enum Laptop {
	BATTERY_CAPACITY("BATTERY_CAPACITY"), OS("OS"), MEMORY_ROM("MEMORY_ROM"), SYSTEM_MEMORY("SYSTEM_MEMORY"),
	CPU("CPU"), DISPLAY_INCHS("DISPLAY_INCHS");

	private final String name;

	Laptop(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    public enum Refrigerator {
	POWER_CONSUMPTION("POWER_CONSUMPTION"), WEIGHT("WEIGHT"), FREEZER_CAPACITY("FREEZER_CAPACITY"),
	OVERALL_CAPACITY("OVERALL_CAPACITY"), HEIGHT("HEIGHT"), WIDTH("WIDTH");

	private final String name;

	Refrigerator(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    public enum VacuumCleaner {
	POWER_CONSUMPTION("POWER_CONSUMPTION"), FILTER_TYPE("FILTER_TYPE"), BAG_TYPE("BAG_TYPE"),
	WAND_TYPE("WAND_TYPE"), MOTOR_SPEED_REGULATION("MOTOR_SPEED_REGULATION"), CLEANING_WIDTH("CLEANING_WIDTH");

	private final String name;

	VacuumCleaner(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    public enum TabletPC {
	BATTERY_CAPACITY("BATTERY_CAPACITY"), DISPLAY_INCHES("DISPLAY_INCHES"), MEMORY_ROM("MEMORY_ROM"),
	FLASH_MEMORY_CAPACITY("FLASH_MEMORY_CAPACITY"), COLOR("COLOR");

	private final String name;

	TabletPC(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    public enum Speakers {
	POWER_CONSUMPTION("POWER_CONSUMPTION"), NUMBER_OF_SPEAKERS("NUMBER_OF_SPEAKERS"),
	FREQUENCY_RANGE("FREQUENCY_RANGE"), CORD_LENGTH("CORD_LENGTH");

	private final String name;

	Speakers(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
    }

    private SearchCriteria() {
    }
}
