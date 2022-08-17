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
}
