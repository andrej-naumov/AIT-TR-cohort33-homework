package basic.naumov.lesson55.fashion;

import java.util.*;

public class FashionCatalog {
    private EnumMap<FashionCategory, Set<FashionItem>> каталог = new EnumMap<>(FashionCategory.class);

    // Добавление модных товаров в каталог
    public void добавитьМодныйТовар(FashionItem товар) {
        FashionCategory категория = товар.getКатегория();
        if (!каталог.containsKey(категория)) {
            каталог.put(категория, new HashSet<>());
        }
        каталог.get(категория).add(товар);
    }
    public Set<FashionItem> получитьТоварыПоКатегории(FashionCategory fashionCategory) {
        return каталог.get(fashionCategory);
    }

    public List<FashionItem> получитьТоварыПоСезону(Season сезон) {
        List<FashionItem> товарыПоСезону = new ArrayList<>();
        for (Map.Entry<FashionCategory, Set<FashionItem>> entry : каталог.entrySet()) {
            // FashionCategory fashionCategory = entry.getKey();
            Set<FashionItem> товары = entry.getValue();
            for (FashionItem товар : товары) {
                if(товар.getСезонность().contains(сезон)){
                    товарыПоСезону.add(товар);
                }
            }
        }
        return товарыПоСезону;
    }
}
