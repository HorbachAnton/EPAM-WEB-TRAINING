package by.tc.task01.entity;

import java.util.ArrayList;
import java.util.List;

public class FindedProduct {

    private List<String> finded;

    public FindedProduct() {
	finded = new ArrayList<String>();
    }

    public FindedProduct(List<String> finded) {
	this.finded = finded;
    }

    public FindedProduct(FindedProduct findedPro) {
	this.finded = findedPro.finded;
    }

    public List<String> getFinded() {
	return finded;
    }

    public void setFinded(List<String> finded) {
	this.finded = finded;
    }

    public void add(String str) {
	finded.add(str);
    }

}
