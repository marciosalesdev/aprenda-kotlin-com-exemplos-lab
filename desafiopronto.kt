enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(val nome: String, val duracao: Int) {
    init {
        require(duracao == 30 || duracao == 45 || duracao == 60) 
    }
}

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val usuariosMatriculados = mutableListOf<Usuario>()
}

data class Usuario(val nome: String) {
    val formacoesMatriculadas = mutableListOf<Formacao>()

    fun matricularEmFormacao(formacao: Formacao) {
        formacoesMatriculadas.add(formacao)
        formacao.usuariosMatriculados.add(this)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Easy", 30)
    val conteudo2 = ConteudoEducacional("Hard", 45)
    val conteudo3 = ConteudoEducacional("Very Hard", 60)

    val formacao1 = Formacao("Engenharia de Software", Nivel.INTERMEDIARIO, listOf(conteudo1))
    val formacao2 = Formacao("Ciência de Dados", Nivel.AVANCADO, listOf(conteudo2))
    val formacao3 = Formacao("Sistema de Informaçao", Nivel.BASICO, listOf(conteudo3))

    val usuario1 = Usuario("Marcio")
    val usuario2 = Usuario("Paulo")
    val usuario3 = Usuario("Fernanda")

    usuario1.matricularEmFormacao(formacao1)
    usuario2.matricularEmFormacao(formacao2)
    usuario3.matricularEmFormacao(formacao3)

    // Imprime informações sobre as formações de cada usuário
    for (usuario in listOf(usuario1, usuario2, usuario3)) {
        println("Usuário: ${usuario.nome}")
        println("Formações Matriculadas:")
        for (formacao in usuario.formacoesMatriculadas) {
            println("Nome da Formação: ${formacao.nome}, Nível: ${formacao.nivel}")
        }
        println()
    }
}
