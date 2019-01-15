package by.tc.task01.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tc.task01.dao.FindedProductDAO;
import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;

public class FindedProductDAOImpl implements FindedProductDAO {

    private static final Logger logger = LogManager.getLogger(FindedProductDAOImpl.class);
    private static final Path DEFAULT_CONFIG_PATH = Paths.get("config.txt");
    private static Path defaultPath;

    static {
	try {
	    Optional<String> pathOptional = Files.lines(DEFAULT_CONFIG_PATH)
		    .filter(s -> s.matches("DEFAULT_PATH =(.)*")).findFirst();
	    String path = pathOptional.get().replaceAll("DEFAULT_PATH = ", "");
	    defaultPath = Paths.get(path);
	} catch (IOException e) {
	    logger.info("Could not read the path to the appliances_db.txt file");
	}
    }

    public <E> FindedProduct find(Criteria<E> criteria) {
	FindedProduct findedPro = new FindedProduct();
	try {
	    Set<Map.Entry<E, Object>> set = criteria.getEntry();
	    if (set.size() == 1) {
		findForOneCriteria(set, findedPro);
	    } else if (set.size() > 1) {
		findForManyCriteria(set, findedPro);
	    }
	} catch (IOException e) {
	    logger.info("Could not find matching criteria.");
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
	    finded = Arrays.stream(finded).filter(s -> s.contains(key + "=" + value)).toArray(String[]::new);
	}
	checkFindedEmpty(finded, findedPro);

    }

    private <E> String[] find(E sendKey, Object sendValue) throws IOException {
	String nameClass = sendKey.getClass().getSimpleName();
	String key = sendKey.toString();
	String value = sendValue.toString().toLowerCase();
	String regex = "^" + nameClass + "\\s*:[(\\s*\\w*\\=\\d*\\,)]*" + key + "=" + value
		+ "\\,*[(\\s*\\w*\\=\\d*(\\.|\\,|\\;))]*";
	try (Stream<String> stream = Files.lines(defaultPath)) {
	    return stream.filter(s -> s.matches(regex)).toArray(String[]::new);
	}
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
