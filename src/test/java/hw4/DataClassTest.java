package hw4;

import java.util.ArrayList;
import java.util.List;

public class DataClassTest {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static final String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    public static final String BROWSER_TITLE = "Home Page";

    public static final List<String> HEADER_ITEMS_NAMES = new ArrayList<>(
            List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

    public static final int NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS = 4;

    public static final List<String> ITEMS_IN_SIDEBAR_MENU = new ArrayList<>(
            List.of("Home", "Contact form", "Service", "Metals & Colors",
                    "Elements packs")
    );

    public static final List<String> BENEFIT_TEXTS = new ArrayList<>(
        List.of(
            "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project",

            "To be flexible and\n"
                + "customizable",

            "To be multiplatform",

            "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…"
        )
    );

    public static final List<String> CHECKBOX = new ArrayList<>(
            List.of("Water", "Earth", "Wind", "Fire")
    );
    public static final String CHECKBOX_LOG =
            ": condition changed to true";

    public static final List<String> RADIO = new ArrayList<>(
            List.of("Gold", "Silver", "Bronze", "Selen")
    );

    public static final String RADIO_LOG =
            "metal: value changed to ";

    public static final List<String> DROPDOWN = new ArrayList<>(
            List.of("Red", "Green", "Blue", "Yellow")
    );

    public static final String DROPDOWN_LOG =
            "Colors: value changed to ";
}
