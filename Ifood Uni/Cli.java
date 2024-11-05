import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    /**
     * Essa classe é responsável pela Comand Line Interface do código.
     * Ela inicializa o processo de interação com o cliente, criando opções de produtos,
     * estabelecimentos, métodos de pagamento, e veículos para o entregador.
     * Usando um pilar da Programação Orientada a Objetos chamado Abstração
     **/
    public static void init() {
        // Método `init` para iniciar o código de interface
        Cliente cliente = new Cliente("Default");
        // Cria um objeto `Cliente` com o nome "Default" para representar o usuário padrão

        Pagamento Pix = new Pix();
        Pagamento cartao = new Cartao();
        // A interface Pagamento chama a subclasse pix que executa e cria um objeto do tipo Pix e da mesma forma acontece com o Cartão

        Produto MegaStacker =  new Produto("Mega Stacker", 44.0, 4.7);
        Produto Rodeio = new Produto("Rodeio", 24.0, 4.4);
        Produto Whopper = new Produto("Whopper", 25.0, 4.6 );
        //A Classe produto vai ter os seus produtos que vão ser instaciados objetos do tipo produto e apresenta os nomes dos produtos, os preçoes e as avaliações.

        ArrayList<Produto> Produtos_BK = new ArrayList<>();
        //É criado uma lista para armazenar os objetos do tipo Produto

        Produtos_BK.add(MegaStacker);
        Produtos_BK.add(Rodeio);
        Produtos_BK.add(Whopper);
        //Adição dos produtos na lista criada.

        Estabelecimento BK = new Restaurante("Burguer King", Produtos_BK , 4.5);
        // Estabelecimento é a classe mãe que pode ter outras subclasses, assim é instaciado um objeto do tipo restaurante.

        Veiculo Moto = new Moto("Motoca", "Moto");
        // A interface Veiculo chama a subclasse Moto que executa e cria um objeto do tipo Moto.

        Entregador EntregadorBk = new Entregador("Joelson", Moto);
        // Cria um objeto `Entregador` para o entregador "Joelson" que usará uma moto para realizar as entregas.

        Produto McLancheFeliz = new Produto("McLancheFeliz", 35, 4.5);
        Produto McPicanha = new Produto("McPicanha", 38, 4.5);
        Produto McFlurry = new Produto("McFlurry", 7, 4.8);
        //A Classe produto vai ter os seus produtos que vão ser instanciados objetos do tipo produto e apresenta os nomes dos produtos, os preçoes e as avaliações.

        ArrayList<Produto> Produtos_Mc = new ArrayList<>();
        //É criado uma lista para armazenar os objetos do tipo Produto

        Produtos_Mc.add(McLancheFeliz);
        Produtos_Mc.add(McPicanha);
        Produtos_Mc.add(Whopper);
        //Adição dos produtos na lista criada.

        Estabelecimento Mequi = new Restaurante("Mc Donalds", Produtos_Mc, 4.4);
        // Estabelecimento é a classe mãe que pode ter outras subclasses, assim é instaciado um objeto do tipo restaurante

        Veiculo Bicicleta = new Bicicleta("Bike", "Bike");
        // A interface Veiculo chama a subclasse Bicicleta que executa e cria um objeto do tipo Bicicleta.

        Entregador EntregadorMc = new Entregador("Everton", Bicicleta);
        // Cria um objeto `Entregador` para o entregador "Everton" que usará uma bicicleta para realizar as entregas.

        ArrayList<Produto> Produtos_Pedidos = new ArrayList<>();
        // Cria uma lista vazia para armazenar produtos que o cliente vai selecionar.

        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha seu estabelecimento:\n1 - Restaurante\n2 - Bar\n3 - ...");
        // Exibe opções de estabelecimento para o cliente
        int escolha = scan.nextInt();
        scan.nextLine();  // Consome a nova linha após nextInt()

        if (escolha == 1) { // Cliente escolhe um restaurante
            try {
                System.out.println("Escolha um dos restaurantes abertos:\n1 - Burguer King\n2 - McDonalds");
                int escolha2 = scan.nextInt();
                scan.nextLine();  // Consome a nova linha após nextInt()

                if (escolha2 == 1) { // Cliente escolhe Burguer King
                    int escolha3;
                    do {
                        System.out.println("Escolha seus pedidos entre os produtos disponíveis:\n1 - " + MegaStacker.getNome() + "\n2 - " + Rodeio.getNome() + "\n3 - " + Whopper.getNome() + "\n4 - Termine");
                        escolha3 = scan.nextInt();
                        scan.nextLine();  // Consome a nova linha após nextInt()
                        if (escolha3 == 1) {
                            Produtos_Pedidos.add(MegaStacker);
                        } else if (escolha3 == 2) {
                            Produtos_Pedidos.add(Rodeio);
                        } else if (escolha3 == 3) {
                            Produtos_Pedidos.add(Whopper);
                        }
                    } while (escolha3 != 4); // O loop termina se o cliente escolher a opção 4 (Termine)

                    System.out.println("Digite seu endereço para entrega:");
                    String endereco = scan.nextLine();

                    System.out.println("Escolha seu método de pagamento (Somente online):\n1 - Pix\n2 - Cartão");
                    int pagamento = scan.nextInt();
                    scan.nextLine();  // Consome a nova linha após nextInt()
                    if (pagamento == 1) { // Cria o pedido com método de pagamento Pix
                        Pedido pedido = new Pedido(cliente, Produtos_Pedidos, Pix, "", endereco);
                        System.out.println("Digite adicionais para: ");
                        pedido.AdicionarAdicionais();
                        Pix.realizarPagamento();
                        Entrega entrega = new Entrega(pedido, EntregadorBk);
                        entrega.realizarEntrega();
                    } else if (pagamento == 2) { // Cria o pedido com método de pagamento Cartão
                        System.out.println("1 - Crédito\n2 - Débito");
                        int tipo_cartao = scan.nextInt();
                        scan.nextLine();  // Consome a nova linha após nextInt()
                        if (tipo_cartao == 1) { // Crédito
                            System.out.println("Pagamento com cartão de crédito selecionado.");
                            ((Cartao) cartao).setTipo("Crédito");  //Colocando o tipo do Cartão como crédito usando encapsulamento
                            Pedido pedido = new Pedido(cliente, Produtos_Pedidos, cartao, "", "");
                            System.out.println("Digite adicionais para: ");
                            pedido.AdicionarAdicionais();
                            cartao.realizarPagamento();
                            Entrega entrega = new Entrega(pedido, EntregadorBk);
                            entrega.realizarEntrega();
                        } else if (tipo_cartao == 2) { // Débito
                            System.out.println("Pagamento com cartão de débito selecionado.");
                            ((Cartao) cartao).setTipo("Débito");
                            Pedido pedido = new Pedido(cliente, Produtos_Pedidos, cartao, "", "");
                            System.out.println("Digite adicionais para: ");
                            pedido.AdicionarAdicionais();
                            cartao.realizarPagamento();
                            Entrega entrega = new Entrega(pedido, EntregadorBk);
                            entrega.realizarEntrega();
                        }
                    }
                } else if (escolha2 == 2) { // Cliente escolhe McDonald's
                    int escolha3;
                    do {
                        System.out.println("Escolha seus pedidos entre os produtos disponíveis:\n1 - " + McLancheFeliz.getNome() + "\n2 - " + McPicanha.getNome() + "\n3 - " + McFlurry.getNome() + "\n4 - Termine");
                        escolha3 = scan.nextInt();
                        scan.nextLine();  // Consome a nova linha após nextInt()
                        if (escolha3 == 1) {
                            Produtos_Pedidos.add(McLancheFeliz);
                        } else if (escolha3 == 2) {
                            Produtos_Pedidos.add(McPicanha);
                        } else if (escolha3 == 3) {
                            Produtos_Pedidos.add(McFlurry);
                        }
                    } while (escolha3 != 4); // O loop termina se o cliente escolher a opção 4 (Termine)

                    System.out.println("Digite seu endereço para entrega:");
                    String endereco = scan.nextLine();

                    System.out.println("Escolha seu método de pagamento (Somente online):\n1 - Pix\n2 - Cartão");
                    int pagamento = scan.nextInt();
                    scan.nextLine();  // Consome a nova linha após nextInt()
                    if (pagamento == 1) { // Cria o pedido com método de pagamento Pix
                        Pedido pedido = new Pedido(cliente, Produtos_Pedidos, Pix, "", endereco);
                        System.out.println("Digite adicionais para: ");
                        pedido.AdicionarAdicionais();
                        Pix.realizarPagamento();
                        Entrega entrega = new Entrega(pedido, EntregadorBk);
                        entrega.realizarEntrega();
                    } else if (pagamento == 2) { // Cria o pedido com método de pagamento Cartão
                        System.out.println("1 - Crédito\n2 - Débito");
                        int tipo_cartao = scan.nextInt();
                        scan.nextLine();  // Consome a nova linha após nextInt()
                        if (tipo_cartao == 1) { // Crédito
                            System.out.println("Pagamento com cartão de crédito selecionado.");
                            ((Cartao) cartao).setTipo("Crédito");
                            Pedido pedido = new Pedido(cliente, Produtos_Pedidos, cartao, "", "");
                            System.out.println("Digite adicionais para: ");
                            pedido.AdicionarAdicionais();
                            cartao.realizarPagamento();
                            Entrega entrega = new Entrega(pedido, EntregadorBk);
                            entrega.realizarEntrega();
                        } else if (tipo_cartao == 2) { // Débito
                            System.out.println("Pagamento com cartão de débito selecionado.");
                            ((Cartao) cartao).setTipo("Débito");
                            Pedido pedido = new Pedido(cliente, Produtos_Pedidos, cartao, "", "");
                            System.out.println("Digite adicionais para: ");
                            pedido.AdicionarAdicionais();
                            cartao.realizarPagamento();
                            Entrega entrega = new Entrega(pedido, EntregadorBk);
                            entrega.realizarEntrega();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro inesperado.");
            }
        } else if (escolha == 2) {
            System.out.println("Ainda não temos Bares abertos.");
        } else {
            System.out.println("Digite um valor válido.");
        }
    }
}
