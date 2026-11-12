public class Biblioteca {
    private static final int TAMANHO_MAXIMO_ACERVO = 150;
    private static final int TAMANHO_MAXIMO_LEITORES = 100;

    private final String nomeUnidade;
    private final ItemBiblioteca[] itensAcervo;
    private final Usuario[] leitoresRegistrados;
    private int qtdItensCadastrados;
    private int qtdLeitoresCadastrados;

    public Biblioteca(String nomeUnidade) {
        if (nomeUnidade == null || nomeUnidade.isBlank()) {
            throw new IllegalArgumentException("O nome da biblioteca deve ser informado.");
        }
        this.nomeUnidade = nomeUnidade;
        this.itensAcervo = new ItemBiblioteca[TAMANHO_MAXIMO_ACERVO];
        this.leitoresRegistrados = new Usuario[TAMANHO_MAXIMO_LEITORES];
        this.qtdItensCadastrados = 0;
        this.qtdLeitoresCadastrados = 0;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void cadastrarItem(ItemBiblioteca novoItem) {
        if (novoItem == null) {
            throw new IllegalArgumentException("O item para cadastro nao pode ser nulo.");
        }
        if (qtdItensCadastrados >= itensAcervo.length) {
            throw new IllegalStateException("Capacidade maxima do acervo atingida.");
        }
        if (localizarItemPorCodigo(novoItem.getCodigo()) != null) {
            throw new IllegalStateException("Codigo de item ja existente no acervo: " + novoItem.getCodigo());
        }
        itensAcervo[qtdItensCadastrados] = novoItem;
        qtdItensCadastrados++;
    }

    public void cadastrarUsuario(Usuario novoLeitor) {
        if (novoLeitor == null) {
            throw new IllegalArgumentException("O usuario para cadastro nao pode ser nulo.");
        }
        if (qtdLeitoresCadastrados >= leitoresRegistrados.length) {
            throw new IllegalStateException("Capacidade maxima de usuarios atingida.");
        }
        leitoresRegistrados[qtdLeitoresCadastrados] = novoLeitor;
        qtdLeitoresCadastrados++;
    }

    public ItemBiblioteca localizarItemPorCodigo(String codigoBusca) {
        for (int indice = 0; indice < qtdItensCadastrados; indice++) {
            if (itensAcervo[indice].getCodigo().equalsIgnoreCase(codigoBusca)) {
                return itensAcervo[indice];
            }
        }
        return null;
    }

    public boolean emprestar(String codigoItem, Usuario leitor) {
        if (leitor == null) {
            System.out.println("[ERRO] Usuario invalido para emprestimo.");
            return false;
        }

        ItemBiblioteca itemSelecionado = localizarItemPorCodigo(codigoItem);

        if (itemSelecionado == null) {
            System.out.println("[RECUSADO] Item com codigo '" + codigoItem + "' nao existe no acervo.");
            return false;
        }

        if (!itemSelecionado.isDisponivel()) {
            System.out.println("[RECUSADO] O item '" + itemSelecionado.getTitulo() + "' ja se encontra emprestado.");
            return false;
        }

        if (!leitor.possuiLimiteDisponivel()) {
            System.out.printf("[RECUSADO] %s atingiu o limite maximo de %d itens simultaneos.%n",
                    leitor.getNome(), leitor.calcularLimiteItens());
            return false;
        }

        itemSelecionado.atualizarDisponibilidade(false);
        leitor.incrementarEmprestimos();

        System.out.printf("[SUCESSO] '%s' emprestado para %s (Prazo de devolucao: %d dias).%n",
                itemSelecionado.getTitulo(), leitor.getNome(), itemSelecionado.calcularPrazoDias());
        return true;
    }

    public double devolver(String codigoItem, Usuario leitor, int diasAtraso) {
        if (leitor == null) {
            System.out.println("[ERRO] Usuario invalido para devolucao.");
            return 0.0;
        }

        ItemBiblioteca itemDevolvido = localizarItemPorCodigo(codigoItem);

        if (itemDevolvido == null) {
            System.out.println("[ERRO] Item com codigo '" + codigoItem + "' nao encontrado no acervo.");
            return 0.0;
        }

        if (itemDevolvido.isDisponivel()) {
            System.out.println("[AVISO] O item '" + itemDevolvido.getTitulo() + "' ja constava como disponivel.");
            return 0.0;
        }

        itemDevolvido.atualizarDisponibilidade(true);
        leitor.decrementarEmprestimos();

        double valorMulta = itemDevolvido.calcularMulta(diasAtraso);
        if (valorMulta > 0) {
            System.out.printf("[DEVOLUCAO] '%s' devolvido por %s com %d dia(s) de atraso. Multa gerada: R$ %.2f%n",
                    itemDevolvido.getTitulo(), leitor.getNome(), diasAtraso, valorMulta);
        } else {
            System.out.printf("[DEVOLUCAO] '%s' devolvido no prazo por %s. Sem multa.%n",
                    itemDevolvido.getTitulo(), leitor.getNome());
        }
        return valorMulta;
    }

    public void listarAcervo() {
        System.out.println("\n================ ACERVO: " + nomeUnidade.toUpperCase() + " ================");
        for (int indice = 0; indice < qtdItensCadastrados; indice++) {
            System.out.println((indice + 1) + ". " + itensAcervo[indice]);
        }
        System.out.println("====================================================================\n");
    }

    public void listarUsuarios() {
        System.out.println("\n================ LEITORES CADASTRADOS ================");
        for (int indice = 0; indice < qtdLeitoresCadastrados; indice++) {
            System.out.println((indice + 1) + ". " + leitoresRegistrados[indice]);
        }
        System.out.println("======================================================\n");
    }
}
