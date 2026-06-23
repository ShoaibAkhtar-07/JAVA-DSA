package OOPS;

public class ComplexNumbers {
    public static void main(String[] args) {
        Complex c1 = new Complex(0, 3);
        Complex c2 = new Complex(3, 3);

        Complex sumResult = Complex.sum(c1, c2);
        Complex diffResult = Complex.diff(c1, c2);
        Complex prodResult = Complex.prod(c1, c2);

        sumResult.print();
        diffResult.print();
        prodResult.print();

    }
}

class Complex {
    int real;
    int img;

    public Complex(int r, int i) {
        this.real = r;
        this.img = i;
    }

    public static Complex sum(Complex c1, Complex c2) {
        Complex c3 = new Complex(0, 0);
        c3.real = c1.real + c2.real;
        c3.img = c1.img + c2.img;

        return c3;
    }

    public static Complex diff(Complex c1, Complex c2) {
        Complex c3 = new Complex(0, 0);
        c3.real = c1.real - c2.real;
        c3.img = c1.img - c2.img;

        return c3;
    }

    public static Complex prod(Complex c1, Complex c2) {
        Complex c3 = new Complex(0, 0);
        c3.real = ((c1.real * c2.real) - (c1.img * c2.img));
        c3.img = ((c1.real * c2.img) + (c2.real * c1.img));

        return c3;
    }

    public void print() {
        System.out.println(real + " + " + img + "i");
    }

}
