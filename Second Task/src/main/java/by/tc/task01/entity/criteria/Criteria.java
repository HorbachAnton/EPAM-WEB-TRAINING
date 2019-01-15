package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria<E> {

    private Map<E, Object> criterias = new HashMap<>();

    public void add(E searchCriteria, Object value) {
	criterias.put(searchCriteria, value);
    }

    public Set<Map.Entry<E, Object>> getEntry() {
	return criterias.entrySet();
    }

    public void clear() {
	criterias.clear();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((criterias == null) ? 0 : criterias.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Criteria<?> other = (Criteria<?>) obj;
	if (criterias == null) {
	    if (other.criterias != null) {
		return false;
	    }
	} else if (!criterias.equals(other.criterias))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Criteria [criterias=" + criterias + "]";
    }

}
