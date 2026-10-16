package com.gurukul.core.math

import com.gurukul.core.model.Shishya

/**
 * Constants for breakthrough and progression math.
 */
object BreakthroughMath {

    /** Base chance of breakthrough success (0-1). */
    const val BASE_SUCCESS_CHANCE = 0.30

    /** Maximum sattva bonus to breakthrough chance. */
    const val MAX_SATTVA_BONUS = 0.30

    /** Maximum karma bonus to breakthrough chance. */
    const val MAX_KARMA_BONUS = 0.20

    /** Bonus when shishya's path matches their gift. */
    const val PATH_MATCH_BONUS = 0.10

    /** Maximum yantra accuracy bonus to breakthrough chance. */
    const val MAX_YANTRA_BONUS = 0.40

    /** Prana gained on successful breakthrough. */
    const val PRANA_GAIN_ON_SUCCESS = 20

    /** Prana lost on failed breakthrough. */
    const val PRANA_LOSS_ON_FAILURE = 10

    /** Sattva gained on successful breakthrough. */
    const val SATTVA_GAIN_ON_SUCCESS = 10

    /** Sattva lost on failed breakthrough. */
    const val SATTVA_LOSS_ON_FAILURE = 10

    /** Chakra level at which Moksha is achieved. */
    const val MOKSHA_CHAKRA_LEVEL = 7

    /**
     * Calculate the breakthrough success probability given the shishya's state
     * and yantra drawing accuracy.
     *
     * @param shishya the disciple attempting breakthrough
     * @param yantraAccuracy accuracy of the yantra drawing (0.0 to 1.0)
     * @return probability of success clamped to [0.0, 1.0]
     */
    fun calculateBreakthroughProbability(shishya: Shishya, yantraAccuracy: Double): Double {
        val sattvaBonus = (shishya.sattva / 100.0) * MAX_SATTVA_BONUS
        val karmaBonus = (shishya.karma / 200.0) * MAX_KARMA_BONUS
        val pathBonus = if (shishya.path.name == shishya.gift.name) PATH_MATCH_BONUS else 0.0
        val yantraBonus = yantraAccuracy * MAX_YANTRA_BONUS

        return (BASE_SUCCESS_CHANCE + sattvaBonus + karmaBonus + pathBonus + yantraBonus)
            .coerceIn(0.0, 1.0)
    }

    /**
     * Calculate the prana cost of a wrong-ring failure.
     */
    const val PRANA_PENALTY_WRONG_RING = 10

    /**
     * Calculate the sattva penalty for a failed breakthrough.
     */
    const val SATTVA_PENALTY_FAILURE = 10
}