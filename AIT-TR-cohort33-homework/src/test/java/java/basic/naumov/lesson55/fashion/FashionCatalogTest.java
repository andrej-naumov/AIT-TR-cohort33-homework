package java.basic.naumov.lesson55.fashion;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class FashionCatalogTest {

    @Test
    void добавитьМодныйТовар_ПроверкаДобавления() {
        FashionCatalog каталогМоды = new FashionCatalog();

        FashionItem товар1 = new FashionItem("Платье", 59.99, FashionCategory.ОДЕЖДА, EnumSet.of(Season.ЛЕТО, Season.ВЕСНА));
        FashionItem товар2 = new FashionItem("Свитер", 49.99, FashionCategory.ОДЕЖДА, EnumSet.of(Season.ОСЕНЬ));

        каталогМоды.добавитьМодныйТовар(товар1);
        каталогМоды.добавитьМодныйТовар(товар2);

        assertEquals(2, каталогМоды.получитьТоварыПоКатегории(FashionCategory.ОДЕЖДА).size());
    }

    @Test
    void вывестиТоварыПоСезону_ПроверкаВывода() {
        FashionCatalog каталогМоды = new FashionCatalog();

        FashionItem товар1 = new FashionItem("Платье", 59.99, FashionCategory.ОДЕЖДА, EnumSet.of(Season.ЛЕТО, Season.ВЕСНА));
        FashionItem товар2 = new FashionItem("Свитер", 49.99, FashionCategory.ОДЕЖДА, EnumSet.of(Season.ОСЕНЬ));
        FashionItem товар3 = new FashionItem("Кроссовки", 79.99, FashionCategory.ОБУВЬ, EnumSet.of(Season.ЛЕТО));

        каталогМоды.добавитьМодныйТовар(товар1);
        каталогМоды.добавитьМодныйТовар(товар2);
        каталогМоды.добавитьМодныйТовар(товар3);

        assertEquals(2, каталогМоды.получитьТоварыПоСезону(Season.ЛЕТО).size());
    }
}
