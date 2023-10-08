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
        double new_real = ((ComplexNumber) num).real+this.real;
        double new_imaginary = ((ComplexNumber) num).imaginary+this.imaginary;
        return new ComplexNumber(new_real, new_imaginary);
    }

    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by zero");
        }
        double new_real = this.real/divisor;
        double new_imaginary = this.imaginary/divisor;
        return new ComplexNumber(new_real,new_imaginary);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof ComplexNumber){
            ComplexNumber input = (ComplexNumber) o;
            double input_mag = Math.sqrt(input.real * input.real + input.imaginary * input.imaginary);
            double this_mag = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);

            if (this_mag > input_mag){
                return 1;
            } else if (this_mag < input_mag) {
                return -1;
            }else {
                return 0;
            }

        }
        return 0;
    }

    public int covert(double num){
        while((int)num != num){
            num = num*10;
        }
        return (int) num;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + covert(real);
        result = prime*result + covert(imaginary);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof ComplexNumber){
            ComplexNumber number = (ComplexNumber) obj;
            if(this.real == number.real && this.imaginary == number.imaginary){
                return true;
            }
        }
        return false;
    }
}
