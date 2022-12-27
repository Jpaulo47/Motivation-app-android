package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Ser feliz sem motivo é a mais autêntica forma de felicidade.", happy),
        Phrase("Saber encontrar a alegria na alegria dos outros é o segredo da felicidade.", happy),
        Phrase("Felicidade é a certeza de que a nossa vida não está se passando inutilmente.", happy),
        Phrase("A nossa felicidade depende mais do que temos nas nossas cabeças, do que nos nossos bolsos.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("A vida é curta e o tempo passa rápido. Aproveite cada instante. Bom dia!", sunny),
        Phrase("Para hoje, escolha brilhar! Bom dia!", sunny),
        Phrase("Que o amor esteja presente do começo ao fim do seu dia!", sunny),
        Phrase("Nesta manhã, te desejo apenas uma coisa: que você seja muito feliz! Um ótimo dia!", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)

    )

    fun getPhrase(value: Int): String {

        val filtered = mListPhrase.filter { it.categoryId == value || value == all}
        return filtered[Random.nextInt(filtered.size)].description
    }
}