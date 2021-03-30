package `fun`.kulikov.aviasalestestapp.utils.mapping

/**
 * Интерфейс для реализации мапперов data -> domain -> ui слоев (как завещал дядя Боб)
 * */

interface Mapper<F, T> {
    fun map(from: F): T
}