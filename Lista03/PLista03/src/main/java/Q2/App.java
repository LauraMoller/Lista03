/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import Q1.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author molle
 */
public class App {

    public App() {
        Funcionario vetor[] = new Funcionario[5];
        boolean correto = true;
        for (int i = 0; i < 5; i++) {
            Funcionario f = new Funcionario(0, "a");
            do {
                try {
                    f.setNome(JOptionPane.showInputDialog(null, "Nome do funcionário: "));
                } catch (IllegalArgumentException e) {
                    correto = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } while (!correto);
            correto = true;
            do {
                try {
                    f.setSalario(Double.parseDouble(JOptionPane.showInputDialog(null, "Salário do funcionário " + f.getNome() + ": ")));
                    vetor[i] = f;
                } catch (IllegalArgumentException a) {
                    correto = false;
                    JOptionPane.showMessageDialog(null, a.getMessage());
                }
            } while (!correto);
            correto = true;
        }
        for (int i = 0; i < 5; i++) {
            JOptionPane.showMessageDialog(null, "Funcionário: " + vetor[i].getNome() + "\nSalário: " + vetor[i].getSalario() + "\nImposto: " + vetor[i].calcularIrpf());
        }
    }
}
