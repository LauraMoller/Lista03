/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Q1;

/**
 *
 * @author molle
 */
public class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(double salario, String nome) {
        setSalario(salario);
        setNome(nome);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior do que 0");
        }
        this.salario = salario;
    }

    public double calcularIrpf() {
        Faixas f = identificarFaixa();
        
       switch (f) {
            case PRIMEIRA:
                return 0;
            case SEGUNDA:
                return faixa2();
            case TERCEIRA:
                return faixa3();
            case QUARTA:
                return faixa4();
            case QUINTA:
                return faixa5();
            default:
                throw new IllegalArgumentException("Faixa inválida");
        }
    }

    public Faixas identificarFaixa() {
        if (getSalario() >= 4664.69) {
            return Faixas.QUINTA;
        } else if (getSalario() >= 3751.06 && getSalario() <= 4664.68) {
            return Faixas.QUARTA;
        } else if (getSalario() >= 2826.66 && getSalario() <= 3751.05) {
            return Faixas.TERCEIRA;
        } else if (getSalario() >= 1903.99 && getSalario() <= 2826.65) {
            return Faixas.SEGUNDA;
        } else {
            return Faixas.PRIMEIRA;
        }
    }

    public double faixa2() {
        return (getSalario() - 1903.98) * 0.075;
    }

    public double faixa3() {
        return (getSalario() - 2826.65) * 0.15 + 69.20;
    }

    public double faixa4() {
        return (getSalario() - 3751.05) * 0.225 + 138.66 + 69.20;
    }

    public double faixa5() {
        return (getSalario() - 4664.68) * 0.275 + 205.56675 + 138.66 + 69.20;
    }
}
