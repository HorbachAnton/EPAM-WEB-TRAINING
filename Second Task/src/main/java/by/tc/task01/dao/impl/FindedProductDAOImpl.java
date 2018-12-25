package by.tc.task01.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import by.tc.task01.dao.FindedProductDAO;
import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;

public class FindedProductDAOImpl implements FindedProductDAO {

    private final static Path DEFAULT_PATH = Paths.get("src/main/resources/appliances_db.txt");

    public <E> FindedProduct find(Criteria<E> criteria) {
	FindedProduct findedPro = new FindedProduct();
	Set<Map.Entry<E, Object>> set = criteria.getEntry();
	for (Map.Entry<E, Object> me : set) {
	    try {
		String[] finded = find(me.getKey(), me.getValue());
		if (finded.length == 0) {
		    findedPro.add("not found");
		} else {
		    for (String elem : finded) {
			findedPro.add(elem);
		    }
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return findedPro;
    }

    private <E> String[] find(E key, Object value) throws IOException {
	String[] date = Files.lines(DEFAULT_PATH).filter((s) -> s.contains(key.getClass().getSimpleName().toString()))
		.filter((s) -> s.contains(key.toString() + "=" + value.toString())).toArray(String[]::new);
	return date;
    }

    // you may add your own code here

}

//you may add your own new classes