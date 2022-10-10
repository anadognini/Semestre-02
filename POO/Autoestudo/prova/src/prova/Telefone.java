package prova;

import java.time.LocalDate;

public abstract class Telefone {
    // Atributos
    private String nomeUsuario;
    private String enderecoInstalacao;
    private LocalDate dataInstalacao;
    private String numero;

    // Getters e setters
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setEnderecoInstalacao(String enderecoInstalacao) {
        this.enderecoInstalacao = enderecoInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.length() != 10) {
            throw new IllegalArgumentException();
        }
        this.numero = numero;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEnderecoInstalacao() {
        return enderecoInstalacao;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public String getNumero() {
        return numero;
    }

    // Método abstrato
    public abstract double calcularCustoFixoMensal();
}
