package `fun`.kulikov.aviasalestestapp.domain.destination

import `fun`.kulikov.aviasalestestapp.data.destination.DestinationRepository
import javax.inject.Inject

class GetDestinationUseCase @Inject constructor(
    private val destinationRepository: DestinationRepository
) {
    suspend operator fun invoke(name: String): List<DestinationBusiness> =
        destinationRepository.getDestinationsList(name)
}