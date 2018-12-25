package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria<E> {

    private Map<E, Object> criteria = new HashMap<E, Object>();

    public void add(E searchCriteria, Object value) {
	criteria.put(searchCriteria, value);
    }

    public Set<Map.Entry<E, Object>> getEntry() {
	return criteria.entrySet();
    }

    public void clear() {
	criteria.clear();
    }

}
