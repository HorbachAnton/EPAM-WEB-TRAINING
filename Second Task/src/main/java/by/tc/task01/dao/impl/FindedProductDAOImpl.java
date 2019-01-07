package by.tc.task01.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import by.tc.task01.dao.FindedProductDAO;
import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;

public class FindedProductDAOImpl implements FindedProductDAO {

    private final static Path DEFAULT_PATH = Paths.get("src/main/resources/appliances_db.txt");

    public <E> FindedProduct find(Criteria<E> criteria) {
	FindedProduct findedPro = new FindedProduct();
	try {
	    Set<Map.Entry<E, Object>> set = criteria.getEntry();
	    if (set.size() == 1) {
		findForOneCriteria(set, findedPro);
	    } else if (set.size() > 1) {
		findForManyCriteria(set, findedPro);
	    } else {
		System.out.println("else");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return findedPro;
    }

    private <E> void findForOneCriteria(Set<Map.Entry<E, Object>> set, FindedProduct findedPro) throws IOException {
	Iterator<Map.Entry<E, Object>> iterator = set.iterator();
	Map.Entry<E, Object> entry = iterator.next();
	String[] finded = find(entry.getKey(), entry.getValue());
	checkFindedEmpty(finded, findedPro);
    }

    private <E> void findForManyCriteria(Set<Map.Entry<E, Object>> set, FindedProduct findedPro) throws IOException {
	Iterator<Map.Entry<E, Object>> iterator = set.iterator();
	Map.Entry<E, Object> entry = iterator.next();
	String[] finded = find(entry.getKey(), entry.getValue());
	while (iterator.hasNext()) {
	    entry = iterator.next();
	    String key = entry.getKey().toString();
	    String value = entry.getValue().toString().toLowerCase();
	    finded = Arrays.stream(finded)
		    .filter((s) -> s.contains(key + "=" + value))
		    .toArray(String[]::new);
	}
	checkFindedEmpty(finded, findedPro);

    }

    private <E> String[] find(E sendKey, Object sendValue) throws IOException {
	String nameClass = sendKey.getClass().getSimpleName();
	String key = sendKey.toString();
	String value = sendValue.toString().toLowerCase();
	String[] date = Files.lines(DEFAULT_PATH).filter((s) -> s.matches("^" + nameClass
		+ "\\s*:[(\\s*\\w*\\=\\d*\\,)]*" + key + "=" + value + "\\,*[(\\s*\\w*\\=\\d*(\\.|\\,|\\;))]*"))
		.toArray(String[]::new);
	return date;
    }

    private void checkFindedEmpty(String[] finded, FindedProduct findedPro) {
	if (finded.length == 0) {
	    findedPro.add("");
	} else {
	    for (String find : finded) {
		findedPro.add(find);
	    }
	}
    }

}
