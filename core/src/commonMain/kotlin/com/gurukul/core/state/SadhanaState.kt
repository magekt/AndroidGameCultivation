package com.gurukul.core.state

import com.gurukul.core.model.Gift
import com.gurukul.core.model.Path
import com.gurukul.core.model.Samskara
import com.gurukul.core.model.Shishya
import kotlin.random.Random

/**
 * The lifecycle state of a shishya's cultivation journey.
 */
enum class SadhanaState {
    /** The disciple has not yet been recruited. */
    RECRUIT,
    /** The disciple has been matched to a path and is ready to train. */
    MATCH,
    /** The disciple is actively training in sadhana. */
    TRAIN,
    /** The disciple is at a breakthrough threshold, awaiting yantra validation. */
    BREAKTHROUGH_READY,
    /** The disciple has achieved Moksha and left the gurukul. */
    MOKSHA,
}

/**
 * State machine governing a shishya's progression through the gurukul.
 */
object SadhanaStateMachine {

    /**
     * Recruit a new shishya with the given attributes.
     */
    fun recruit(
        id: String,
        name: String,
        samskara: Samskara,
        gift: Gift,
        path: Path
    ): Shishya = Shishya(
        id = id,
        name = name,
        samskara = samskara,
        gift = gift,
        path = path,
        chakraLevel = 1,
        sattva = 50,
        karma = 0,
        prana = 0,
        inMoksha = false
    )

    /**
     * Attempt to advance the shishya to the next chakra level.
     * Returns true if the breakthrough succeeded, false if it failed (adharma regression).
     */
    fun attemptBreakthrough(shishya: Shishya, yantraAccuracy: Double): BreakthroughResult {
        val successProbability = calculateBreakthroughProbability(shishya, yantraAccuracy)
        val succeeded = Random.nextDouble() < successProbability

        return when {
            succeeded -> {
                shishya.chakraLevel++
                shishya.sattva = (shishya.sattva + 10).coerceAtMost(100)
                shishya.prana = (shishya.prana + 20).coerceAtMost(100)
                BreakthroughResult(
                    success = true,
                    newChakraLevel = shishya.chakraLevel,
                    newSattva = shishya.sattva,
                    newPrana = shishya.prana,
                    isMoksha = shishya.chakraLevel >= 7
                )
            }
            else -> {
                shishya.sattva = (shishya.sattva - 10).coerceAtLeast(0)
                shishya.prana = (shishya.prana - 10).coerceAtLeast(0)
                BreakthroughResult(
                    success = false,
                    newChakraLevel = shishya.chakraLevel,
                    newSattva = shishya.sattva,
                    newPrana = shishya.prana,
                    isMoksha = false
                )
            }
        }
    }

    private fun calculateBreakthroughProbability(shishya: Shishya, yantraAccuracy: Double): Double {
        val baseChance = 0.30
        val sattvaBonus = (shishya.sattva / 100.0) * 0.30
        val karmaBonus = (shishya.karma / 200.0) * 0.20
        val pathBonus = when {
            shishya.path.name == shishya.gift.name -> 0.10
            else -> 0.0
        }
        val yantraBonus = yantraAccuracy * 0.40

        return (baseChance + sattvaBonus + karmaBonus + pathBonus + yantraAccuracy).coerceIn(0.0, 1.0)
    }
}

/**
 * Result of a breakthrough attempt.
 */
data class BreakthroughResult(
    val success: Boolean,
    val newChakraLevel: Int,
    val newSattva: Int,
    val newPrana: Int,
    val isMoksha: Boolean
)