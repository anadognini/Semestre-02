public class InteiroPositivo {
    // Atributos
    private int x;

    // Letra a
    public void setValor(int valor) {
        if (valor >= 0) {
            this.x = valor;
        }
    }

    public int getValor() {
        return this.x;
    }

    // Letra b
    public long multiplicar(InteiroPositivo outro) {
        return this.x * outro.getValor();
    }

    // Letra c
    public long fatorial() {
        long fatorial = 1;

        for (int i = this.x; i > 1; i--) {
            fatorial = fatorial * i;
        }

        return fatorial;
    }

    // Letra d
    public String divisoresInteiros() {
        int contador = 0;

        String str = "Os divisores são ";

        for (int i = 1; i <= this.x; i++) {
            if (this.x % i == 0) {
                str += i + ", ";
                contador++;
            }
        }

        str += " e a quantidade de divisores é " + contador;

        return str;
    }

    // Letra e
    public int[] fibonacci() {
        int[] vetor = new int[this.x];

        if (vetor.length > 0) {
            vetor[0] = 1;
            if (vetor.length > 1) {
                vetor[1] = 1;
            }
        }

        for (int i = 2; i < vetor.length; i++) {
            vetor[i] = vetor[i - 1] + vetor[i - 2];
        }

        return vetor;
    }

    // Letra f
    public double valorI() {
        double valSup = 1;
        double valInf = 0;
        double i = 0;
        valInf = x;

        for (int a = 1; a <= x; a++) {
            if (a < x) {
                i += valSup / valInf;
                valSup += 1;
                valInf -= 1;
            }

            if (a == x) {
                i += valSup / valInf;
            }
        }

        return i;
    }

    // Letra g
    public double valorS() {
        double s = 0;

        for (double i = 1; i <= x; i++) {
            if (i == 1.0) {
                s += 1 / (fatS(2));
            }

            if (i % 2 == 0) {
                s -= i / (fatS((i * 2)));
            }

            if (i % 2 != 0 && i > 1.0) {
                s += i / (fatS((i * 2)));
            }
        }

        return s;
    }

    // Letra h
    public double fatS(double i) {
        double f = i;

        while (i > 1) {
            f = f * (i - 1);
            i--;
        }

        return f;
    }
}
