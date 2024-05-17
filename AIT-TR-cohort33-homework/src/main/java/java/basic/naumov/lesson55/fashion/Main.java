package java.basic.naumov.lesson55.fashion;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        FashionCatalog каталогМоды = new FashionCatalog();

        // Пример добавления товаров в каталог
        FashionItem товар1 = new FashionItem("Платье", 59.99, FashionCategory.ОДЕЖДА, EnumSet.of(Season.ЛЕТО, Season.ВЕСНА));
        FashionItem товар2 = new FashionItem("Кроссовки", 79.99, FashionCategory.ОБУВЬ, EnumSet.of(Season.ЛЕТО, Season.ВЕСНА));
        FashionItem товар3 = new FashionItem("Солнцезащитные очки", 29.99, FashionCategory.АКСЕССУАРЫ, EnumSet.of(Season.ЛЕТО));

        каталогМоды.добавитьМодныйТовар(товар1);
        каталогМоды.добавитьМодныйТовар(товар2);
        каталогМоды.добавитьМодныйТовар(товар3);

        // Пример вывода товаров для определенного сезона
        // Mожно выполнить операции с каждым товаром, соответствующим сезону "ЛЕТО"
        Season season = Season.ЛЕТО;
        System.out.println(" --- Tовары для сезона " + season.name());
        for(FashionItem fashionItem : каталогМоды.получитьТоварыПоСезону(season)){
            System.out.println("Категория: " + fashionItem.getКатегория() +
                    ", Название: " + fashionItem.getНазвание() +
                    ", Цена: " + fashionItem.getЦена());
        }

        System.out.println(" ----- ");

        // Пример вывода товаров для определенной категории
        // Mожно выполнить операции с категорией одежда
        FashionCategory fashionCategory = FashionCategory.ОДЕЖДА;
        System.out.println(" --- Товары категории " + fashionCategory);
        for (FashionItem fashionItem : каталогМоды.получитьТоварыПоКатегории(FashionCategory.ОДЕЖДА)     ) {
            System.out.println("Категория: " + fashionItem.getКатегория() +
                    ", Название: " + fashionItem.getНазвание() +
                    ", Цена: " + fashionItem.getЦена());
        }

    }
}
