package com.gurukul.core.model

/**
 * Core disciple model - a shishya with disposition, gift, and cultivation state.
 * This is the "unit" in the tycoon loop.
 */
data class Shishya(
    val id: String,
    val name: String,
    val samskara: Samskara,
    val gift: Gift,
    var path: Path,
    var chakraLevel: Int,
    var sattva: Int,  // 0-100 purity
    var karma: Int,    // -100 to +100
    var prana: Int,    // 0-100 energy for yantra training
    var inMoksha: Boolean = false
)

/**
 * Disposition - the shishya's innate character.
 * Determines which paths they're suited to.
 */
enum class Samskara {
    SATTVA,      // Pure, meditative - good for yoga, bhakti
    RAJAS,       // Active, ambitious - good for tantra, jnana
    TAMAS,       // Slow, stable - good for veda, bhakti
    MIXED        // Balanced - can take any path
}

/**
 * Natural gift - what this disciple is innately good at.
 * Affects training speed.
 */
enum class Gift {
    YOGA,      // Bodhisattva - fast chakra progress
    TANTRA,    // Ritualist - good yantra drawing
    VEDA,      // Scholar - fast text learning
    BHAKTI,    // Devotee - high sattva retention
    JNANA      // Seeker - fast insight
}

/**
 * Path - the doctrine the shishya trains under.
 * 5 paths, each with different yantra requirements.
 */
enum class Path {
    YOGA,    // Meditation-based
    TANTRA,  // Ritual/yantra-based
    VEDA,    // Scholarship
    BHAKTI,  // Devotion
    JNANA    // Knowledge
}
