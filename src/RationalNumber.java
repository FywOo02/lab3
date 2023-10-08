/**
 * The `RationalNumber` class represents rational numbers and provides
 * methods for arithmetic operations and comparisons.
 * It extends the `SpecialNumber` class and implements the `Comparable` interface.
 */

public class RationalNumber extends SpecialNumber implements Comparable{

    /**
     * This is a local member of `RationalNumber` that refers to the numerator part of the rational number
     */
    int numerator;

    /**
     * This is a local member of `RationalNumber` that refers to the denominator part of the rational number
     */
    int denominator;

    /**
     * Constructs a new `RationalNumber` with the specified numerator and denominator.
     *
     * @param numerator   The numerator of the rational number.
     * @param denominator The denominator of the rational number.
     * @throws Lab3Exception If the denominator is zero, an exception is thrown.
     */
    public RationalNumber(int numerator, int denominator) throws Lab3Exception {
        if (denominator == 0){
            throw  new Lab3Exception("Denominator cannot be zero");
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }

    /**
     * Adds another rational number to this rational number without simplifying.
     *
     * @param num The rational number to add.
     * @return A new `RationalNumber` object representing the result of the addition.
     * @throws Lab3Exception If an error occurs during the addition.
     */
    public RationalNumber add_undivided(RationalNumber num) throws Lab3Exception {
        int new_denom = num.denominator * this.denominator;
        int new_numer = num.numerator * this.denominator + this.numerator * num.denominator;
        return new RationalNumber(new_numer,new_denom);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     *
     * @param denominator The denominator.
     * @param numerator   The numerator.
     * @return The GCD of the two integers.
     */
    public int gcd(int denominator, int numerator){
        if(numerator == 0){
            return denominator;
        }
        return gcd(numerator, denominator%numerator);
    }

    /**
     * Simplifies a rational number by dividing numerator and denominator by the GCD.
     *
     * @param num The rational number to simplify.
     * @return A new simplified `RationalNumber` object.
     * @throws Lab3Exception If an error occurs during simplification.
     */
    public RationalNumber simplify(RationalNumber num) throws Lab3Exception {
        int gcd = gcd(num.denominator,num.numerator);
        int denominator = num.denominator / gcd;
        int numerator = num.numerator / gcd;
        return new RationalNumber(numerator,denominator);
    }

    /**
     * Overrides the `add` method from the `SpecialNumber` class to add two `RationalNumber` objects
     * and return the simplified result.
     *
     * @param num The `SpecialNumber` to add to this `RationalNumber`.
     * @return A new `RationalNumber` object representing the simplified result of the addition.
     * @throws Lab3Exception If an error occurs during addition or simplification.
     */
    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof RationalNumber)){
            throw new Lab3Exception("Cannot add an incompatible type");
        }
        return simplify(add_undivided((RationalNumber) num));
    }

    /**
     * Overrides the `divideByInt` method from the `SpecialNumber` class to divide this `RationalNumber`
     * by an integer and return the simplified result.
     *
     * @param divisor The integer value to divide this `RationalNumber` by.
     * @return A new `RationalNumber` object representing the simplified result of the division.
     * @throws Lab3Exception If an error occurs during division or simplification.
     */
    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by zero");
        }
        denominator = divisor * this.denominator;
        RationalNumber temp = new RationalNumber(this.numerator, this.denominator);
        return simplify(temp);
    }

    /**
     * Compares this `RationalNumber` object with another object for ordering.
     * Returns a negative integer, zero, or a positive integer depending on whether
     * this object is less than, equal to, or greater than the specified object.
     *
     * @param o The object to compare to this `RationalNumber`.
     * @return A negative integer if this is less than `o`, zero if they are equal,
     *         or a positive integer if this is greater than `o`.
     */
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

    /**
     * Generates a hash code for this `RationalNumber` object.
     *
     * @return The hash code for this `RationalNumber`.
     */
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

    /**
     * Checks if this `RationalNumber` object is equal to another object.
     *
     * @param obj The object to compare to this `RationalNumber`.
     * @return `true` if the objects are equal, `false` otherwise.
     */
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
