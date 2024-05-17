package basic.naumov.lesson54.enumeration;

import java.util.HashMap;
import java.util.Map;

enum MusicGenre {
    POP {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    },
    ROCK {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    },
    JAZZ {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    },
    CLASSICAL {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    },
    ELECTRONIC {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    },
    HIPHOP {
        @Override
        public String getI18N(String languageCode) {
            return getTranslation(languageCode, this);
        }
    };

    private static final Map<String, Map<MusicGenre, String>> I18N_MAP = new HashMap<>();

    static {
        // Немецкий
        Map<MusicGenre, String> germanMap = new HashMap<>();
        germanMap.put(MusicGenre.POP, "Populäre und Mainstream-Musik");
        germanMap.put(MusicGenre.ROCK, "Gitarrenorientierte Musik mit starkem Rhythmus");
        germanMap.put(MusicGenre.JAZZ, "Improvisierte und gefühlvolle Musik");
        germanMap.put(MusicGenre.CLASSICAL, "Zeitlose und orchestrierte Musik");
        germanMap.put(MusicGenre.ELECTRONIC, "Musik, die mit elektronischen Geräten erstellt wird");
        germanMap.put(MusicGenre.HIPHOP, "Rhythmische und reimende Musik");
        I18N_MAP.put("de", germanMap);

        // Русский
        Map<MusicGenre, String> russianMap = new HashMap<>();
        russianMap.put(MusicGenre.POP, "Популярная и мейнстрим музыка");
        russianMap.put(MusicGenre.ROCK, "Музыка с гитарным аккомпанементом и сильным ритмом");
        russianMap.put(MusicGenre.JAZZ, "Импровизированная и душевная музыка");
        russianMap.put(MusicGenre.CLASSICAL, "Вечная и оркестровая музыка");
        russianMap.put(MusicGenre.ELECTRONIC, "Музыка, созданная с помощью электронных устройств");
        russianMap.put(MusicGenre.HIPHOP, "Ритмичная и рифмующая музыка");
        I18N_MAP.put("ru", russianMap);

        // Английский
        Map<MusicGenre, String> englishMap = new HashMap<>();
        englishMap.put(MusicGenre.POP, "Popular and mainstream music");
        englishMap.put(MusicGenre.ROCK, "Guitar-driven music with a strong backbeat");
        englishMap.put(MusicGenre.JAZZ, "Improvised and soulful music");
        englishMap.put(MusicGenre.CLASSICAL, "Timeless and orchestrated music");
        englishMap.put(MusicGenre.ELECTRONIC, "Music created using electronic devices");
        englishMap.put(MusicGenre.HIPHOP, "Rhythmic and rhyming music");
        I18N_MAP.put("en", englishMap);
    }

    public abstract String getI18N(String languageCode);

    private static String getTranslation(String languageCode, MusicGenre musicGenre) {
        Map<MusicGenre, String> translations = I18N_MAP.get(languageCode);
        if (translations != null) {
            return translations.get(musicGenre);
        }
        return null; // Можно заменить на дефолтное значение или обработку ошибки
    }
}
