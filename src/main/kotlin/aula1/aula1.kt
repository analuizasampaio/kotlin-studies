package aula1

    fun main(){
        var nome = "Analu"
        val sobrenome = "Sampaio" // val é uma constante

        var nome_completo = "${nome} de ${sobrenome}"
        println(nome_completo)

        print("Tamanho da string: ${nome_completo.length}")

        var s: String? = "Fernando"
        //s as String

        /*if (s is String) { // verifica se é um subtipo; se verdadeiro transforma (as)
            print(s.length)
        }*/
        print(s?.length)

        //println(s as? Int)
    }
