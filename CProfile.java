package edu.lab02;

import java.text.DecimalFormat;

/**
 * Zawiera metody i atrybuty opisujące kontownik
 */

public class CProfile {

    /**
     * Długość poziomego ramienia kątownika
     * Dodatkowe informacje: musi być większe niż G i R
     */
    protected Double A;

    /**
     * Długość pionowego ramienia kątownika
     * Dodatkowe informacje: musi być większe A
     */

    protected Double B;

    /**
     * Grubość ramion katownika
     */

    protected Double G;

    /**
     * Wartość zaokraglenia połączenia ramion od wewnętrznej strony
     */

    protected Double R;

    /**
     * Wartość zaokraglenia ramion od wewnętrznej strony na koncu obo ramion
     */

    protected Double R1;

    /**
     * Nazwa standardu
     */

    private final static String Standard = "PN-EN 10056-1:2000";

    /**
     * Nazwa kątownika
     */

    private String Name;

    /**
     * Oblicza pole przekroju kątownika
     * @return zwraca pole przekroju w postaci obiektu klasy Double
     */

    private Double area(){
        return (A*G)+G*(B-G)+(1-Math.PI/4)*(Math.pow(R, 2)-2*Math.pow(R1, 2));
    }

    /**
     * Zwraca nazwę uzytego standardu
     * @return zwraca nazwę standardu w postaci obiektu klasy String
     */
    public static String getStandard() {
        return Standard;
    }

    /**
     * Metoda służąca do przypisania wartości przekazywanych przez argumenty do atrybutów klasy
     * Funkcja zwraca Boolean.FALSE gdy któryś z parametrów liczbowych jest <= 0, w przeciwnym przypadku Boolean.TRUE
     * @param Name Nazwa kątownika
     * @param A Wartość parametru A
     * @param B Wartość parametru B
     * @param G artość parametru G
     * @param R Wartość parametru R
     * @param R1 Wartość parametru R1
     * @return Boolean.TRUE jeśli przypisanie było możliwe, w przeciwnym razie Boolean.FALSE.
     */

    public final Boolean assignData(String Name, Double A, Double B, Double G, Double R, Double R1) {
        if (A <= 0 || B <= 0 || G <= 0 || R <= 0 || R1 <= 0) {
            return Boolean.FALSE;
        }
        this.Name = Name;
        this.A = A;
        this.B = B;
        this.G = G;
        this.R = R;
        this.R1 = R1;

        return Boolean.TRUE;
    }

    /**
     * Konstruktor z argumentami inicjujący obiekt klasy CProfile
     * @param Name Nazwa kątownika
     * @param A Wartość parametru A
     * @param B Wartość parametru B
     * @param G artość parametru G
     * @param R Wartość parametru R
     * @param R1 Wartość parametru R1
     */

    public CProfile(String Name, Double A, Double B, Double G, Double R, Double R1) {
        assignData(Name, A, B, G, R, R1);
    }

    /**
     * Konstruktor bez argumentów inicjujący obiekt klasy CProfile z wartościami domyślnymi
     */

    public CProfile() {
        assignData("none", 50., 50., 5., 7., 3.5);
    }

    /**
     * Pobiera wynik obliczonego pola przekroju jako Double
     * @return Pole przekroju jako Double
     */

    public Double getResult() {
        return area();
    }

    /**
     * Zwraca wartości parametrów i pole przekroju w postaci tekstu
     * @param prec liczba cyfr po przecinku
     * @return zwraca pole przekroju w postaci obiektu klasy String
     */

    public String getResult(Integer prec) {
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(prec));
        Double result = area();
        return "Nazwa obiektu: " + this.Name + "\n" + "Parametry: A=" + A + ", B=" + B +
                ", G=" + G + ", R=" + R + ", R1" + R1 + "\n" +
                "Pole powierzchni: " + decimalFormat.format(result);
    }
}
