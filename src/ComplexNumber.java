public class ComplexNumber extends SpecialNumber implements Comparable{
    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.imaginary = imaginary;
        this.real = real;
    }

    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof ComplexNumber)){
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
