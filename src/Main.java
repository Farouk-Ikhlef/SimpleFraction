public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(5);
        Fraction f3 = new Fraction();

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        assert f1.toString().equals("3/4");
        assert f2.toString().equals("5/1");
        assert f3.toString().equals("0/1");

        System.out.println(Fraction.ZERO);
        System.out.println(Fraction.UN);

        assert Fraction.ZERO.toString().equals("0/1");
        assert Fraction.UN.toString().equals("1/1");

        assert f1.getNumerator() == 3;
        assert f1.getDenominator() == 4;
    }
}