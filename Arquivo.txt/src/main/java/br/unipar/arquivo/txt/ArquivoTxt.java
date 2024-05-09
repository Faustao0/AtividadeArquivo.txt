/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.arquivo.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author 00233397
 */
public class ArquivoTxt {

        public static void main(String[] args) {
        
        File diretorioTabuada = new File("U:\\Desktop\\AtividadeArquivotxt");
        if(!diretorioTabuada.exists()){
        boolean criado = diretorioTabuada.mkdir();
        if (criado) {
        System.out.println("Diretório criado");
        } else {
         System.out.println("Falha ao criar o diretório");
        }
        System.out.println("Diretorio já existe");
        }  
      
        String nomeArquivo = "U:\\Desktop\\AtividadeArquivotxt\\AtividadeArquivo.txt";    

        criarTabuada(nomeArquivo);
        lerArquivo(nomeArquivo);
        excluirArquivo(nomeArquivo);
    }

    public static void criarTabuada(String nomeArquivo) {
        String conteudoArquivo = "Tabuada do 9:\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int i = 1; i <= 10; i++) {
                int resultado = 9 * i;
                conteudoArquivo += "9 x " + i + " = " + resultado + "\n";
            }
            writer.write(conteudoArquivo);
            System.out.println("Arquivo criado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public static void lerArquivo(String nomeArquivo) {
    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
        String linha;
        System.out.println("Conteúdo do arquivo:");
        while ((linha = reader.readLine()) != null) {
            System.out.println(linha);
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler arquivo: " + e.getMessage());
     }
    }

    public static void excluirArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo excluído com sucesso.");
            } else {
                System.out.println("Erro ao excluir arquivo.");
            }
        }
    }
}

