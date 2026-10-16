package com.gurukul.core.state

/**
 * A single point captured during yantra drawing.
 */
data class YantraPoint(
    val x: Float,
    val y: Float,
    val timestampMs: Long
)

/**
 * The state of an in-progress yantra drawing.
 */
data class YantraState(
    val points: List<YantraPoint> = emptyList(),
    val isDrawing: Boolean = false,
    val isComplete: Boolean = false,
    val accuracy: Double = 0.0
) {

    fun withPoint(point: YantraPoint): YantraState =
        copy(points = points + point, isDrawing = true)

    fun complete(accuracy: Double): YantraState =
        copy(isComplete = true, accuracy = accuracy, isDrawing = false)

    fun reset(): YantraState =
        copy(points = emptyList(), isDrawing = false, isComplete = false, accuracy = 0.0)
}