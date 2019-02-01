package by.horant.task3.resourcebundle;

import java.util.ListResourceBundle;

public class HeadTable_en_EN extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
	return contents;
    }

    static final Object[][] contents = { { "count.id", "Number" }, { "count.photo", "Photo" }, { "count.title", "Title" },
	    { "count.general_description", "General description" }, { "count.option", "Option" },
	    { "count.portion", "Portion" }, { "count.price", "Price" } };

}
