package `fun`.kulikov.aviasalestestapp.utils.animations

import androidx.fragment.app.FragmentTransaction

fun FragmentTransaction.applyAnimation(animation: TransactionAnimation?): FragmentTransaction =
    this.apply {
        animation?.let {
            when (animation) {
                is FragmentTransition -> setTransition(animation.transition)
                is Custom -> setCustomAnimations(
                    animation.enter, animation.exit, animation.popEnter, animation.popExit
                )
            }
        }
    }