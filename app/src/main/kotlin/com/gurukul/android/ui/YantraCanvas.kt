package com.gurukul.android.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTouchGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawArc
import androidx.compose.ui.graphics.drawscope.drawCircle
import androidx.compose.ui.graphics.drawscope.drawLine
import androidx.compose.ui.graphics.drawscope.drawPath
import androidx.compose.ui.graphics.drawscope.withTranslate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.gurukul.core.state.YantraState

@Composable
fun YantraCanvas(
    state: YantraState,
    onComplete: (accuracy: Double) -> Unit,
    modifier: Modifier = Modifier
) {
    var points by remember { mutableStateOf(state.points) }
    var isDrawing by remember { mutableStateOf(state.isDrawing) }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .detectTouchGestures(
                onPressStart = { offset ->
                    points = emptyList()
                    isDrawing = true
                },
                onPressMove = { offset ->
                    points = points + com.gurukul.core.state.YantraPoint(
                        x = offset.x,
                        y = offset.y,
                        timestampMs = System.currentTimeMillis()
                    )
                },
                onPressEnd = {
                    val accuracy = calculateYantraAccuracy(points)
                    state.complete(accuracy)
                    onComplete(accuracy)
                    isDrawing = false
                }
            )
    ) {
        // Draw guide lines (inverted triangle)
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radius = (size.width.min(size.height) * 0.4f).coerceAtLeast(10f)

        drawPath(
            color = androidx.compose.ui.graphics.Color(0xFF43A047), // Anahata Green
            style = androidx.compose.ui.graphics.Stroke(width = 2f),
            path = buildPath {
                moveTo(centerX, centerY - radius) // Top
                lineTo(centerX + radius, centerY + radius * 0.57f) // Bottom right
                lineTo(centerX - radius, centerY + radius * 0.57f) // Bottom left
                lineTo(centerX, centerY - radius) // Back to top
                close()
            }
        )

        // Draw user's traced path
        if (points.isNotEmpty()) {
            drawPath(
                color = androidx.compose.ui.graphics.Color(0xFFFFD700), // PranaGold
                style = androidx.compose.ui.graphics.Stroke(width = 3f),
                path = buildPath {
                    moveTo(points.first().x, points.first().y)
                    points.drop(1).forEach { point ->
                        lineTo(point.x, point.y)
                    }
                }
            )

            // Draw current touch point if drawing
            if (state.isDrawing && points.isNotEmpty()) {
                val last = points.last()
                drawCircle(
                    center = Offset(last.x, last.y),
                    radius = 4f,
                    color = androidx.compose.ui.graphics.Color(0xFFFFD700)
                )
            }
        }
    }
}

private fun calculateYantraAccuracy(points: List<com.gurukul.core.state.YantraPoint>): Double {
    if (points.isEmpty()) return 0.0

    val centerX = points.map { it.x }.average()
    val centerY = points.map { it.y }.average()

    // Ideal inverted triangle points (normalized 0-1)
    val idealPoints = listOf(
        Pair(0.5, 0.2), // Top
        Pair(0.8, 0.8), // Bottom right
        Pair(0.2, 0.8)  // Bottom left
    )

    // Normalize user points to 0-1 range relative to canvas bounds
    val minX = points.map { it.x }.fold(Float.MAX_VALUE) { acc, v -> if (v < acc) v else acc }
    val maxX = points.map { it.x }.fold(Float.MIN_VALUE) { acc, v -> if (v > acc) v else acc }
    val minY = points.map { it.y }.fold(Float.MAX_VALUE) { acc, v -> if (v < acc) v else acc }
    val maxY = points.map { it.y }.fold(Float.MIN_VALUE) { acc, v -> if (v > acc) v else acc }

    val normalizedPoints = points.map { point ->
        Pair(
            (point.x - minX) / (maxX - minX).coerceAtLeast(0.001f),
            (point.y - minY) / (maxY - minY).coerceAtLeast(0.001f)
        )
    }

    // Calculate average distance from each ideal point to nearest user point
    var totalDistance = 0.0
    for ((idealX, idealY) in idealPoints) {
        val minDist = normalizedPoints.map { (nx, ny) ->
            kotlin.math.sqrt(kotlin.math.pow(nx - idealX, 2) + kotlin.math.pow(ny - idealY, 2))
        }.fold(1.0) { acc, v -> if (v < acc) v else acc }
        totalDistance += minDist
    }

    val avgDistance = totalDistance / idealPoints.size
    return (1.0 - avgDistance).coerceIn(0.0, 1.0)
}