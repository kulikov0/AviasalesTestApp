package `fun`.kulikov.aviasalestestapp.data.api

/**
 * Класс, который позволяет получить доступ к различным апи сервисам, на случай, если
 * в репозитории для формирования одной сущности нужно несколько сервисов. Чтобы добавить новый сервис -
 * иди в RetrofitModule а затем добавь полученный сервис в ApiModule, предварительно
 * дописав новый сервис в конструкторе данного класса
 * */

class ApiController (
    val destinationService: DestinationService
)