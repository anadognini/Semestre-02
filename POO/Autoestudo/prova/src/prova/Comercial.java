package prova;

import java.time.LocalDate;

public class Comercial extends Telefone {
    // Atributos
    private String ramoAtividade;

    // Getters e setters
    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    // Métodos
    public double calcularCustoFixoMensal() {
        if (this.getDataInstalacao().isBefore(LocalDate.parse("2019-01-01"))) {
            return 25.0;
        } else {
            return 37.50;
        }
    }
}