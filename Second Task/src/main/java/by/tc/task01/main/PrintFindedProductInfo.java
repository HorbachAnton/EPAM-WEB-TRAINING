package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.FindedProduct;

public class PrintFindedProductInfo {

    public static void print(FindedProduct product) {
	List<String> finded = product.getFinded();
	for (String elem : finded) {
	    if (elem.equals("not found")) {
		System.out.println("The file does not contain such elements.");
	    } else {
		System.out.println(elem);
	    }
	}
    }

    // you may add your own code here

}
