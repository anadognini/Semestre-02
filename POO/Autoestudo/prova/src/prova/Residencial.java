package prova;

public class Residencial extends Telefone {
    // Atributos
    private boolean possuiInternet;

    // Getters e setters
    public boolean isPossuiInternet() {
        return possuiInternet;
    }

    public void setPossuiInternet(boolean possuiInternet) {
        this.possuiInternet = possuiInternet;
    }

    // Métodos
    public double calcularCustoFixoMensal() {
        return 15f;
    }
}
