package by.horant.task3.resourcebundle;

import java.util.ListResourceBundle;

public class HeadTable_ru_RU extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
	return contents;
    }

    static final Object[][] contents = { { "count.id", "Номер" }, { "count.photo", "Фото" },
	    { "count.title", "Название" }, { "count.general_description", "Описание" }, { "count.option", "Опции" },
	    { "count.portion", "Порции" }, { "count.price", "Цены" } };

}
