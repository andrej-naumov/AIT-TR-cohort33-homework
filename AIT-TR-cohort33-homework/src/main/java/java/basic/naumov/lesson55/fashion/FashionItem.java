package java.basic.naumov.lesson55.fashion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;

// Класс модного товара
@Setter
@Getter
@AllArgsConstructor
public class FashionItem {
    private String название;
    private double цена;
    private FashionCategory категория;
    private EnumSet<Season> сезонность;
}
