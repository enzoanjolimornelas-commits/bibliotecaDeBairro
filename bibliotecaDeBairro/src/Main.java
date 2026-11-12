public class Main {
    public static void main(String[] args) {
        Biblioteca unidadeCentral = new Biblioteca("Biblioteca Comunitaria Machado de Assis");

        // 1. Criacao e cadastro dos itens do acervo (Livros, Revistas e nova categoria DVD)
        Livro livroDomCasmurro = new Livro("LIV-101", "Dom Casmurro");
        Livro livroArquiteturaLimpa = new Livro("LIV-102", "Arquitetura Limpa");
        Livro livroAlgoritmos = new Livro("LIV-103", "Entendendo Algoritmos");
        Revista revistaSuper = new Revista("REV-201", "Superinteressante - Ed. 450");
        Revista revistaNatGeo = new Revista("REV-202", "National Geographic Brasil");
        DVD dvdInterestelar = new DVD("DVD-301", "Interestelar - Edicao Especial");
        DVD dvdMatrix = new DVD("DVD-302", "Matrix Reloaded");

        unidadeCentral.cadastrarItem(livroDomCasmurro);
        unidadeCentral.cadastrarItem(livroArquiteturaLimpa);
        unidadeCentral.cadastrarItem(livroAlgoritmos);
        unidadeCentral.cadastrarItem(revistaSuper);
        unidadeCentral.cadastrarItem(revistaNatGeo);
        unidadeCentral.cadastrarItem(dvdInterestelar);
        unidadeCentral.cadastrarItem(dvdMatrix);

        // 2. Criacao e cadastro dos usuarios (Alunos e Professores)
        Usuario alunoEnzo = new Aluno("Enzo Gabriel Oliveira");
        Usuario alunaCamila = new Aluno("Camila Ferreira Santos");
        Usuario profMarcos = new Professor("Marcos Vinicius Almeida");

        unidadeCentral.cadastrarUsuario(alunoEnzo);
        unidadeCentral.cadastrarUsuario(alunaCamila);
        unidadeCentral.cadastrarUsuario(profMarcos);

        // 3. Exibicao inicial do acervo e dos leitores
        unidadeCentral.listarAcervo();
        unidadeCentral.listarUsuarios();

        // 4. Cenario de teste: emprestimos bem-sucedidos e recusados
        System.out.println("--- Realizando Emprestimos ---");
        unidadeCentral.emprestar("LIV-101", alunoEnzo);
        unidadeCentral.emprestar("REV-201", alunoEnzo);
        unidadeCentral.emprestar("DVD-301", alunoEnzo);

        // Tentativa recusada: Aluno Enzo ja possui 3 itens (limite atingido)
        unidadeCentral.emprestar("LIV-102", alunoEnzo);

        // Tentativa recusada: Item LIV-101 ja esta emprestado para Enzo
        unidadeCentral.emprestar("LIV-101", profMarcos);

        // Emprestimo bem-sucedido para o professor
        unidadeCentral.emprestar("LIV-102", profMarcos);
        unidadeCentral.emprestar("DVD-302", alunaCamila);

        unidadeCentral.listarAcervo();

        // 5
        System.out.println("--- Realizando Devolucoes ---");
        unidadeCentral.devolver("REV-201", alunoEnzo, 4);
        unidadeCentral.devolver("LIV-101", alunoEnzo, 3); 
        unidadeCentral.devolver("DVD-302", alunaCamila, 0); 

        System.out.println("\n--- Novo Emprestimo Apos Devolucao ---");
        unidadeCentral.emprestar("LIV-103", alunoEnzo);

        unidadeCentral.listarAcervo();
        unidadeCentral.listarUsuarios();
    }
}
