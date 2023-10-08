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

    public RationalNumber add_undivided(RationalNumber num) throws Lab3Exception {
        int new_denom = num.denominator * this.denominator;
        int new_numer = num.numerator * this.denominator + this.numerator * num.denominator;
        return new RationalNumber(new_numer,new_denom);
    }

    public int gcd(int denominator, int numerator){
        if(numerator == 0){
            return denominator;
        }
        return gcd(numerator, denominator%numerator);
    }

    public RationalNumber simplify(RationalNumber num) throws Lab3Exception {
        int gcd = gcd(num.denominator,num.numerator);
        int denominator = num.denominator / gcd;
        int numerator = num.numerator / gcd;
        return new RationalNumber(numerator,denominator);
    }

    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof RationalNumber)){
            throw new Lab3Exception("Cannot add an incompatible type");
        }
        return simplify(add_undivided((RationalNumber) num));
    }

    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by zero");
        }
        denominator = divisor * this.denominator;
        RationalNumber temp = new RationalNumber(this.numerator, this.denominator);
        return simplify(temp);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof RationalNumber){
            RationalNumber input = (RationalNumber) o;
            if ((double)this.numerator/this.denominator > (double)input.numerator/input.denominator){
                return 1;
            } else if ((double)this.numerator/this.denominator < (double) input.numerator/input.denominator) {
                return -1;
            }else {
                return 0;
            }

        }
        return 0;
    }

    @Override
    public int hashCode() {
        try {
            RationalNumber new_ration = simplify(this);
            final int prime = 97;
            int result = 1;
            result = prime*result + new_ration.numerator;
            result = prime*result + new_ration.denominator;
            return result;
        } catch (Lab3Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof RationalNumber){
            RationalNumber num1 = null;
            RationalNumber num2 = null;
            try {
                num1 = simplify((RationalNumber) obj);
                num2 = simplify(this);
            } catch (Lab3Exception e) {
                throw new RuntimeException(e);
            }
            if(num2.denominator == num1.denominator && num2.numerator == num1.numerator){
                return true;
            }
        }
        return false;
    }
}
