package application;

import Model.entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();

        String path = "C:\\Users\\victo\\OneDrive\\Desktop\\Curso JAVA Udemy\\Praticas com intellij\\Treinos\\CadastroFuncionarios_usandoArquivo_e_compareTo\\dadosFuncionarios.txt";




        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            br.readLine(); // pular a primeira linha

            String func = br.readLine();
            while (func != null) {

                String[] fields = func.split(",");
                String nome = fields[0];
                long cpf = Long.parseLong(fields[1]);
                int rg = Integer.parseInt(fields[2]);
                Double salario = Double.parseDouble(fields[3]);
                funcionarios.add(new Funcionario(nome, cpf, rg, salario));
                func = br.readLine();
            }

            Collections.sort(funcionarios);

            System.out.println("**************************");
            System.out.println("------- Funcionários -----");
            System.out.println("**************************");

            for (Funcionario f: funcionarios){
                System.out.println(f.toString());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }






        s.close();
    }
}
