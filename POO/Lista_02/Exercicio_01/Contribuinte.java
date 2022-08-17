// Contribuinte

/**
 * nome: String
 * cpf: String
 * uf: String
 * rendaAnual: double
 * 
 * get * set *
 * 
 * calcularImposto(): double
 * 
 * Contribuinte(nome, cpf, uf, rendaAnual)
 * 
 */

public class Contribuinte {
    // Atributos
    private String nome;
    private String cpf;
    private String uf;
    private double rendaAnual;

    // Construtor
    public Contribuinte(String nome, String cpf, String uf, double rendaAnual) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setUf(uf);
        this.setRendaAnual(rendaAnual);
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        if (uf.equals("SC") || uf.equals("RS") || uf.equals("PR"))  {
            this.uf = uf;
        }  
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        if (rendaAnual >= 0) {
            this.rendaAnual = rendaAnual;
        }
    }

    // Métodos
    public double calcularImposto() {
        double imposto = 0;
        // double aliquota;

        // if (rendaAnual >= 0 && rendaAnual <= 4000) {
        // aliquota = 0;
        // } else if (rendaAnual >= 4001 && rendaAnual <= 9000) {
        // aliquota = 0.58;
        // } else if (rendaAnual)

        return imposto;
    }

    /**
     * Nível de Renda Anual Alíquota
     * 0 a 4.000 0%
     * 
     * 4.001 a 9.000 5,8%
     * 9.001 a 25.000 15%
     * 25.001 a 35.000 27,5%
     * acima de 35.000 30%
     * 
     * 
     * Imposto a pagar = Renda Anual * Alíquota
     */

}