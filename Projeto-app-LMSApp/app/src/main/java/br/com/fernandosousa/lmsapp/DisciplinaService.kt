package br.com.fernandosousa.lmsapp

object DisciplinaService {

    fun getDisciplinas(): List<Disciplina> {
        val disciplinas = mutableListOf<Disciplina>()

        for (i in 1..10) {
            val d = Disciplina()
            d.nome = " Nome $i"
            d.ementa = " Ementa $i"
            d.professor = " Professor $i"
            d.foto = "Foto link $i"

            disciplinas.add(d)
        }
        return disciplinas
    }

}