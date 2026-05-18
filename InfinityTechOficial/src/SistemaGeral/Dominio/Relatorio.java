package SistemaGeral.Dominio;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Relatorio {

    public void imprimeRelatorio(ArrayList<Venda> relatorioVendas, Scanner leia) {


        if (relatorioVendas.isEmpty()) {
            System.out.println("\nNenhuma venda realizada.");
            return;
        }
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     RELATÓRIO DE VENDAS      ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║   01 - Relatorio geral       ║");
        System.out.println("║   02 - Filtrar por produto   ║");
        System.out.println("║   03 - Faturamento total     ║");
        System.out.println("║   04 - Produto mais vendido  ║");
        System.out.println("║   05 - Voltar                ║");
        System.out.println("╚══════════════════════════════╝");


        System.out.print("\n  Digite a opção: ");
        int opcaoRelatorio = leia.nextInt();
        leia.nextLine();
        boolean controleWhile = true;

        while(controleWhile){

            switch (opcaoRelatorio){
                case 1:
                    double faturamentoTotal01 = 0;
                    int itemProduto = 0;

                    for(Venda venda : relatorioVendas){
                        System.out.println("__________________________________________________");
                        System.out.println("Produto  : "+ venda.getNomeProdutoVendido());
                        System.out.println("Quantidade  :" + venda.getQuantidadeProdutoVendido());
                        System.out.printf("Valor  : R$ %.2f%n", venda.getValorDoDoProdutoVendido());
                        System.out.println("__________________________________________________");
                        faturamentoTotal01 += venda.getValorDoDoProdutoVendido();
                        itemProduto += venda.getQuantidadeProdutoVendido();
                    }

                    System.out.println("\n__________________________________________________");
                    System.out.println(" Total de vendas   : "  + relatorioVendas.size());
                    System.out.println(" Total de itens    : "  + itemProduto);
                    System.out.println(" Faturamento total R$ " + faturamentoTotal01);
                    System.out.println("__________________________________________________");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

            controleWhile = false;
        }

    }

//            System.out.println("\n===== RELATÓRIO DE VENDAS =====");
//
//            for (Venda venda : relatorioVendas) {
//                System.out.println("-----------------------------");
//                System.out.println("Produto: " + venda.getNomeProdutoVendido());
//                System.out.println("Quantidade: " + venda.getQuantidadeProdutoVendido());
//                System.out.println("Valor total: R$ " + venda.getValorDoDoProdutoVendido());
//            }
//
//            System.out.println("-----------------------------");
//        }
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("historico.txt"));
//            String linha;
//
//
//            while ((linha = reader.readLine()) != null) {
//                if (linha.contains("Venda")) {
//                    System.out.println("-----------------------------");
//                    System.out.println(linha);
//                }
//            }
//
//            reader.close();
//
//        } catch (IOException e) {
//            System.out.println("\nNenhum histórico encontrado.");
//        }
//    }

    public void imprimeRelatorioProdutos(ArrayList<Produto> lista, ArrayList<String> relatorioHistorico) {

        System.out.println("\n===== RELATÓRIO DE PRODUTOS =====");

        if (lista.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
        } else {
            for (Produto produto : lista) {
                System.out.println("-----------------------------");
                System.out.println("ID: " + produto.getId());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Valor: R$ " + produto.getValor());
                System.out.println("Quantidade em estoque: " + produto.getQuantidade());
            }
        }

        if (relatorioHistorico.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        for (String historico : relatorioHistorico) {
            int index = historico.indexOf("Produto");
            if(index == -1){
                continue;
            }
            String dados= historico.substring(index);
            String[] partes = dados.split("\\|");
            System.out.println("-----------------------------");
            for (String parte : partes) {
                System.out.println(parte.trim());
            }
        }
        System.out.println("-----------------------------");
    }
}