package SistemaGeral.Dominio;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int id;
    private double valor;
    private int quantidade;

    public static void salvarProdutos(ArrayList<Produto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("produtos.dat"))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Produto> carregarProdutos() {
        File arquivo = new File("produtos.dat");
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("produtos.dat"))) {
            ArrayList<Produto> lista = (ArrayList<Produto>) ois.readObject();
            System.out.println(lista.size() + " produto(s) carregado(s).");
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void imprimeProduto() {
        System.out.println("================================");
        System.out.println("Nome:" + this.nome);
        System.out.println("ID:" + this.id);
        System.out.printf("Valor: R$%.2f ", this.valor);
        System.out.println("\nQuantidade: " + this.quantidade);
        System.out.println("================================");
    }

    public void cadastrarPoduto(ArrayList<Produto> lista, Scanner leia, ArrayList<String> relatorioHistorico) {
        Produto produtos = new Produto();


        System.out.println("\nCADASTRO DE PRODUTO\n");
        while (true) {
            System.out.print("Digite o nome do produto: ");
            String nome = leia.nextLine();

            boolean soletra = true;
            for (char c : nome.toCharArray()) {
                if (!Character.isDigit(c)) {
                    soletra = false;
                }
            }

            if (nome.length() == 0) {
                System.out.println("Nome não pode ser vazio");
            } else if (soletra) { //verifica se o nome digitado e só letra
                System.out.println("Nome inválido");
                continue;
            }
            boolean jaExiste = false;

            int maiorId = 0;
            for (Produto p : lista) {
                if (p.getNome().equals(produtos.getNome())) {
                    jaExiste = true;
                }
                if (p.getId() > maiorId) {
                    maiorId = p.getId();
                }
            }

            if (jaExiste) {
                System.out.println("Produto já cadastrado");
            } else {
                produtos.setNome(nome);
                produtos.setId(maiorId + 1);
                break;
            }
        }


        while (true) {
            System.out.print("Digite o valor: ");
            String valor = leia.nextLine();
            boolean soNumeros = true;
            for (char c : valor.toCharArray()) {//verifica caracter por caracter pra vê se n é número
                if (!Character.isDigit(c)) {
                    soNumeros = false;
                    break;
                }
            }

            if (valor.length() == 0 || !soNumeros) { //usuario não digitou nada
                System.out.println("Digite apenas números!");
                continue;
            } else if (Double.parseDouble(valor) <= 100) {
                System.out.println("Valor tem que ser maior que 100");
                continue;
            } else {
                produtos.setValor(Double.parseDouble(valor));
                break;
            }
        }
        while (true) {
            System.out.print("Digite a quantidade: ");
            String quant = leia.nextLine();
            boolean soNumeros2 = true;
            for (char c : quant.toCharArray()) {
                if (!Character.isDigit(c)) {
                    soNumeros2 = false;
                    break;
                }
            }
            if (quant.length() == 0 || !soNumeros2) {
                System.out.println("Digite apenas números!");
                continue;
            } else {
                produtos.setQuantidade(Integer.parseInt(quant));
                break;
            }
        }
        lista.add(produtos);
        //
        Historico.salvar(
                "      | Nome: " + produtos.getNome()
                        + " | ID: " + produtos.getId()
                        + " | Valor: R$" + produtos.getValor()
                        + " | Quantidade: " + produtos.getQuantidade()
        );

        System.out.println("\nProduto cadastrado com sucesso");
    }


   // public void produtoCadastrado(ArrayList<Produto> lista) {


    //   Produto p1 = new Produto();
    //   p1.setNome("Teclado");
    //  p1.setId(1);
    //  p1.setValor(150.00);
    //  p1.setQuantidade(10);
    //  lista.add(p1);

    //   Produto p2 = new Produto();
    //  p2.setNome("Mouse");
    // // p2.setId(2);
    //  p2.setValor(80.00);
    //  p2.setQuantidade(5);
    //  lista.add(p2);

    //    Produto p3 = new Produto();
    //   p3.setNome("Monitor");
    //  p3.setId(3);
    //   p3.setValor(1200.00);
    //   p3.setQuantidade(3);
    //  lista.add(p3);

    //  Produto p4 = new Produto();
    //   p4.setNome("Headset");
    //    p4.setId(4);
    //    p4.setValor(250.00);
    // p4.setQuantidade(7);
    //   lista.add(p4);

    //  Produto p5 = new Produto();
    //  p5.setNome("Webcam");
    // p5.setId(5);
    // p5.setValor(320.00);
    //  p5.setQuantidade(4);
    //  lista.add(p5);
    //}

        public void setNome (String nome){
            this.nome = nome;
        }

        public void setId ( int id){
            this.id = id;
        }

        public void setValor ( double valor){
            this.valor = valor;
        }

        public void setQuantidade ( int quantidade){
            this.quantidade = quantidade;
        }

        public String getNome () {
            return nome;
        }

        public int getId () {
            return id;
        }

        public double getValor () {
            return valor;
        }

        public int getQuantidade () {
            return quantidade;
        }

    }