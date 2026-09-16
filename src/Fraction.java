public class Fraction extends Number implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction other = (Fraction) obj;

        int g1 = gcd(this.numerator, this.denominator);
        int g2 = gcd(other.numerator, other.denominator);

        int reducedNum1 = this.numerator / g1;
        int reducedDen1 = this.denominator / g1;
        int reducedNum2 = other.numerator / g2;
        int reducedDen2 = other.denominator / g2;

        return reducedNum1 == reducedNum2 && reducedDen1 == reducedDen2;
    }

    @Override
    public int compareTo(Fraction other) {
        long left = (long) this.numerator * other.denominator;
        long right = (long) other.numerator * this.denominator;
        return Long.compare(left, right);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}