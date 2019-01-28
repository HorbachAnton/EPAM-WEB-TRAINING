
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OptionalFood extends Food implements Serializable {

    private static final long serialVersionUID = 1138322508905213512L;
    public static final int VALUE_FOR_HASH_1 = 1;
    public static final int VALUE_FOR_HASH_2 = 31;

    private Set<FoodOption> foodOptions = new TreeSet<>();

    public OptionalFood() {
	super();
    }

    public OptionalFood(Set<FoodOption> foodOptions) {
	this();
	this.foodOptions = foodOptions;
    }

    public void addOption(FoodOption option) {
	foodOptions.add(option);
    }

    public FoodOption getOption(int index) {
	FoodOption option = null;
	Iterator<FoodOption> iterator = foodOptions.iterator();
	for (int i = 0; i < foodOptions.size(); i++) {
	    if (iterator.hasNext()) {
		FoodOption element = iterator.next();
		if (element.getOptionNumber() == index) {
		    option = element;
		}
	    }
	}
	return option;
    }

    public void removeOption(int index) {
	Iterator<FoodOption> iterator = foodOptions.iterator();
	for (int i = 0; i < foodOptions.size(); i++) {
	    if (iterator.hasNext()) {
		FoodOption element = iterator.next();
		if (element.getOptionNumber() == index) {
		    iterator.remove();
		}
	    }
	}

    }

    public int getOptionsAmount() {
	return foodOptions.size();
    }

    public Set<FoodOption> getFoodOptions() {
	return foodOptions;
    }

    public void setFoodOptions(Set<FoodOption> foodOptions) {
	this.foodOptions = foodOptions;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode()).append(foodOptions)
		.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj) {
	    return true;
	}

	if (!super.equals(obj)) {
	    return false;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	OptionalFood other = (OptionalFood) obj;

	return new EqualsBuilder().append(this.foodOptions, other.foodOptions).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).appendSuper(super.toString()).append("foodOptions", foodOptions).toString();
    }

}
