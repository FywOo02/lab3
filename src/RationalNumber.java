import java.util.Comparator;

public class RationalNumber extends SpecialNumber implements Comparable{
    int numerator;
    int denominator;

    public RationalNumber(int numerator, int denominator) throws Lab3Exception {
        if (denominator == 0){
            throw  new Lab3Exception("Denominator cannot be zero");
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }


    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof RationalNumber)){
            throw new Lab3Exception("Cannot add an incompatible type");
        }
        return null;
    }

    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by zero");
        }
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
